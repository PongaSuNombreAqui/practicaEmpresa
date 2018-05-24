package modelo;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

import utiles.Utiles;

public class Pedido implements Serializable {
	private int numero;
	private Cliente cliente;
	private ArrayList<LineaPedido> lineaPedido;
	private LocalDate fecha;

	public Pedido(Cliente cliente, ArrayList<LineaPedido> lineaPedido, LocalDate fecha) {
		super();
		this.cliente = cliente;
		this.lineaPedido = lineaPedido;
		this.fecha = fecha;
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

	public ArrayList<LineaPedido> getLineaPedido() {
		return lineaPedido;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public LocalDate getFecha() {
		return fecha;
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
