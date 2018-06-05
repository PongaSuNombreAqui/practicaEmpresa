package modelo.acceso;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

//Data Access Object

public class DAO<T> {
	class MyObjectOutputStream extends ObjectOutputStream {

		public MyObjectOutputStream(OutputStream out) throws IOException {
			super(out);
		}

		@Override
		protected void writeStreamHeader() throws IOException {
		}
	}

	public Object leer(String path) {
		return leer(path, 0);
	}

	public Object leer(String path, int posicion) {
		FileInputStream flujoR = abrirFlujoLectura(path);
		ObjectInputStream adaptadorR = null;
		Object obj = null;
		try {
			if (flujoR != null) {
				adaptadorR = new ObjectInputStream(flujoR);
				for (int i = 0; i < posicion; i++) {
					obj = adaptadorR.readObject();
				}
				obj = adaptadorR.readObject();
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		cerrar(flujoR);
		return obj;
	}

	public boolean grabar(String path, Object t) {
		return grabar(path, t, false);
	}

	/**
	 * 
	 * @param path
	 *            :es la ruta del archivo donde se guardara
	 * @param t
	 *            : es el objeto a guardar
	 * @param adicion
	 *            :false para añadir cabecera, true para no
	 * @return :false si falla al escribir
	 */
	public boolean grabar(String path, Object t, boolean adicion) {
		File file = new File(path);
		boolean retorno = true;
		boolean existe = file.exists() && adicion;
		FileOutputStream flujoW = abrir(path, adicion);
		try {
			ObjectOutputStream adaptadorW = null;
			if (!existe) {
				adaptadorW = new ObjectOutputStream(flujoW);
			} else {
				adaptadorW = new MyObjectOutputStream(flujoW);
			}
			adaptadorW.writeObject(t);
		} catch (IOException e) {
			e.printStackTrace();
			retorno = false;
		}
		cerrar(flujoW);
		return retorno;
	}

	private boolean cerrar(Closeable input) {
		boolean retorno = true;
		try {
			input.close();
		} catch (IOException e) {
			retorno = false;
		}
		return retorno;
	}

	private FileOutputStream abrir(String path, boolean adicion) {
		FileOutputStream flujoW = null;
		File file = new File(path);
		try {
			flujoW = new FileOutputStream(file, adicion);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return flujoW;
	}

	private FileOutputStream abrir(String path) {
		return abrir(path, false);
	}

	private FileInputStream abrirFlujoLectura(String path) {
		File file = new File(path);
		FileInputStream flujoR = null;
		if (file.exists()) {
			try {
				flujoR = new FileInputStream(file);
			} catch (FileNotFoundException e) {
			}
		}
		return flujoR;
	}
////
	public boolean borrarElemento(String pathDatos, Integer posicion) {
		int i = 0;
		boolean retorno=true;
		T t = leerT(pathDatos, i);
		while (t != null) {
			if (i != posicion) {
				grabar("copia", t, true);
			}
			i++;
			t = leerT(pathDatos, i);
		}
		File original=new File(pathDatos);
		File copia=new File("copia");
		if(!original.delete()||!copia.renameTo(original)){
			retorno=false;
		}
		return retorno;
	}
	
	public T leerT(String path) {
		return leerT(path, 0);
	}

	public T leerT(String path, int posicion) {
		assert path != null && posicion >= 0;
		T t = null;
		FileInputStream flujoR = abrirT(path);
		if (flujoR != null) {
			try {
				ObjectInputStream adaptador = new ObjectInputStream(flujoR);
				for (int i = 0; i <= posicion; i++) {
					t = (T) adaptador.readObject();
				}
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
				t = null;
			}
			cerrarFlujo(flujoR);
		}
		return t;
	}
	
	private FileInputStream abrirT(String path) {
		FileInputStream flujoR = null;
		File file = new File(path);
		try {
			if (file.exists()) {
				flujoR = new FileInputStream(path);
			}
		} catch (FileNotFoundException e) {
		}
		return flujoR;
	}

	private FileOutputStream abrirT(String path, boolean adicion) {
		// no hay assert porque ya habria saltado en el public
		FileOutputStream flujoW = null;
		File file = new File(path);
		try {
			flujoW = new FileOutputStream(file, adicion);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return flujoW;

	}
	private boolean cerrarFlujo(Closeable closeable) {
		boolean retorno = true;
		try {
			closeable.close();
		} catch (IOException e) {
			retorno = false;
		}
		return retorno;
	}
}


