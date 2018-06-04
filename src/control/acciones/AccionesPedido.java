package control.acciones;

import java.util.ArrayList;

import modelo.Cliente;
import modelo.Linea;
import modelo.Pedido;
import modelo.acceso.DAO;
import utiles.Utiles;
import modelo.Articulo;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import control.Logica;
import control.almacenes.AlmacenIndice;
import control.almacenes.AlmacenRuta;

public class AccionesPedido<K> {
	
	private Logica logica;

	public AccionesPedido(Logica logica) {
		this.logica = logica;
	}

	public boolean crear(Cliente cliente, DefaultTableModel modelo) {
		int numero = getNumeroPosiblePedido();
		Pedido pedido = new Pedido(numero, cliente);
		ArrayList<Linea> lineas = extraerPedidoRejilla(modelo);
		for (Linea linea : lineas) {
			pedido.insertarLinea(linea);
		}
		if ( logica.getDatos().grabar(pedido)) {
			aumentarNumeroPedido(numero);
			return true;
		}
		return false;

	}

	private void aumentarNumeroPedido(int numero) {
		new DAO<>().grabar(Utiles.pathNumerosPedido, numero + 1);
	}

	public int getNumeroPosiblePedido() {
		int leer = 0;
		if (Utiles.comprobarExiste(Utiles.pathNumerosPedido)) {
			leer = (int) new DAO<>().leer(Utiles.pathNumerosPedido);
		}
		return leer;
	}


	public void aniadirArticuloATabla(Articulo item, DefaultTableModel dm) {
		dm.addRow(introducirRejilla(item));
	}

	private Object[] introducirRejilla(Articulo item) {
		int cantidadAlAniadirse = 1;
		Object[] retorno = { item.getIdArticulo(), item.getNombre(), item.getCurrentPrice(), cantidadAlAniadirse,
				item.getCurrentPrice() * cantidadAlAniadirse };
		return retorno;
	}

	/**
	 * Introduce en un ArrayList del tipo que creeis los datos de un modelo de una
	 * tabla
	 * 
	 * @param modelo
	 * @return
	 */
	public ArrayList<Linea> extraerPedidoRejilla(TableModel modelo) {
		ArrayList<Linea> retorno = new ArrayList<>();
		int rows = modelo.getRowCount();
		for (int i = rows - 1; i >= 0; i--) {
			String nombreArticulo = modelo.getValueAt(i, 1).toString();
			int cantidad = Integer.parseInt(modelo.getValueAt(i, 3).toString());
			Articulo item = (Articulo) new AlmacenIndice<>(Utiles.pathArticulos).leer(nombreArticulo);
			retorno.add(new Linea(item, cantidad));
		}
		return retorno;
	}

	/**
	 * Vuelca los datos de un arraylist en un modelo de una tabla
	 * 
	 * @param pedido
	 * @param modelo
	 * @param cliente
	 * @param pedido
	 * @param listaObjeto
	 */

	public void introducirPedidoRejilla(JTable tabla, Pedido pedido) {
		DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
		for (int i = pedido.getLineas().size(); i > 0; i--) {
			modelo.addRow(pedido.getLinea(i).toVector());
		}
	}
	
	public void cambiarPrecioRejilla(DefaultTableModel modelo) {
		ArrayList<Linea> lineas = extraerPedidoRejilla(modelo);
		eliminarPedidoRejilla(modelo);
		for (int i = lineas.size() - 1; i >= 0; i--) {
			modelo.addRow(lineas.get(i).toVector());
		}
	}

	public void eliminarPedidoRejilla(DefaultTableModel modeloTabla) {
		int rows = modeloTabla.getRowCount();
		for (int i = rows - 1; i >= 0; i--) {
			modeloTabla.removeRow(i);
		}
	}

}
