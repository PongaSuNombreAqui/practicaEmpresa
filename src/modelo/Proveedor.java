package modelo;

import java.io.Serializable;

public class Proveedor implements Serializable, Comparable<Proveedor> {
	private String nombre;

	public Proveedor(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return String.valueOf(nombre);
	}

	@Override
	public int compareTo(Proveedor o) {
		return nombre.compareTo(o.nombre);
	}

}
