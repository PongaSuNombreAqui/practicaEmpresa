package control;

import java.util.Set;
import java.util.TreeMap;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import modelo.Articulo;

public class AccionesArticulo {

	public boolean crearArticulo(String nombre, Float precio, int id, String descripcion) {
		Articulo newArticulo = new Articulo(id, nombre, descripcion, precio);
		Articulo item = (Articulo) new AlmacenArticulo<>().leer(nombre);//esto no tira
		if (item==null) {
			new AlmacenArticulo<>().grabar(newArticulo, id, nombre);
			return true;
		}
		return false;
	}

	public void consultar(String nombre, JLabel nombreArt, JLabel id, JLabel precio, JLabel descripcion) {
		Articulo item = (Articulo) new AlmacenArticulo<>().leer(nombre);
		nombreArt.setText(item.getNombre());
		id.setText(String.valueOf(item.getIdArticulo()));
		precio.setText(String.valueOf(item.getCurrentPrice()));
		descripcion.setText(item.getDescripcion());
	}

	public void editar(String nombre, float nuevoPrecio) {
		Articulo item = (Articulo) new AlmacenArticulo<>().leer(nombre);
		item.insertarNuevoPrecio(nuevoPrecio, false);// TODO oferta??
		System.out.println(item.getCurrentPrice());
		new AlmacenArticulo<>().grabar(item, item.getIdArticulo(), item.getNombre());
	}


	public void consultarPrecioAnterior(String nombreArt,String nuevoPrecio) {
		Articulo item = (Articulo) new AlmacenArticulo<>().leer(nombreArt);
//		item.insertarNuevoPrecio(nuevoPrecio, true);
//		return precio;

	}

	public void insertarArticulosEnCombo(JComboBox combo) {
		combo.removeAllItems();
		TreeMap indiceMap = new AlmacenArticulo<>().obtenerIndice();
		if (!(indiceMap==null)) {
			Set keySet = indiceMap.keySet();
			for (Object object : keySet) {
				combo.addItem(object);
			}
		}


	}
}
