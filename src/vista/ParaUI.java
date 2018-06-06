package vista;

import java.awt.Color;
import java.awt.event.*;
import java.io.File;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import control.Logica;
import utiles.Utiles;
import utiles.Validator;

/**
 * 
 * @author fp-hermoso
 *
 */
public class ParaUI extends UI {

	private Logica logica;
	private PanelPedido panelPedido;
	private PanelTabla panelTabla;
	private PanelCliente panelCliente;
	private PanelArticulo panelArticulo;
	private PanelMain panelMain;
	private PanelEditarArticulo panelEditarArticulo;
	private MouseListenerColor mouseListener;
	private boolean pedidoProceso;
	private DefaultTableModel modeloTabla;
	private boolean bloquearListener = false;

	/**
	 * constructor ParaUI
	 */
	public ParaUI() {
		super();

		if (!Utiles.comprobarExiste(Utiles.main)) {
			new File(Utiles.main).mkdirs();
		}

		this.panelMain = new PanelMain();
		panelGeneralMain.add(panelMain);

		this.logica = new Logica();

		prepararPanelPedido();
		prepararPanelArticulo();
		prepararPanelCliente();

		// TODO action listeners all
		ponerListenersPedido();
		ponerListenerArticulo();
		ponerListenerCliente();

	}

	/**
	 * listeners que usa el panel de articulos
	 */
	private void ponerListenerArticulo() {

		panelArticulo.getCrearPrecio().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if ((e.getKeyChar() < '0' && e.getKeyChar() != '.' || e.getKeyChar() > '9') && e.getKeyChar() != '.') {
					e.consume();
				}
			}
		});

		panelArticulo.getCrearID().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if ((e.getKeyChar() < '0' || e.getKeyChar() > '9')) {
					e.consume();
				}
			}
		});

		panelArticulo.getCrearNombre().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if ((e.getKeyChar() < 'a' || e.getKeyChar() > 'z') && (e.getKeyChar() < 'A' || e.getKeyChar() > 'Z')) {
					e.consume();
				}
			}
		});
		panelArticulo.getNombreConsultado().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if ((e.getKeyChar() < 'a' || e.getKeyChar() > 'z') && (e.getKeyChar() < 'A' || e.getKeyChar() > 'Z')) {
					e.consume();
				}
			}
		});

		panelArticulo.getBtnBuscar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelArticulo.getNombreConsultado().getText().isEmpty()) {
					setMensaje("Error: Parametro vacio!!", Color.RED, panelArticulo.getTextMensajeSistema());
				} else {
					if (true == logica.comprobarExistencia(panelArticulo.getNombreConsultado().getText())) {
						panelArticulo.aniadir(panelEditarArticulo);
						panelArticulo.revalidate();
						logica.consultar(panelArticulo.getNombreConsultado().getText(),
								panelArticulo.getDetallesNombre(), panelArticulo.getDetallesID(),
								panelArticulo.getDetallesPrecio(), panelArticulo.getDetallesDescripcion());
					} else {
						setMensaje("Error: El articulo no existe!!", Color.RED, panelArticulo.getTextMensajeSistema());
						panelArticulo.getNombreConsultado().setText("");
						panelArticulo.getDetallesNombre().setText("");
						panelArticulo.getDetallesID().setText("");
						panelArticulo.getDetallesPrecio().setText("");
						panelArticulo.getDetallesDescripcion().setText("");
					}
				}
			}
		});

		panelArticulo.getBtnCrear().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelArticulo.getCrearNombre().getText().isEmpty() || panelArticulo.getCrearID().getText().isEmpty()
						|| panelArticulo.getCrearPrecio().getText().isEmpty()
						|| panelArticulo.getCrearDescripcion().getText().isEmpty()) {
					setMensaje("Error: Parametro vacio!!", Color.RED, panelArticulo.getTextMensajeSistema());
				} else {
					if (false == comprobarPuntos(panelArticulo.getCrearPrecio().getText())) {
						if (logica.crearArticulo(panelArticulo.getCrearNombre().getText(),
								Float.valueOf(panelArticulo.getCrearPrecio().getText()),
								Integer.valueOf(panelArticulo.getCrearID().getText()),
								panelArticulo.getCrearDescripcion().getText())) {
							logica.insertarArticulosEnCombo(panelPedido.getComboArticulos());
							setMensaje("El articulo ha sido creado.", Color.GREEN,
									panelArticulo.getTextMensajeSistema());
							panelArticulo.getCrearNombre().setText("");
							panelArticulo.getCrearID().setText("");
							panelArticulo.getCrearPrecio().setText("");
							panelArticulo.getCrearDescripcion().setText("");
						} else {
							setMensaje("Error: El articulo ya existe!!", Color.RED,
									panelArticulo.getTextMensajeSistema());
						}
					} else {
						setMensaje("Error: Precio esta mal escrito!!", Color.RED,
								panelArticulo.getTextMensajeSistema());
						panelArticulo.getCrearPrecio().setText("");
					}
				}
			}

			private boolean comprobarPuntos(String text) {
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
		});

		panelEditarArticulo.getBtnEditar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!panelArticulo.getDetallesNombre().getText().isEmpty()) {
					logica.editar(panelArticulo.getDetallesNombre().getText(),
							Float.valueOf(panelEditarArticulo.getNuevoPrecio().getText()));
					panelArticulo.getDetallesPrecio().setText(panelEditarArticulo.getNuevoPrecio().getText());
					panelEditarArticulo.getNuevoPrecio().setText("");
				} else {
					setMensaje("Error: Vacio!!", Color.RED, panelArticulo.getTextMensajeSistema());
				}
			}
		});

		panelEditarArticulo.getBtnBuscar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!panelEditarArticulo.getTxtFecha().getText().isEmpty()) {
					if (!panelArticulo.getDetallesNombre().getText().isEmpty()) {
						String fecha = panelEditarArticulo.getTxtFecha().getText();
						float precioAnteriorSegunFecha = logica.getPrecioAnteriorSegunFecha(fecha,
								panelArticulo.getDetallesNombre().getText());
						panelEditarArticulo.getLblPrecio().setText(String.valueOf(precioAnteriorSegunFecha));
					} else {
						setMensaje("Error: Vacio!!", Color.RED, panelArticulo.getTextMensajeSistema());
					}
				} else {
					panelEditarArticulo.getLblPrecio().setText("Error: Vacio!!");
				}
			}
		});
	}

	/**
	 * listeners que usa el panel de clientes
	 */
	private void ponerListenerCliente() {
		panelCliente.getBtnAgregar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!comprobarCamposTxt(panelCliente.getTxtDnicif(), panelCliente.getTxtRazonSocial(),
						panelCliente.getTxtDireccion(), panelCliente.getTxtTelefono())) {
					if (Validator.isDniCif(panelCliente.getTxtDnicif().getText())) {
						if (Validator.isPhone(panelCliente.getTxtTelefono().getText())) {
							if (logica.agregarCliente(panelCliente.getTxtDnicif().getText(),
									panelCliente.getTxtRazonSocial().getText(),
									panelCliente.getTxtDireccion().getText(),
									panelCliente.getTxtTelefono().getText())) {
								setMensaje(
										"Cliente " + panelCliente.getTxtRazonSocial().getText()
												+ " ha sido agregado correctamente",
										Color.GREEN, panelCliente.getLblMensaje());
								borrarTxt(panelCliente.getTxtDnicif(), panelCliente.getTxtRazonSocial(),
										panelCliente.getTxtDireccion(), panelCliente.getTxtTelefono());
								if (panelPedido.getComboClientes().getItemCount() > 0) {
									panelPedido.getComboClientes().removeAllItems();
								}
								logica.insertarClientesEnCombo(panelPedido.getComboClientes());
							} else {
								setMensaje("Error en la operacion. Revise los campos de texto e intentelo de nuevo.",
										Color.RED, panelCliente.getLblMensaje());
							}
						} else {
							setMensaje("El telefono introducido no es correcto", Color.RED,
									panelCliente.getLblMensaje());
							panelCliente.getTxtTelefono().setBackground(Color.YELLOW);
						}
					} else {
						setMensaje("El DNI o CIF introducido no es correcto", Color.RED, panelCliente.getLblMensaje());
						panelCliente.getTxtDnicif().setBackground(Color.YELLOW);
					}
				} else {
					setMensaje("Debe rellenar los campos de texto para continuar", Color.RED,
							panelCliente.getLblMensaje());
				}
			}
		});

		panelCliente.getBtnBuscar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBuscarCliente();
				if (panelCliente.getTxtClienteConsulta().getText().isEmpty()) {
					panelCliente.getTxtClienteConsulta().setBackground(Color.YELLOW);
				}
			}
		});

		panelCliente.getTxtClienteConsulta().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBuscarCliente();
			}
		});

		panelCliente.getComboBox().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelCliente.getComboBox().getItemCount() > 0) {
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
				VentanaErmegenteBorrarCliente ventanaEliminar = new VentanaErmegenteBorrarCliente();
				// En el caso que confirme la accion
				ventanaEliminar.getBtnConfirmar().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int indice = panelCliente.getComboBox().getSelectedIndex();
						if (indice >= 0) {
							if (logica.eliminarCliente(panelCliente.getTxtDnicifResultado().getText())) {
								// No se como evitar un NullPointerException sin
								// hacer esto
								if (panelCliente.getComboBox().getItemCount() != 1) {
									panelCliente.getComboBox().removeItemAt(indice);
								} else {
									borrarTxt(panelCliente.getTxtDnicifResultado(),
											panelCliente.getTxtRazonSocialResultado(),
											panelCliente.getTxtDireccionResultado(),
											panelCliente.getTxtTelefonoResultado());
									panelCliente.getComboBox().removeAllItems();
								}
								panelCliente.getLblMensaje().setText("Borrado");
							} else {
								panelCliente.getLblMensaje().setText("Fallo al borrar");
								ventanaEliminar.dispose();
							}
						}
					}
				});

				// En el caso de que eliga la opcion de cancelar
				ventanaEliminar.getBtnCancelar().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ventanaEliminar.dispose();
					}
				});
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
				btnBuscarCliente();
			}
		});

		panelCliente.getTxtDnicif().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelCliente.getTxtDnicif().setBackground(Color.WHITE);
			}
		});

		panelCliente.getTxtRazonSocial().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelCliente.getTxtRazonSocial().setBackground(Color.WHITE);
			}
		});

		panelCliente.getTxtDireccion().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelCliente.getTxtDireccion().setBackground(Color.WHITE);
			}
		});

		panelCliente.getTxtTelefono().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelCliente.getTxtTelefono().setBackground(Color.WHITE);
			}
		});

		panelCliente.getTxtClienteConsulta().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelCliente.getTxtTelefono().setBackground(Color.WHITE);
			}
		});
	}

	/**
	 * listeners que usa el panel de pedidos
	 */
	private void ponerListenersPedido() {
		panelPedido.getBtnAdd().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if (comprobarPedidoProceso()) {
				if (panelPedido.getComboArticulos().getItemCount() != 0) {
					bloquearListener = false;
					String nombreArticulo = panelPedido.getComboArticulos().getSelectedItem().toString();
					System.out.println(nombreArticulo);
					int encontrado = -1;
					int rows = modeloTabla.getRowCount();
					for (int i = rows - 1; i >= 0; i--) {
						if (modeloTabla.getValueAt(i, 1).toString().equals(nombreArticulo)) {
							encontrado = i;
						}
					}
					if (encontrado == -1) {
						logica.aniadirArticuloATabla(nombreArticulo, modeloTabla);
						panelPedido.revalidate();
						setMensaje("Insertado en el pedido el articulo " + nombreArticulo, Color.GREEN,
								panelPedido.getTextMensaje());
					} else {
						modeloTabla.setValueAt((Integer.parseInt(modeloTabla.getValueAt(encontrado, 3).toString()) + 1),
								encontrado, 3);
					}
					bloquearListener = false;
				} else {
					setMensaje("No hay articulos", Color.RED, panelPedido.getTextMensaje());
				}
			}
		});

		panelPedido.getBtnCancelar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comprobarPedidoProceso()) {
					pedidoProceso = false;
					logica.eliminarPedidoRejilla(modeloTabla);
					setMensaje("El pedido ha sido cancelado", Color.ORANGE, panelPedido.getTextMensaje());
					panelPedido.getTextMensaje().setBackground(Color.ORANGE);
				}
			}
		});

		panelPedido.getBtnNuevoPedido().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!comprobarPedidoProceso()) {
					pedidoProceso = true;
					String numeroPedido = String.valueOf(logica.getNumeroPosiblePedido());
					panelPedido.getTxtNumeroPedido().setText(numeroPedido);
					setMensaje("Nuevo pedido numero " + numeroPedido + " en proceso", Color.GREEN,
							panelPedido.getTextMensaje());
					logica.insertarArticulosEnCombo(panelPedido.getComboArticulos());
					logica.insertarClientesEnCombo(panelPedido.getComboClientesCrear());
					logica.eliminarPedidoRejilla(modeloTabla);
					bloquearListener = false;
				}
			}

		});
		panelPedido.getBtnEncargar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comprobarPedidoProceso()) {
					if (panelPedido.getComboClientesCrear().getItemCount() != 0) {
						if (panelTabla.getTabla().getRowCount() != 0) {
							String dniNif = logica.getItemFromCombo(panelPedido.getComboClientesCrear());
							if (logica.crear(dniNif, modeloTabla)) {
								pedidoProceso = false;
								setMensaje("Pedido completado satisfactoriamente", Color.RED,
										panelPedido.getTextMensaje());
								logica.eliminarPedidoRejilla(modeloTabla);
							} else {
								setMensaje("Fallo al encargar el pedido", Color.RED, panelPedido.getTextMensaje());
							}
						} else {
							setMensaje("Nada que encargar", Color.RED, panelPedido.getTextMensaje());
							panelPedido.getTextMensaje().setBackground(Color.RED);
						}
					} else {
						setMensaje("No hay clientes", Color.RED, panelPedido.getTextMensaje());
					}
				}
			}
		});
		panelPedido.getBtnDelete().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comprobarPedidoProceso()) {
					if (!panelTabla.getTabla().getSelectionModel().isSelectionEmpty()) {
						int seleccionada = panelTabla.getTabla().getSelectedRow();
						modeloTabla.removeRow(seleccionada);
						setMensaje("Linea borrada satisfactoriamente", Color.GREEN, panelPedido.getTextMensaje());
					} else {
						setMensaje("No se ha seleccionado linea de pedido", Color.RED, panelPedido.getTextMensaje());
					}
				}
			}
		});
		panelPedido.getComboClientesCrear().addActionListener(
				(e) -> setMensaje("Cliente para el pedido seleccionado", Color.RED, panelPedido.getTextMensaje()));

		panelPedido.getComboArticulos()
				.addActionListener((e) -> setMensaje("Articulo seleccionado, pulse add para introducirlo al pedido",
						Color.RED, panelPedido.getTextMensaje()));

		panelPedido.getComboPedidos()
				.addActionListener((e) -> setMensaje("Pedido seleccionado, pulse ver para ver detalles", Color.RED,
						panelPedido.getTextMensaje()));

		panelPedido.getComboClientes().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!comprobarPedidoProceso()) {
					if (panelPedido.getComboClientes().getItemCount() > 0) {
						panelPedido.getComboPedidos().removeAllItems();
						panelPedido.getComboPedidos().setEnabled(true);
						logica.insertarPedidosEnCombo(panelPedido.getComboPedidos(),
								(String) panelPedido.getComboClientes().getSelectedItem(),
								panelPedido.getTextMensaje());
						panelPedido.getBtnVer().setEnabled(true);
						panelPedido.revalidate();
					}
				}
			}
		});

		panelPedido.getBtnVer().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!comprobarPedidoProceso()) {
					if (panelPedido.getComboPedidos().getItemCount() != 0
							&& panelPedido.getComboClientes().getItemCount() != 0) {
						bloquearListener = true;
						panelPedido.getBtnVer().setEnabled(false);
						panelPedido.getComboPedidos().setEnabled(false);
						String dniNif = logica.getItemFromCombo(panelPedido.getComboClientes());
						int numeroPedido = Integer.valueOf(logica.getItemFromCombo(panelPedido.getComboPedidos()));
						logica.eliminarPedidoRejilla(modeloTabla);
						logica.consultar(panelTabla.getTabla(), numeroPedido, dniNif);
						setMensaje("Mostrando el pedido " + numeroPedido + " del cliente con dni: " + dniNif,
								Color.GREEN, panelPedido.getTextMensaje());
					} else {
						setMensaje("No se ha seleccionado pedido", Color.RED, panelPedido.getTextMensaje());
					}
				}
			}
		});
		modeloTabla.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				int fila = panelTabla.getTabla().getSelectedRow();
				System.out.println(fila);
				if (pedidoProceso) {
					if (panelTabla.getTabla().getRowCount() != 0 && !bloquearListener && fila != -1) {
						bloquearListener = true;
						modeloTabla
								.setValueAt(
										(Float.parseFloat(modeloTabla.getValueAt(fila, 2).toString())
												* Integer.parseInt(modeloTabla.getValueAt(fila, 3).toString())),
										fila, 4);
						bloquearListener = false;
					}
				}
			}
		});
	}

	/**
	 * preparacion del panel pedido
	 */
	private void prepararPanelPedido() {
		this.panelPedido = new PanelPedido(); // crea el panelpedido
		this.panelTabla = new PanelTabla(); // crea el paneltabla
		this.panelPedido.addPanelTabla(panelTabla); // mete el paneltabla en el
													// panelpedido
		panelGeneralPedido.add(panelPedido);
		logica.insertarClientesEnCombo(panelPedido.getComboClientes());
		this.pedidoProceso = false;
		this.modeloTabla = (DefaultTableModel) panelTabla.getTabla().getModel();
	}

	/**
	 * preparacion del panel cliente
	 */
	private void prepararPanelCliente() {
		this.panelCliente = new PanelCliente();
		panelGeneralCliente.add(panelCliente);

	}

	/**
	 * preparacion del panel articulo
	 */
	private void prepararPanelArticulo() {
		this.panelArticulo = new PanelArticulo();
		panelGeneralArticulo.add(panelArticulo);
		this.panelEditarArticulo = new PanelEditarArticulo();

	}

	/**
	 * metodo que crea una pausa en la ejecucion del programa
	 * 
	 * @param tiempoSeg
	 *            segundos de pausa
	 */
	private void Pausa(int tiempoSeg) {
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
	 * comprueba que hay un pedido en proceso o no e inserta un mensaje en el
	 * panel pedido
	 * 
	 * @return true si hay un pedido en proceso, false si no hay pedido en
	 *         proceso
	 */
	private boolean comprobarPedidoProceso() {
		if (pedidoProceso) {
			setMensaje("Se esta creando un pedido ahora mismo, cancelelo o completelo", Color.RED,
					panelPedido.getTextMensaje());
		} else {
			setMensaje("Accion no disponible si no esta creando un pedido", Color.RED, panelPedido.getTextMensaje());
		}
		panelPedido.getTextMensaje().setBackground(Color.RED);
		return pedidoProceso;
	}

	/**
	 * Pone el texto dado en el textfield del panelPedido para que salga como
	 * mensaje
	 * 
	 * @param mensaje
	 *            cadena de texto a poner como mensaje
	 * @param red
	 */
	private void setMensaje(String mensaje, Color color, JLabel jlabel) {
		jlabel.setBackground(color);
		jlabel.setText(mensaje);
		jlabel.setOpaque(true);
		Pausa(3);
	}

	private void btnBuscarCliente() {
		String nombre = panelCliente.getTxtClienteConsulta().getText();
		if (!nombre.isEmpty()) {
			if (panelCliente.getComboBox().getItemCount() > 0) {
				panelCliente.getComboBox().removeAllItems();
			}
			logica.buscarCliente(nombre, panelCliente.getComboBox());
			if (panelCliente.getComboBox().getItemCount() == 0) {
				panelCliente.getTxtDnicifResultado().setText(null);
				panelCliente.getTxtRazonSocialResultado().setText(null);
				panelCliente.getTxtDireccionResultado().setText(null);
				panelCliente.getTxtTelefonoResultado().setText(null);
				setMensaje("No hay coincidencias", Color.RED, panelCliente.getLblMensaje());
			}
		} else {
			setMensaje("Debe rellenar el campo de cliente", Color.RED, panelCliente.getLblMensaje());
		}
	}

	private void borrarTxt(JTextField... jTextField) {
		for (int i = 0; i < jTextField.length; i++) {
			jTextField[i].setText(null);
		}
	}

	private boolean comprobarCamposTxt(JTextField... jTextField) {
		boolean vacio = false;
		for (int i = 0; i < jTextField.length; i++) {
			if (jTextField[i].getText().trim().isEmpty()) {
				vacio = true;
				jTextField[i].setBackground(Color.YELLOW);
			}
		}
		return vacio;
	}

}