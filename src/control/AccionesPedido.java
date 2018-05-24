package control;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Articulo;

public class AccionesPedido {

	
	
	private Object[] introducirRejilla(Articulo item) {
		int cantidadAlAniadirse = 1 ;
		Object[] retorno = { item.getId(), item.getNombre(), item.getPrecio() ,cantidadAlAniadirse,item.getPrecio()*cantidadAlAniadirse};
		return retorno;
	}

	public void añadirArticuloATabla(JTable tabla, String nombre) {
		DefaultTableModel dm=(DefaultTableModel)tabla.getModel();
		Articulo item = new AlmacenArticulo<Articulo>().leer(nombre);
		dm.addRow(introducirRejilla(item));
	}
}
