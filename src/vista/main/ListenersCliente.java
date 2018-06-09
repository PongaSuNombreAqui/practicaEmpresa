package vista.main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import org.omg.Messaging.SyncScopeHelper;

import control.Logica;
import utiles.Validator;
import vista.paneles.PanelArticulo;
import vista.paneles.PanelCliente;
import vista.paneles.PanelEditarArticulo;
import vista.paneles.PanelMain;
import vista.paneles.PanelPedido;
import vista.paneles.PanelTabla;

public class ListenersCliente {
	private Logica logica;
	private PanelPedido panelPedido;
	private PanelCliente panelCliente;

	public ListenersCliente(Logica logica, PanelPedido panelPedido, PanelCliente panelCliente, AccionesParaUI accPUI) {
		this.logica = logica;
		this.panelPedido = panelPedido;
		this.panelCliente = panelCliente;
		ponerListenerCliente(accPUI);
	}

	private void ponerListenerCliente(AccionesParaUI accPUI) {
		panelCliente.getBtnAgregar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!accPUI.comprobarCamposTxt(panelCliente.getTxtDnicif(), panelCliente.getTxtRazonSocial(),
						panelCliente.getTxtDireccion(), panelCliente.getTxtTelefono())) {
					if (Validator.isDniCif(panelCliente.getTxtDnicif().getText())) {
						if (Validator.isPhone(panelCliente.getTxtTelefono().getText())) {
							if (logica.agregarCliente(panelCliente.getTxtDnicif().getText(),
									panelCliente.getTxtRazonSocial().getText(),
									panelCliente.getTxtDireccion().getText(),
									panelCliente.getTxtTelefono().getText())) {
								accPUI.setMensaje(
										"Cliente " + panelCliente.getTxtRazonSocial().getText()
												+ " ha sido agregado correctamente",
										Color.GREEN, panelCliente.getLblMensaje());
								accPUI.borrarTxt(panelCliente.getTxtDnicif(), panelCliente.getTxtRazonSocial(),
										panelCliente.getTxtDireccion(), panelCliente.getTxtTelefono());
								if (panelPedido.getComboClientes().getItemCount() > 0) {
									panelPedido.getComboClientes().removeAllItems();
								}
								logica.insertarClientesEnCombo(panelPedido.getComboClientes());
							} else {
								accPUI.setMensaje(
										"Error en la operacion: Revise los campos de texto e intentelo de nuevo",
										Color.RED, panelCliente.getLblMensaje());
							}
						} else {
							accPUI.setMensaje("El telefono introducido no es correcto", Color.RED,
									panelCliente.getLblMensaje());
							panelCliente.getTxtTelefono().setBackground(Color.YELLOW);
						}
					} else {
						accPUI.setMensaje("El DNI o CIF introducido no es correcto", Color.RED,
								panelCliente.getLblMensaje());
						panelCliente.getTxtDnicif().setBackground(Color.YELLOW);
					}
				} else {
					accPUI.setMensaje("Debe rellenar los campos de texto para continuar", Color.RED,
							panelCliente.getLblMensaje());
				}
			}
		});

		panelCliente.getBtnBuscar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accPUI.btnBuscarCliente();
				if (panelCliente.getTxtClienteConsulta().getText().isEmpty()) {
					panelCliente.getTxtClienteConsulta().setBackground(Color.YELLOW);
				}
			}
		});

		panelCliente.getTxtClienteConsulta().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accPUI.btnBuscarCliente();
			}
		});

		panelCliente.getComboBox().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelCliente.getComboBox().getItemCount() > 0
						&& panelCliente.getComboBox().getSelectedIndex() != -1) {
					String dniCif = logica.getItemFromCombo(panelCliente.getComboBox());
					logica.consultarCliente(dniCif, panelCliente.getTxtDnicifResultado(),
							panelCliente.getTxtRazonSocialResultado(), panelCliente.getTxtDireccionResultado(),
							panelCliente.getTxtTelefonoResultado());
					panelCliente.getBtnEliminarCliente().setEnabled(true);
				} else {
					panelCliente.getBtnEliminarCliente().setEnabled(false);
				}
			}
		});

		panelCliente.getBtnEliminarCliente().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resultado = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas eliminar este cliente?", "",
						JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null);
				if (resultado == JOptionPane.YES_OPTION) {
					int indice = panelCliente.getComboBox().getSelectedIndex();
					if (indice >= 0) {
						if (logica.eliminarCliente(panelCliente.getTxtDnicifResultado().getText())) {
							if (panelCliente.getComboBox().getItemCount() > 0) {
								accPUI.borrarTxt(panelCliente.getTxtDnicifResultado(),
										panelCliente.getTxtRazonSocialResultado(),
										panelCliente.getTxtDireccionResultado(),
										panelCliente.getTxtTelefonoResultado());
								panelCliente.getComboBox().removeItemAt(indice);
							}
							logica.insertarClientesEnCombo(panelPedido.getComboClientes());
							logica.insertarClientesEnCombo(panelPedido.getComboClientesCrear());
							panelCliente.getLblMensaje().setText("Borrado");
						} else {
							panelCliente.getLblMensaje().setText("Fallo al borrar");
						}
					}
				} else {
					accPUI.setMensaje("Operacion cancelada", Color.ORANGE, panelCliente.getLblMensaje());
				}
			}
		});

		panelCliente.getTxtTelefono().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if ((e.getKeyChar() < '0' || e.getKeyChar() > '9')
						|| panelCliente.getTxtTelefono().getText().length() == 9) {
					e.consume();
				}
			}
		});

		panelCliente.getTxtDnicif().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (panelCliente.getTxtDnicif().getText().length() == 9) {
					e.consume();
				}
			}
		});

		panelCliente.getTxtClienteConsulta().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				accPUI.btnBuscarCliente();
			}
		});
	}

}
