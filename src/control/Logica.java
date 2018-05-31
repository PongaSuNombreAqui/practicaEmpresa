package control;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import control.acciones.AccionesArticulo;
import control.acciones.AccionesCliente;
import control.acciones.AccionesPedido;
import control.almacenes.AlmacenIndice;
import control.almacenes.AlmacenRuta;
import modelo.Articulo;
import modelo.Cliente;
import modelo.Pedido;
import utiles.Utiles;

public class Logica<K> {
	AccionesArticulo accionesArticulo;
	AccionesCliente accionesCliente;
	AccionesPedido accionesPedido;

	public Logica() {
		this.accionesArticulo = new AccionesArticulo();
		this.accionesCliente = new AccionesCliente();
		this.accionesPedido = new AccionesPedido();
	}

	public boolean comprobarExistencia(String nombreArt) {
		return accionesArticulo.comprobarExistencia(nombreArt);
	}

	public void consultar(String nombre, JLabel nombreArt, JLabel id, JLabel precio, JLabel descripcion) {
		Articulo item = (Articulo) new AlmacenIndice<>(Utiles.pathArticulos).leer(nombre);
		accionesArticulo.consultar(item, nombreArt, id, precio, descripcion);
	};

	public boolean crearArticulo(String nombre, Float precio, int id, String descripcion) {
		Articulo newArticulo = new Articulo(id, nombre, descripcion, precio);
		Articulo item = (Articulo) new AlmacenIndice<>(Utiles.pathArticulos).leer(nombre);
		if (item == null) {
			return accionesArticulo.crearArticulo(newArticulo, id, nombre);
		}
		return false;
	};

	public void insertarArticulosEnCombo(JComboBox combo) {
		accionesArticulo.insertarArticulosEnCombo(combo);
	};

	public void editar(String nombre, float nuevoPrecio) {
		Articulo item = (Articulo) new AlmacenIndice<>(Utiles.pathArticulos).leer(nombre);
		accionesArticulo.editar(item, nuevoPrecio);
	};

	public void aniadirArticuloATabla(JTable tabla, String nombre) {
		Articulo item = (Articulo) new AlmacenIndice<>(Utiles.pathArticulos).leer(nombre);
		accionesPedido.aniadirArticuloATabla(tabla, item);
	};

	public int getNumeroPosiblePedido() {
		return accionesPedido.getNumeroPosiblePedido();
	};

	public boolean crear(String dniNif, JTable tabla) {
		Cliente cliente = (Cliente) new AlmacenIndice<>(Utiles.pathClientes).leer((K) dniNif);
		return accionesPedido.crear(cliente, tabla);
	};

	public void consultar(JTable tabla, int numeroPedido, String id) {
		Pedido pedido = new AlmacenRuta(Utiles.pathPedidos).leer(id, numeroPedido);
		accionesPedido.consultar(tabla, pedido);
	};

	public void insertarClientesEnCombo(JComboBox combo) {
		accionesCliente.insertarClientesEnCombo(combo);
	}

	public void insertarPedidosEnCombo(JComboBox combo, String cadena) {
		accionesCliente.insertarPedidosEnCombo(combo, cadena);
	}

}
