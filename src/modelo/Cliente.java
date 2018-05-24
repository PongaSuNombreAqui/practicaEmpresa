package modelo;

import java.io.Serializable;

public class Cliente implements Serializable {
	private int numero;
	private String nombre;
	private String ID;

	public Cliente(int numero, String nombre, String ID) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.ID = ID;
	}

	public String getID() {
		return this.ID;
	}

	public void setID(String ID) {
		this.ID = ID;
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
			Cliente cliente = (Cliente) obj;
			retorno = this.ID.equals(cliente.ID);
		}
		return retorno;
	}
}
