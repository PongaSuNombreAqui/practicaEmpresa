package test;

import java.time.LocalDate;
import java.util.ArrayList;

import control.AccionesPedido;
import control.AlmacenRuta;
import modelo.Articulo;
import modelo.Cliente;
<<<<<<< HEAD:src/pruebas/PruebaNumeroPedido.java
import modelo.Linea;
=======
>>>>>>> upstream/master:src/test/PruebaNumeroPedido.java
import modelo.Pedido;

public class PruebaNumeroPedido {
	
	public static void main(String[] args) {
		AccionesPedido acc = new AccionesPedido();
<<<<<<< HEAD:src/pruebas/PruebaNumeroPedido.java
		
//		LocalDate fecha = null;
//		Cliente cliente = new Cliente(1, "Prueba1", "123456789A");
//		Cliente cliente2 = new Cliente(2, "Prueba2", "987654321E");
		
//		ArrayList<LineaPedido> lineaPedido = new ArrayList<>();
//		lineaPedido.add(new LineaPedido(articulo, 3));
		
=======
//		MODELO CAMBIADO, NEW TEST
//		LocalDate fecha = null;
//		Cliente cliente = new Cliente(1, "Prueba1", "123456789A");
//		Cliente cliente2 = new Cliente(2, "Prueba2", "987654321E");
//		Articulo articulo = new Articulo(0, "PruebaArticulo", 15);
//		ArrayList<LineaPedido> lineaPedido = new ArrayList<>();
//		lineaPedido.add(new LineaPedido(articulo, 3));
//		
>>>>>>> upstream/master:src/test/PruebaNumeroPedido.java
//		ArrayList lineaPedido = new ArrayList<>();
//		acc.crear(lineaPedido, cliente2, fecha);
//		acc.crear(lineaPedido, cliente, fecha);
		
//		acc.consultar("123456789A", 0);
		
//		Articulo articulo = new Articulo(1, "pruebaA", "prueabD", 12);
//		ArrayList<Linea> lineaPedido = new ArrayList<>();
//		lineaPedido.add(new Linea(articulo, 2));
//		System.out.println(lineaPedido.get(0).getArticulo().getDescripcion());
		
		AlmacenPedido almacen = new AlmacenPedido();
		Pedido pedido = almacen.leer("dni4", 20);
//		System.out.println(pedido.getLineas().get(0).getArticulo().getNombre());
//		System.out.println(pedido.getLineas().get(1).getArticulo().getNombre());
		
		for (int i = 1; i <= pedido.getLineas().size(); i++) {
			System.out.println(pedido.getLinea(i));
		}
		
//		System.out.println(pedido.getLineas().size());
//		System.out.println(pedido.);
//		System.out.println(pedido.getLinea(2).getCantidad());
		
		
		
//		acc.consultar("dni5", 13);
//		
//		System.out.println(pedido.getCliente().getRazonSocial());
//		System.out.println(pedido.getFecha());
//		System.out.println(pedido.getLinea(1).getArticulo().getNombre());
//		System.out.println(pedido.getLineaPedido().get(0).getArticulo());
		
	}

}

