package modelo;

import java.io.Serializable;

public class Proveedor implements Serializable {
	private int numero;
	private String nombre;

	public Proveedor(int numero, String nombre) {
		super();
		this.numero = numero;
		this.nombre = nombre;

	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;

	}

	@Override
	public boolean equals(Object obj) {
		boolean retorno = super.equals(obj);
		if (!retorno) {
			Proveedor proveedor = (Proveedor) obj;
			retorno = this.numero == proveedor.numero;
		}
		return retorno;
	}
}
