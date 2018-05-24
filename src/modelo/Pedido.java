package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

import utiles.Utiles;

public class Pedido implements Serializable {
	private int numero;
	private String item;

	public Pedido(String nombre) {
		super();
		this.item = nombre;
		ponerNumero();
	}

	private void ponerNumero() {
		Integer num = 0;
		String path = "./data/numeroUltimoPedido.data";
		if (Utiles.comprobarExiste(path)) {
			num = (Integer) new DAO<>().leer(path);
		}
		this.numero = num;
		num++;
		new DAO<>().grabar(path, num);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return item;
	}

	public void setNombre(String nombre) {
		this.item = nombre;

	}

	@Override
	public boolean equals(Object obj) {
		boolean retorno = super.equals(obj);
		if (!retorno) {
			Pedido pedido = (Pedido) obj;
			retorno = this.numero == pedido.numero;
		}
		return retorno;
	}

}
