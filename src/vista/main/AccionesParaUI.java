package vista.main;

import java.awt.Color;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import control.Logica;
import utiles.Utiles;
import vista.paneles.PanelArticulo;
import vista.paneles.PanelCliente;
import vista.paneles.PanelEditarArticulo;
import vista.paneles.PanelMain;
import vista.paneles.PanelPedido;
import vista.paneles.PanelTabla;

public class AccionesParaUI {

	private Logica logica;
	private PanelPedido panelPedido;
	private PanelCliente panelCliente;
	private PanelArticulo panelArticulo;

	public AccionesParaUI(Logica logica, PanelPedido panelPedido, PanelCliente panelCliente,
			PanelArticulo panelArticulo) {
		this.logica = logica;
		this.panelPedido = panelPedido;
		this.panelCliente = panelCliente;
		this.panelArticulo = panelArticulo;
	}

	void directorios() {
		if (!Utiles.comprobarExiste(Utiles.main)) {
			new File(Utiles.main).mkdirs();
		}
		if (!Utiles.comprobarExiste(Utiles.pathArticulos)) {
			new File(Utiles.pathArticulos).mkdirs();
		}
		if (!Utiles.comprobarExiste(Utiles.pathClientes)) {
			new File(Utiles.pathClientes).mkdirs();
		}
	}

	/**
	 * metodo que crea una pausa en la ejecucion del programa
	 * 
	 * @param tiempoSeg
	 *            segundos de pausa
	 */
	void Pausa(int tiempoSeg) {
		final SwingWorker worker = new SwingWorker() {

			@Override
			protected Object doInBackground() throws Exception {
				try {
					Thread.sleep(tiempoSeg * 1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				panelArticulo.getTextMensajeSistema().setText("");
				panelArticulo.getTextMensajeSistema().setOpaque(false);
				panelPedido.getTextMensaje().setText("");
				panelPedido.getTextMensaje().setOpaque(false);
				panelCliente.getLblMensaje().setText("");
				panelCliente.getLblMensaje().setOpaque(false);
				return null;
			}
		};
		worker.execute();
	}

	/**
	 * Pone el texto dado en el textfield del panelPedido para que salga como
	 * mensaje
	 * 
	 * @param mensaje
	 *            cadena de texto a poner como mensaje
	 * @param red
	 */
	void setMensaje(String mensaje, Color color, JLabel jlabel) {
		jlabel.setBackground(color);
		jlabel.setText(mensaje);
		jlabel.setOpaque(true);
		Pausa(3);
	}

	void btnBuscarCliente() {
		String nombre = panelCliente.getTxtClienteConsulta().getText();
		if (!nombre.isEmpty()) {
			if (panelCliente.getComboBox().getItemCount() > 0) {
				panelCliente.getComboBox().removeAllItems();
			}
			logica.buscarCliente(nombre, panelCliente.getComboBox());
			if (panelCliente.getComboBox().getItemCount() == 0) {
				borrarTxt(panelCliente.getTxtDnicifResultado(), panelCliente.getTxtRazonSocialResultado(),
						panelCliente.getTxtDireccionResultado(), panelCliente.getTxtTelefonoResultado());
				setMensaje("No hay coincidencias", Color.RED, panelCliente.getLblMensaje());
			}
		} else {
			setMensaje("Debe rellenar el campo de cliente", Color.RED, panelCliente.getLblMensaje());
		}
	}

	/**
	 * Borra el campo de texto de los JTextField
	 * 
	 * @param jTextField
	 *            El JTextField a borrar
	 */
	void borrarTxt(JTextField... jTextField) {
		for (int i = 0; i < jTextField.length; i++) {
			jTextField[i].setText(null);
		}
	}

	void borrarTextLabel(JLabel... jTextField) {
		for (int i = 0; i < jTextField.length; i++) {
			jTextField[i].setText(null);
		}
	}

	/**
	 * Comprueba que los campos de texto de los JTextField estan vacios. Si
	 * estan vacios, se cambiara el color de fondo
	 * 
	 * @param jTextField
	 *            El JTextField a comprobar
	 * @return FALSE si ninguno de ellos esta vacio TRUE si uno o varios de
	 *         ellos estan vacios
	 */
	boolean comprobarCamposTxt(JTextField... jTextField) {
		boolean vacio = false;
		for (int i = 0; i < jTextField.length; i++) {
			if (jTextField[i].getText().trim().isEmpty()) {
				vacio = true;
				jTextField[i].setBackground(Color.YELLOW);
			}
		}
		return vacio;
	}

	boolean comprobarPuntos(String text) {
		for (int i = 0, contador = 0; i < text.length(); i++) {
			if (text.charAt(i) == '.') {
				contador++;
				if (contador > 1) {
					return true;
				}
			}
		}
		return false;
	}
}
