package modelo;

public class LineaDePedido {
	private Articulo articulo;
	private int cantidad;

	public LineaDePedido(Articulo articulo, int cantidad) {
		super();
		this.articulo = articulo;
		this.cantidad = cantidad;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public int getCantidad() {
		return cantidad;
	}

}
