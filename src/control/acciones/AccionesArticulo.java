package control.acciones;

import java.util.Set;
import java.util.TreeMap;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import control.almacenes.AlmacenIndice;
import modelo.Articulo;
import utiles.Utiles;
import vista.PanelArticulo;

public class AccionesArticulo {

	public boolean crearArticulo(Object newArticulo,  int id, String nombre ) {
		return new AlmacenIndice<>(Utiles.pathArticulos).grabar(newArticulo, id, nombre);
	}

	public void consultar(Articulo item, JLabel nombreArt, JLabel id, JLabel precio, JLabel descripcion) {
		nombreArt.setText(item.getNombre());
		id.setText(String.valueOf(item.getIdArticulo()));
		precio.setText(String.valueOf(item.getCurrentPrice()));
		descripcion.setText(item.getDescripcion());
	}

	public void editar(Articulo item, float nuevoPrecio) {
		item.insertarNuevoPrecio(nuevoPrecio, false);
		new AlmacenIndice<>(Utiles.pathArticulos).grabar(item, item.getIdArticulo(), item.getNombre());
	}

	public void consultarPrecioAnterior(String nombreArt, String nuevoPrecio) {
		Articulo item = (Articulo) new AlmacenIndice<>(Utiles.pathArticulos).leer(nombreArt);
		// item.insertarNuevoPrecio(nuevoPrecio, true);
		// return precio;

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

	public boolean comprobarExistencia(String nombreArt) {
		Articulo item = (Articulo) new AlmacenIndice<>(Utiles.pathArticulos).leer(nombreArt);
		if (item == null) {
			return false;
		}
		return true;
	}
}
