package control;

import javax.swing.JLabel;

import modelo.Articulo;

public class AccionesArticulo {

	public boolean crearArticulo(String nombre, int precio, int id) {
		Articulo newArticulo = new Articulo(id, nombre, precio);
		Articulo leer = (Articulo) new AlmacenArticulo<>().leer(nombre);
		if (newArticulo.getNombre() == leer.getNombre()) {
			return false;
		} else {
			new AlmacenArticulo<>().grabar(newArticulo, id, nombre);
			return true;
		}
	}

	public void consultar(String nombre, JLabel nombreArt, JLabel id, JLabel precio) {
		Articulo leer = (Articulo) new AlmacenArticulo<>().leer(nombre);
		nombreArt.setText(leer.getNombre());
		id.setText(String.valueOf(id));
		precio.setText(String.valueOf(precio));
	}

	public void editar(String nombre, int nuevoPrecio) {
		Articulo leer = (Articulo) new AlmacenArticulo<>().leer(nombre);
		leer.setPrecio(nuevoPrecio);
		new AlmacenArticulo<>().grabar(leer, leer.getId(), leer.getNombre());
	}

	/**
	 * 
	 * @param articulo
	 * 
	 * @return precio
	 */
	public String consultarPrecioAnterior(String articulo) {
		String precio = "";// Precio que estamos buscando
		return precio;

	}
}
