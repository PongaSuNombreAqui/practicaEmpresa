package utiles;

import java.io.File;
/**
 * 
 * @author fp-hermoso
 *
 */
public class Utiles {
	// rutas
	public static final String pathNumerosPedido = "./data/numeroUltimoPedido.data";
	public static final String pathArticulos = "./data/articulos/";
	public static final String pathClientes = "./data/clientes/";
	public static final String pathPedidos = "./data/pedidos/";
	public static final String separador =" ";
	public static final String main = "./data";
	/**
	 * comprueba que el archivo/directorio de la ruta introducida existe
	 * @param ruta ruta a buscar
	 * @return true si existe, false si no
	 */
	public static boolean comprobarExiste(String ruta) {
		File archivo = new File(ruta);
		return archivo.exists();
	}
}
