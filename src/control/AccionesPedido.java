package control;

import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Cliente;
import modelo.DAO;
import modelo.Linea;
import modelo.Pedido;
import utiles.Utiles;
import modelo.Articulo;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class AccionesPedido<K> {

	public boolean crear(String dniNif, TableModel modelo) {
		Cliente cliente = (Cliente) new AlmacenIndice<>(Utiles.pathClientes).leer((K)dniNif);
		int numero=getNumeroPosiblePedido();
		Pedido pedido = new Pedido(numero, cliente);
		ArrayList<Linea> lineas = extraerPedidoRejilla(modelo);
		for (Linea linea : lineas) {
			pedido.insertarLinea(linea);
		}
		AlmacenRuta almacen = new AlmacenRuta(Utiles.pathPedidos);
		if(almacen.grabar(cliente.getDniCif(), pedido)){
			aumentarNumeroPedido(numero);
			return true;
		}
		return false;
	}
	
	private void aumentarNumeroPedido(int numero) {
		new DAO<>().grabar(Utiles.pathNumerosPedido,numero+1);
	}

	public int getNumeroPosiblePedido(){
		int leer = 0;
		if(Utiles.comprobarExiste(Utiles.pathNumerosPedido)){
			leer = (int) new DAO<>().leer(Utiles.pathNumerosPedido); 
		}
		return leer;
	}
	
	public void consultar(JTable tabla, int numeroPedido, String id) {
	AlmacenRuta almacen = new AlmacenRuta(Utiles.pathPedidos);
		Pedido pedido = almacen.leer(id, numeroPedido);
		introducirPedidoRejilla(tabla, pedido);
	}
	
	public void aniadirArticuloATabla(JTable tabla, String nombre) {
		DefaultTableModel dm = (DefaultTableModel) tabla.getModel();
		Articulo item = (Articulo) new AlmacenIndice<>(Utiles.pathArticulos).leer(nombre);
		dm.addRow(introducirRejilla(item));
	}
	private Object[] introducirRejilla(Articulo item) {
		int cantidadAlAniadirse = 1;
		Object[] retorno = { item.getIdArticulo(), item.getNombre(), item.getCurrentPrice(), cantidadAlAniadirse,
				item.getCurrentPrice() * cantidadAlAniadirse };
		return retorno;
	}
	
	/**
	 * Introduce en un ArrayList del tipo que creeis los datos
	 * de un modelo de una tabla
	 * @param modelo
	 * @return
	 */
	public ArrayList<Linea> extraerPedidoRejilla(TableModel modelo){
		ArrayList<Linea> retorno = new ArrayList<>();
		AlmacenArticulo almacen = new AlmacenArticulo();
		int rows = modelo.getRowCount(); 
		for(int i = rows - 1; i >=0; i--)	
		{
			String nombreArticulo = modelo.getValueAt(i, 1).toString();
			int cantidad = Integer.parseInt(modelo.getValueAt(i, 3).toString());
			Articulo item = new AlmacenArticulo<Articulo>().leer(nombreArticulo);
			retorno.add(new Linea(item, cantidad));
		}
		return retorno;
	}
	/**
	 * Vuelca los datos de un arraylist en un modelo de una tabla
	 * @param pedido 
	 * @param modelo
	 * @param cliente 
	 * @param pedido 
	 * @param listaObjeto
	 */
	public void introducirPedidoRejilla(JTable tabla, Pedido pedido){
		DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
		for (int i = pedido.getLineas().size(); i > 0; i--) {
			modelo.addRow(pedido.getLinea(i).toVector());
		}
	}

}
