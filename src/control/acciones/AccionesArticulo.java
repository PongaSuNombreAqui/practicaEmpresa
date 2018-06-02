package control.acciones;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import control.Logica;
import control.almacenes.AlmacenIndice;
import modelo.Articulo;
import utiles.Utiles;

public class AccionesArticulo {

	public void consultar(Articulo item, JLabel nombreArt, JLabel id, JLabel precio, JLabel descripcion) {
		nombreArt.setText(item.getNombre());
		id.setText(String.valueOf(item.getIdArticulo()));
		precio.setText(String.valueOf(item.getCurrentPrice()));
		descripcion.setText(item.getDescripcion());
	}

	public void editar(Articulo item, float nuevoPrecio, Logica logica) {
		item.insertarNuevoPrecio(nuevoPrecio, false);
		logica.getDatos().grabar(item);
	}

	public void insertarArticulosEnCombo(JComboBox combo) {
		combo.removeAllItems();
		TreeMap indiceMap = new AlmacenIndice<>(Utiles.pathArticulos).obtenerIndice();
		if (!(indiceMap == null)) {
			Set keySet = indiceMap.keySet();
			for (Object object : keySet) {
				combo.addItem(object);
			}
		}

	}

	public boolean comprobarExistencia(Articulo item) {
		if (item == null) {
			return false;
		}
		return true;
	}

	public float comprobarPrecio(Articulo item, GregorianCalendar date) {
		return item.getOldPrice(date);
	}
}
