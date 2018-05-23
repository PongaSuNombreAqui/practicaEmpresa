package modelo;

import java.io.Serializable;

public class Articulo implements Serializable {
	private int id;
	private String nombre;
	private float precio;

	public Articulo(int id, String nombre, float precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public boolean equals(Object obj) {
		boolean retorno = super.equals(obj);
		if (!retorno) {
			Articulo articulo = (Articulo) obj;
			retorno = this.id == articulo.getId();
		}
		return retorno;
	}
}
