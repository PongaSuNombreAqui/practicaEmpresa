package control;

import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Cliente;
import modelo.LineaPedido;
import modelo.Pedido;
import modelo.Articulo;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AccionesPedido {

	public void crear(ArrayList<LineaPedido> lineaPedido, Cliente cliente, LocalDate fecha) {
		Pedido pedido = new Pedido(cliente, lineaPedido, fecha);
		pedido = new Pedido(cliente, lineaPedido, fecha);
		AlmacenPedido almacen = new AlmacenPedido();

		almacen.grabar(cliente.getID(), pedido);
	}

	public void consultar(String id, int numeroPedido) {
		AlmacenPedido almacen = new AlmacenPedido();
		Pedido pedido = almacen.leer(id, numeroPedido);
		// ?

	}

	private Object[] introducirRejilla(Articulo item) {
		int cantidadAlAniadirse = 1;
		Object[] retorno = { item.getId(), item.getNombre(), item.getPrecio(), cantidadAlAniadirse,
				item.getPrecio() * cantidadAlAniadirse };
		return retorno;
	}

	public void añadirArticuloATabla(JTable tabla, String nombre) {
		DefaultTableModel dm = (DefaultTableModel) tabla.getModel();
		Articulo item = new AlmacenArticulo<Articulo>().leer(nombre);
		dm.addRow(introducirRejilla(item));

	}
}
