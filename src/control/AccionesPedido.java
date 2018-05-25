package control;

import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Cliente;
import modelo.DAO;
import modelo.LineaPedido;
import modelo.Pedido;
import utiles.Utiles;
import modelo.Articulo;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AccionesPedido {

	public boolean crear(ArrayList<LineaPedido> lineaPedido, int numeroCliente) {
		LocalDate fecha = null;//TODO hay que poner que entre la fecha aqui
		Cliente cliente = (Cliente) new AlmacenCliente<>().obtener(numeroCliente);
		int numero=getNumeroPosiblePedido();
		Pedido pedido = new Pedido(cliente, lineaPedido, fecha,numero);
		AlmacenPedido almacen = new AlmacenPedido();
		if(almacen.grabar(cliente.getID(), pedido)){
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
		Object[] retorno = { item.getId(), item.getNombre(), item.getPrecio(), cantidadAlAniadirse,
				item.getPrecio() * cantidadAlAniadirse };
		return retorno;
	}
}
