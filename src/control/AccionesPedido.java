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

public class AccionesPedido {

	public boolean crear( String dniNif) {
		Cliente cliente = (Cliente) new AlmacenCliente<>().obtener(dniNif);
		int numero=getNumeroPosiblePedido();
		Pedido pedido = new Pedido(numero, cliente);
		AlmacenPedido almacen = new AlmacenPedido();
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
	
	public void consultar(String id, int numeroPedido) {
		AlmacenPedido almacen = new AlmacenPedido();
		Pedido pedido = almacen.leer(id, numeroPedido);
		// ?

	}
	public void aniadirArticuloATabla(JTable tabla, String nombre) {
		DefaultTableModel dm = (DefaultTableModel) tabla.getModel();
		Articulo item = new AlmacenArticulo<Articulo>().leer(nombre);
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
		//TODO 
		return retorno;
	}
	/**
	 * Vuelca los datos de un arraylist en un modelo de una tabla
	 * @param modelo
	 * @param listaObjeto
	 */
	public void introducirPedidoRejilla(TableModel modelo,ArrayList<Linea> listaObjeto){
		//TODO
	}

}
