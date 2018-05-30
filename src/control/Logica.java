package control;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import control.acciones.AccionesArticulo;
import control.acciones.AccionesCliente;
import control.acciones.AccionesPedido;

public class Logica {
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
		accionesArticulo.consultar(nombre, nombreArt, id, precio, descripcion);
	};

	public boolean crearArticulo(String nombre, Float precio, int id, String descripcion) {
		return accionesArticulo.crearArticulo(nombre, precio, id, descripcion);
	};

	public void insertarArticulosEnCombo(JComboBox combo) {
		accionesArticulo.insertarArticulosEnCombo(combo);
	};

	public void editar(String nombre, float nuevoPrecio) {
		accionesArticulo.editar(nombre, nuevoPrecio);
	};

	public void aniadirArticuloATabla(JTable tabla, String nombre) {
		accionesPedido.aniadirArticuloATabla(tabla, nombre);
	};

	public int getNumeroPosiblePedido() {
		return accionesPedido.getNumeroPosiblePedido();
	};

	public boolean crear(String dniNif, TableModel modelo) {
		return accionesPedido.crear(dniNif, modelo);
	};

	public void consultar(JTable tabla, int numeroPedido, String id) {
		accionesPedido.consultar(tabla, numeroPedido, id);
	};

	public void insertarClientesEnCombo(JComboBox combo) {
		accionesCliente.insertarClientesEnCombo(combo);
	}

	public void insertarPedidosEnCombo(JComboBox combo, String cadena) {
		accionesCliente.insertarPedidosEnCombo(combo, cadena);
	}

}
