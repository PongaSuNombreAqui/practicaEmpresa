package control.acciones;

import java.io.File;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import control.almacenes.AlmacenIndice;
import modelo.Cliente;
import utiles.Utiles;
/**
 * 
 * @author fp-hermoso
 *
 * @param <K> clave almacen indice
 */
public class AccionesCliente<K> {
	
	public boolean agregarCliente(String dniCif, String razonSocial, String direccion, String telefono) {
		Cliente cliente = new Cliente(dniCif, razonSocial, direccion, telefono);
		return new AlmacenIndice<>(Utiles.pathClientes).grabar(cliente, dniCif);
	}
	
	public void consultarRazonSocial(String nombre, JComboBox combo) {
		TreeMap indiceMap = new AlmacenIndice<>(Utiles.pathClientes).obtenerMap();
		if (!(indiceMap == null)) {
			Set keySet = indiceMap.keySet();
			for (Object object : keySet) {
				Cliente cliente = (Cliente) new AlmacenIndice<>(Utiles.pathClientes).leer((K) object);
				if (cliente.getRazonSocial().toLowerCase().matches(".*" + nombre.toLowerCase() + ".*")
						|| cliente.getDniCif().toLowerCase().matches(".*" + nombre.toLowerCase() + ".*")) {
					combo.addItem(cliente.getRazonSocial() + Utiles.separador + cliente.getDniCif());
				}
			}
		}
	}

	public void consultarCliente(String dniCif, JTextField lblDniCif, JTextField lblRazonSocial,
			JTextField lblDireccion, JTextField lblTelefono) {
		Cliente cliente = (Cliente) new AlmacenIndice<>(Utiles.pathClientes).leer((K) dniCif);
		if (cliente == null) {
			System.out.println("Error");
		} else {
			lblDniCif.setText(cliente.getDniCif());
			lblRazonSocial.setText(cliente.getRazonSocial());
			lblDireccion.setText(cliente.getDireccion());
			lblTelefono.setText(cliente.getTelefono());
		}
	}

	public void BorrarCliente() {
		// TODO
	}

	public void insertarPedidosEnCombo(JComboBox combo, String cadena, JTextField txtMensaje) {
		if (Utiles.comprobarExiste("./data/pedidos/" + cadena)) {
			File[] pedidos = new File("./data/pedidos/" + cadena).listFiles();
			for (int i = 0; i < pedidos.length; i++) {
				combo.addItem("Pedido " + pedidos[i].getName().replace(".ped", ""));
			}
		} else {
			txtMensaje.setText("El cliente seleccionado no tiene pedidos");
		}
	}

	public void insertarClientesEnCombo(JComboBox<Object> combo, TreeMap indiceMap) {
		if (!(indiceMap == null)) {
			Set keySet = indiceMap.keySet();
			for (Object object : keySet) {
				Cliente cliente = (Cliente) new AlmacenIndice<>(Utiles.pathClientes).leer((K) object);
				combo.addItem(cliente.getRazonSocial() + Utiles.separador + cliente.getDniCif());
			}
		}
	}
}
