package control.acciones;

import java.io.File;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import control.almacenes.AlmacenIndice;
import modelo.Cliente;
import utiles.Utiles;

public class AccionesCliente<K> {

	public void insertarPedidosEnCombo(JComboBox combo, String cadena, JTextField txtMensaje) {
		cadena = cadena.substring(cadena.lastIndexOf(Utiles.separador) + 1);
		if (Utiles.comprobarExiste("./data/pedidos/" + cadena)) {
			File[] pedidos = new File("./data/pedidos/" + cadena).listFiles();
			for (int i = 0; i < pedidos.length; i++) {
				combo.addItem("Pedido " + pedidos[i].getName().replace(".ped", ""));
			}
		} else {
			txtMensaje.setText("El cliente seleccionado no tiene pedidos");
		}
	}

	public void insertarClientesEnCombo(JComboBox combo) {
		TreeMap indiceMap = new AlmacenIndice<>(Utiles.pathClientes).obtenerMap();
		if (!(indiceMap == null)) {
			Set keySet = indiceMap.keySet();
			for (Object object : keySet) {
				Cliente cliente = (Cliente) new AlmacenIndice<>(Utiles.pathClientes).leer((K) object);
				combo.addItem(cliente.getRazonSocial() + Utiles.separador + cliente.getDniCif());
			}
		}
	}
}