package control.almacenes;

import java.io.File;
import java.util.TreeMap;
import java.util.Map.Entry;

import modelo.Indexable;
import modelo.acceso.DAO;
import utiles.Utiles;
/**
 * 
 * @author fp-hermoso
 *
 * @param <T> object que guarda
 * @param <K> key para guardarlo
 */
public class AlmacenIndice<T, K> {

	private StringBuilder pathDatos;
	private String pathIndice;
	private TreeMap<K, Integer> indice;

	public AlmacenIndice(String path) {
		super();
		this.pathDatos = new StringBuilder(path);
		File file = new File(pathDatos.toString());
		if (!file.exists()) {
			file.mkdirs();
		}
		this.pathIndice = pathDatos + "indice.data";
		if (Utiles.comprobarExiste(pathIndice)) {
			this.indice = (TreeMap<K, Integer>) new DAO().leer(pathIndice);
		} else {
			this.indice = new TreeMap<>();
		}
	}

	/**
	 * graba un cliente en un fichero con indice
	 * 
	 * @param t
	 *            es el objeto cliente
	 * @param k
	 *            es la clave,
	 * @return true si se graba, false si no
	 */
	public boolean grabar(T t, K k) {
		this.pathDatos.append("clientes.data");
		assert k != null && t != null;
		boolean retorno = false;
		
//		int lastEntry = indice.size();
//		Integer value = lastEntry++;
		
		Integer value=0;
		Entry<K, Integer> lastEntry = indice.lastEntry();
		if (lastEntry != null) {
			value = lastEntry.getValue() + 1;
		}
		while(indice.containsValue(value)){
			value++;
		}
		
		if (indice.put(k, value) == null) {
			if (new DAO<>().grabar(pathDatos.toString(), t, true)) {
				retorno = true;
				new DAO<>().grabar(pathIndice, indice);
			} 
			System.out.println(indice);
		}
		return retorno;
	}


	/**
	 * leer un objeto cliente desde el dni
	 * 
	 * @param k
	 *            es el dniCif del cliente a leer
	 * @return
	 */
	public T leer(K k) {
		this.pathDatos.append("clientes.data");
		indice = (TreeMap<K, Integer>) new DAO<T>().leer(pathIndice.toString());
		Integer posicion = (Integer) indice.get(k);
		T retorno = null;
		if (posicion != null) {
			retorno = (T) new DAO<>().leer(pathDatos.toString(), posicion);
		}
		return retorno;
	}
	
	
//	public boolean borrar(K k) {
//		Object retorno = null;
//		this.pathDatos.append("clientes.data");
//		indice = (TreeMap<K, Integer>) new DAO<T>().leer(pathIndice.toString());
//		Integer posicion=indice.remove(k);
//		if(posicion!=null){
//			retorno = new DAO<>().borrarElemento(pathDatos.toString(),posicion);
//		}
//		return new DAO<>().grabar(pathIndice, indice);
//	}

	public boolean borrar(K k){
		indice = (TreeMap<K, Integer>) new DAO().leer(pathIndice);
		boolean retorno=false;
		if(indice.containsKey(k)){
			Integer posicion=indice.remove(k);
			if(posicion!=null){
				retorno=new DAO<>().borrarElemento(pathDatos.toString(),posicion);
				if(!retorno){
					indice = (TreeMap<K, Integer>) new DAO().leer(pathIndice);
				}else{
					recargaIndice();
					new DAO<>().grabar(pathIndice, indice);
				}
				
			}
		}
		return retorno;
	}


	/**
	 * grabar un objeto articulo en el fichero
	 * 
	 * @param t
	 *            el objeto articulo
	 * @param numero
	 *            el ID del articulo
	 * @param nombre
	 *            el nombre del articulo
	 * @return true si se graba, false si no
	 */
	public boolean grabar(T t, Integer numero, String nombre) {
		boolean retorno = false;
		this.pathDatos.append(numero + ".art");
		boolean grabar = new DAO<>().grabar(pathDatos.toString(), t);
		if (Utiles.comprobarExiste(pathIndice)) {
			indice = (TreeMap<K, Integer>) new DAO().leer(pathIndice);
		}
		if (grabar) {
			indice.put((K) nombre, numero);
			retorno = new DAO<>().grabar(pathIndice, this.indice);
		}
		return retorno;
	}

	/**
	 * lee un objeto articulo con el nombre dado
	 * 
	 * @param nombre
	 * @return el objeto articulo
	 */
	public T leer(String nombre) {
		T retorno = null;
		if (Utiles.comprobarExiste(pathIndice)) {
			indice = (TreeMap<K, Integer>) new DAO().leer(pathIndice);
			Integer nombreArch = indice.get(nombre);
			if (nombreArch != null) {
				pathDatos.append(nombreArch + ".art");
				retorno = (T) new DAO<>().leer(pathDatos.toString());
			}
		}
		return retorno;
	}

	public TreeMap obtenerIndice() {
		if (Utiles.comprobarExiste(pathIndice)) {
			return (TreeMap) new DAO<>().leer(pathIndice);
		}
		return null;
	}

	public TreeMap obtenerMap() {
		if (Utiles.comprobarExiste(pathIndice)) {
			return (TreeMap) new DAO<T>().leer(pathIndice);
		}
		return null;
	}
	
	private void recargaIndice() {
		indice=new TreeMap<>();
		int posicion=0;
		T t=(T) new DAO<>().leer(pathDatos.toString(), posicion);
		while (t!=null){
			Indexable<K> elemento=(Indexable<K>) t;
			K k=elemento.getKey();
			indice.put(k, posicion);
			posicion++;
			t=(T) new DAO<>().leer(pathDatos.toString(), posicion);
		}
		
	}
}
