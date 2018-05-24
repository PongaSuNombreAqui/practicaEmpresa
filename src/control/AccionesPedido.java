package control;

import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Cliente;
import modelo.LineaPedido;
import modelo.Pedido;


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
}