package control;

import java.io.File;
import java.util.TreeMap;

import modelo.DAO;
import utiles.Utiles;

public class AlmacenArticulo<T> {

	private StringBuilder pathDatos = new StringBuilder("./data/articulos/");
	private String pathIndice;
	private TreeMap<String, Integer> indice; // la clave es el nombre(o eso veo yo)
	private int lenghtDir;

	public AlmacenArticulo() {
		super();
		this.indice = new TreeMap<>();
		File file = new File(pathDatos.toString());
		if (!file.exists()) {
			file.mkdirs();
		}
		this.pathIndice = pathDatos + "indice.data";
		this.lenghtDir = pathDatos.length();
	}

	public boolean grabar(T t, Integer numero, String nombre) {
		boolean retorno = false;
		this.pathDatos.append(numero + ".art");
		boolean grabar = new DAO<>().grabar(pathDatos.toString(), t);
		if (Utiles.comprobarExiste(pathIndice)) {// si el indice existe se tendria que pillar
			indice = (TreeMap<String, Integer>) new DAO().leer(pathIndice);
		}
		if (grabar) {
			indice.put(nombre, numero);
			retorno = new DAO<>().grabar(pathIndice, this.indice);
			this.pathDatos.delete(lenghtDir, pathDatos.length());
		}
		return retorno;
	}

	public T leer(String nombre) {
		T retorno = null;
		if (Utiles.comprobarExiste(pathIndice)) {
			indice = (TreeMap<String, Integer>) new DAO().leer(pathIndice);
			Integer nombreArch = indice.get(nombre);
			pathDatos.append(nombreArch + ".art");
			retorno = (T) new DAO<>().leer(pathDatos.toString());
			this.pathDatos.delete(lenghtDir, pathDatos.length());
		}
		return retorno;
	}

	public TreeMap obtenerIndice() {
		return (TreeMap) new DAO<>().leer(pathIndice);
		
	}
}
