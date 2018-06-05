package control;

import java.time.ZoneId;
import java.util.GregorianCalendar;
import java.util.TreeMap;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import control.acciones.AccionesArticulo;
import control.acciones.AccionesCliente;
import control.acciones.AccionesPedido;
import control.almacenes.AlmacenIndice;
import control.almacenes.AlmacenRuta;
import modelo.Articulo;
import modelo.Cliente;
import modelo.Pedido;
import utiles.Utiles;
/**
 * 
 * @author fp-hermoso
 *
 * @param <K> clave para el almacenIndice
 */
public class Logica<K> {
	Datos datos;
	AccionesArticulo accionesArticulo;
	AccionesCliente<K> accionesCliente;
	AccionesPedido accionesPedido;

	public Logica() {
		this.datos=new Datos();
		this.accionesArticulo = new AccionesArticulo();
		this.accionesCliente = new AccionesCliente<>();
		this.accionesPedido = new AccionesPedido<Object>(this);
	}
	/**
	 * comprueba la existencia de un Articulo
	 * @param nombreArt el nombre del articulo
	 * @return true si existe, false si no existe
	 */
	public boolean comprobarExistencia(String nombreArt) {
		Articulo item = (Articulo) new AlmacenIndice<>(Utiles.pathArticulos).leer(nombreArt);
		return accionesArticulo.comprobarExistencia(item);
	}
	/**
	 * Introduce los datos del articulo buscado en los referentes labels
	 * @param nombre nombre del articulo
	 * @param nombreArt	label nombre
	 * @param id	label id
	 * @param precio	label precio
	 * @param descripcion	label descripcion
	 */
	public void consultar(String nombre, JLabel nombreArt, JLabel id, JLabel precio, JLabel descripcion) {
		Articulo item = (Articulo) new AlmacenIndice<>(Utiles.pathArticulos).leer(nombre);
		accionesArticulo.consultar(item, nombreArt, id, precio, descripcion);
	};
	/**
	 * Crea un articulo segun los datos introducidos
	 * @param nombre	nombre del articulo a crear
	 * @param precio	precio del articulo a crear
	 * @param id	id del articulo a crear
	 * @param descripcion	descripcion del articulo a crear
	 * @return true si se ha creado bien, false si no se ha podido crear
	 */
	public boolean crearArticulo(String nombre, Float precio, int id, String descripcion) {
		Articulo newArticulo = new Articulo(id, nombre, descripcion, precio);
		Articulo item = (Articulo) new AlmacenIndice<>(Utiles.pathArticulos).leer(nombre);
		if (item == null) {
			return datos.grabar(newArticulo);
		}
		return false;
	};
	/**
	 * inserta los articulos existentes en un comboBos dado
	 * @param combo comboBox donde se quieren insertar los articulos
	 */
	public void insertarArticulosEnCombo(JComboBox<Object> combo) {
		accionesArticulo.insertarArticulosEnCombo(combo);
	};
	/**
	 * edita el precio de un articulo existente
	 * @param nombre nombre del articulo a editar
	 * @param nuevoPrecio	nuevo precio del articulo
	 */
	public void editar(String nombre, float nuevoPrecio) {
		Articulo item = (Articulo) new AlmacenIndice<>(Utiles.pathArticulos).leer(nombre);
		accionesArticulo.editar(item, nuevoPrecio,this);
	};
	
	/**
	 * Agrega cliente a la base de datos
	 * @param dniCif			DNI o CIF del cliente
	 * @param razonSocial		Nombre del cliente
	 * @param direccion			Direccion del cliente
	 * @param telefono			Telefono del cliente
	 * @return					TRUE si se ha agregado FALSE si no se ha agregado
	 */
	public boolean agregarCliente(String dniCif, String razonSocial, String direccion, String telefono) {
		Cliente cliente = new Cliente(dniCif, razonSocial, direccion, telefono);
		return datos.grabar(cliente);
	}
	
	/**
	 * Muestra el cliente seleccionado
	 * @param dniCif			DNI o CIF del cliente a consultar
	 * @param lblDniCif			Etiqueta del DNI o CIF del cliente
	 * @param lblRazonSocial	Etiqueta del nombre del cliente
	 * @param lblDireccion		Etiqueta de la direccion del cliente
	 * @param lblTelefono		Etiqueta del telefono del cliente
	 */
	public void consultarCliente(String dniCif, JTextField lblDniCif, JTextField lblRazonSocial, JTextField lblDireccion, JTextField lblTelefono) {
		Cliente cliente = (Cliente) new AlmacenIndice<>(Utiles.pathClientes).leer((K) dniCif);
		accionesCliente.consultarCliente(cliente, lblDniCif, lblRazonSocial, lblDireccion, lblTelefono);
	}
	
	/**
	 * Escribe en el combo de clientes las coincidencias de la busqueda
	 * @param nombre			Nombre o DNI/CIF del cliente a buscar
	 * @param combo				Combo con los clientes que coincidan con nombre
	 */
	public void buscarCliente(String nombre, JComboBox combo) {
		accionesCliente.buscarCliente(nombre, combo);
	}
	
	/**
	 * aniade el articulo dado a la tabla dada
	 * @param tabla 	tabla donde quiere introducir el articulo
	 * @param nombre	nombre del articulo a introducir
	 */
	public void aniadirArticuloATabla(String nombre, DefaultTableModel modelo) {
		Articulo item = (Articulo) new AlmacenIndice<>(Utiles.pathArticulos).leer(nombre);
		accionesPedido.aniadirArticuloATabla(item,modelo);
	};
	
	/**
	 * numero del siguiente pedido, si el pedido no se guarda, este no aumenta
	 * @return	el numero del pedido
	 */
	public int getNumeroPosiblePedido() {
		return accionesPedido.getNumeroPosiblePedido();
	};
	/**
	 * crea un pedido con la informacion de la tabla y el cliente segun su nif
	 * @param dniNif	nif del cliente del que desea el pedido
	 * @param tabla		tabla de la que coger los datos del pedido
	 * @param modelo 
	 * @return
	 */
	public boolean crear(String dniNif, DefaultTableModel modelo) {
		Cliente cliente = (Cliente) new AlmacenIndice<>(Utiles.pathClientes).leer((K) dniNif);
		return accionesPedido.crear(cliente, modelo);
	};
	/**
	 * consultar un pedido segun el cliente elegido
	 * @param tabla tabla en la que mostrar los datos
	 * @param numeroPedido	numero del pedido a ver
	 * @param id	id del cliente de la que se queire ver el pedido
	 */
	public void consultar(JTable tabla, int numeroPedido, String id) {
		Pedido pedido = new AlmacenRuta(Utiles.pathPedidos).leer(id, numeroPedido);
		accionesPedido.introducirPedidoRejilla(tabla, pedido);
	};
	/**
	 * inserta los clientes existente en el comboBox introducido
	 * @param combo		comboBox en el que se quieren introducir
	 */
	public void insertarClientesEnCombo(JComboBox<Object> combo) {
		combo.removeAllItems();
		TreeMap indiceMap = new AlmacenIndice<>(Utiles.pathClientes).obtenerMap();
		accionesCliente.insertarClientesEnCombo(combo, indiceMap);
	}
	/**
	 * insertar los pedidos de un cliente en el comboBox deseado
	 * @param combo	comboBox en el que introducir los pedidos
	 * @param cadena	string con el que identificar al cliente
	 * @param txtField	txtField de mensaje
	 */
	public void insertarPedidosEnCombo(JComboBox<Object> combo, String cadena, JLabel txtField) {
		cadena = cadena.substring(cadena.lastIndexOf(Utiles.separador) + 1);
		accionesCliente.insertarPedidosEnCombo(combo, cadena, txtField);
	}
	/**
	 * saca un cadena de texto separandola de la cadena entera que hay en el combobox
	 * @param combo del que sacar el item
	 * @return cadena sacada del combobox
	 */
	public String getItemFromCombo(JComboBox<Object> combo) {
		String cadena = (String) combo.getSelectedItem();
		return cadena.substring(cadena.lastIndexOf(Utiles.separador) + 1);
	}
	/**
	 * vacia la tabla
	 * @param modeloTabla modelo de la tabla a vaciar
	 */
	public void eliminarPedidoRejilla(DefaultTableModel modeloTabla) {
		accionesPedido.eliminarPedidoRejilla(modeloTabla);

	}
	
	/**
	 * Cambia el precio total del articulo en tabla cuando se ajusta la cantidad
	 * @param tabla				Tabla en la que se actualizara el pedido
	 */
	public void cambiarPrecioRejilla(DefaultTableModel modeloTabla) {
		accionesPedido.cambiarPrecioRejilla(modeloTabla);
	}


	public float getPrecioAnteriorSegunFecha(String fecha, String nombreArt) {
		String[] fechaPartida = fecha.split("-");
		System.out.println(fechaPartida[1]);
	    GregorianCalendar fechaGre = new GregorianCalendar(Integer.valueOf(fechaPartida[0]),Integer.valueOf(fechaPartida[1])-1,Integer.valueOf(fechaPartida[2]));
		Articulo item = (Articulo) new AlmacenIndice<>(Utiles.pathArticulos).leer(nombreArt);
		return accionesArticulo.comprobarPrecio(item, fechaGre);
	}
	public Datos getDatos() {
		return datos;
	}
	public boolean crearCliente( String razonSocial, String dni, String direccion, String telefono) {
		Cliente cliente = new Cliente(dni, razonSocial, direccion, telefono);
		return datos.grabar(cliente);
	}
	public boolean eliminarCliente(String dni) {
		return new AlmacenIndice<>(Utiles.pathClientes).borrar((K) dni );
	}

	
}
