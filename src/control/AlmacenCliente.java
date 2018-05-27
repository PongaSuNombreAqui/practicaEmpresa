package control;

import java.io.File;
import java.util.TreeMap;

import modelo.DAO;
import utiles.Utiles;

public class AlmacenCliente<T, K> {

	private StringBuilder pathDatos = new StringBuilder("./data/clientes/");
	private String pathIndice;
	private TreeMap<K, Integer> indice;

	public AlmacenCliente() {
		super();
		this.indice = new TreeMap<>();
		File file = new File(pathDatos.toString());
		if (!file.exists()) {
			file.mkdirs();
		}
		this.pathIndice = pathDatos + "indice.data";
		this.pathDatos.append("clientes.data");
	}

	public boolean grabar(T t, K k) {
		boolean retorno = false;
		if (k != null) {
			boolean grabar = new DAO<>().grabar(pathDatos.toString(), t, true);
			if (grabar) {
				try {
					indice.put(k, indice.lastEntry().getValue() + 1);
				} catch (NullPointerException e) {
					indice.put(k, 0);
				}
				retorno = new DAO<>().grabar(pathIndice.toString(), indice);
			}
		}
		return retorno;
	}

	public T obtener(K k) {
		indice = (TreeMap<K, Integer>) new DAO<T>().leer(pathIndice.toString());
		Integer posicion = (Integer) indice.get(k);
		T retorno = null;
		if (posicion != null) {
			retorno = (T) new DAO<>().leer(pathDatos.toString(), posicion);
		}
		return retorno;
	}
	
	public TreeMap obtenerMap(){
		if(Utiles.comprobarExiste(pathIndice)){
		return (TreeMap<K, Integer>) new DAO<T>().leer(pathIndice.toString());
		}
		return null;
	}
}
