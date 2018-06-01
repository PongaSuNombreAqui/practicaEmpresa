package control.almacenes;

import java.io.File;
import java.util.TreeSet;

import modelo.Proveedor;
import modelo.acceso.DAO;
import utiles.Utiles;
/**
 * 
 * @author fp-hermoso
 *
 */
public class AlmacenProveedores {

	private TreeSet<Proveedor> lista; // esto tendria que ser un set, pero no tira (?)
	private StringBuilder pathComun = new StringBuilder("./data/proveedores");

	public AlmacenProveedores() {
		super();
		this.lista = new TreeSet<>();
		if (!Utiles.comprobarExiste(pathComun.toString())) {
			File file = new File(pathComun.toString());
			file.mkdirs();
		}
		this.pathComun.append("/proveedores.data");
	}

	public boolean grabar(Proveedor t) {
		boolean retorno = false;
		lista.add(t);
		retorno = new DAO<>().grabar(pathComun.toString(), lista);
		return retorno;
	}

	public TreeSet<Proveedor> obtener() {
		TreeSet<Proveedor> retorno = null;
		if (Utiles.comprobarExiste(pathComun.toString())) {
			retorno = (TreeSet<Proveedor>) new DAO().leer(pathComun.toString());
		}
		return retorno;
	}

}
