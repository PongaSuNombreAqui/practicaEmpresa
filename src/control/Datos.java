package control;

import control.almacenes.AlmacenIndice;
import control.almacenes.AlmacenRuta;
import modelo.Articulo;
import modelo.Cliente;
import modelo.Pedido;
import utiles.Utiles;

public class Datos {

	
	public boolean grabar(Pedido pedido) {
		return new AlmacenRuta(Utiles.pathPedidos).grabar(pedido.getCliente().getDniCif(), pedido);
	}

	public boolean grabar(Articulo item) {
		return new AlmacenIndice<>(Utiles.pathArticulos).grabar(item, item.getIdArticulo(), item.getNombre());

	}
	
	public boolean grabar(Cliente cliente) {
		return new AlmacenIndice<>(Utiles.pathClientes).grabar(cliente, cliente.getDniCif());
	}
}
