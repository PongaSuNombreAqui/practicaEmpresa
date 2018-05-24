package control;

import java.io.File;

import modelo.DAO;
import modelo.Pedido;
import utiles.Utiles;

public class AlmacenPedido {
	private StringBuilder pathComun = new StringBuilder("./data/pedidos/");
	private int lenghtDir;

	public AlmacenPedido() {
		super();
		File file = new File(pathComun.toString());
		if (!file.exists()) {
			file.mkdirs();
		}
		this.lenghtDir = pathComun.length();
	}

	public boolean grabar(String id, Pedido pedido) {
		boolean retorno = false;
		pathComun.append(id);
		if (!Utiles.comprobarExiste(pathComun.toString())) {
			File directorio = new File(pathComun.toString());
			directorio.mkdirs();
		}
		pathComun.append("/" + pedido.getNumero() + ".ped");
		retorno = new DAO<>().grabar(pathComun.toString(), pedido);
		this.pathComun.delete(lenghtDir, pathComun.length());
		return retorno;
	}

	public Pedido leer(String id, int numeroPedido) {
		pathComun.append(id + "/" + numeroPedido + ".ped");
		Pedido retorno = null;
		retorno = (Pedido) new DAO<>().leer(pathComun.toString());
		this.pathComun.delete(lenghtDir, pathComun.length());
		return retorno;
	}

}
