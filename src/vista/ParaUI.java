package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
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
					panelArticulo.getMensajeConsulta().setForeground(Color.RED);
					panelArticulo.getMensajeConsulta().setText("Error: Parametro vacío!!");
					Pausa(2);
				} else {
					if (true == logica.comprobarExistencia(panelArticulo.getNombreConsultado().getText())) {
						panelArticulo.aniadir(panelEditarArticulo);
						panelArticulo.revalidate();
						logica.consultar(panelArticulo.getNombreConsultado().getText(),
								panelArticulo.getDetallesNombre(), panelArticulo.getDetallesID(),
								panelArticulo.getDetallesPrecio(), panelArticulo.getDetallesDescripcion());
					} else {
						panelArticulo.getMensajeConsulta().setForeground(Color.RED);
						panelArticulo.getMensajeConsulta().setText("Error: El articulo no existe!!");
						panelArticulo.getNombreConsultado().setText("");
						panelArticulo.getDetallesNombre().setText("");
						panelArticulo.getDetallesID().setText("");
						panelArticulo.getDetallesPrecio().setText("");
						panelArticulo.getDetallesDescripcion().setText("");
						Pausa(2);
					}
				}
			}
		});

		panelArticulo.getBtnCrear().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelArticulo.getCrearNombre().getText().isEmpty() || panelArticulo.getCrearID().getText().isEmpty()
						|| panelArticulo.getCrearPrecio().getText().isEmpty()
						|| panelArticulo.getCrearDescripcion().getText().isEmpty()) {
					panelArticulo.getMensajeCrear().setForeground(Color.RED);
					panelArticulo.getMensajeCrear().setText("Error: Parametro vacío!!");
					Pausa(2);
				} else {
					if (false == comprobarPuntos(panelArticulo.getCrearPrecio().getText())) {
						if (logica.crearArticulo(panelArticulo.getCrearNombre().getText(),
								Float.valueOf(panelArticulo.getCrearPrecio().getText()),
								Integer.valueOf(panelArticulo.getCrearID().getText()),
								panelArticulo.getCrearDescripcion().getText())) {
							logica.insertarArticulosEnCombo(panelPedido.getComboArticulos());
							panelArticulo.getMensajeCrear().setForeground(Color.GREEN);
							panelArticulo.getMensajeCrear().setText("El articulo ha sido creado.");
							panelArticulo.getCrearNombre().setText("");
							panelArticulo.getCrearID().setText("");
							panelArticulo.getCrearPrecio().setText("");
							panelArticulo.getCrearDescripcion().setText("");
						} else {
							panelArticulo.getMensajeCrear().setForeground(Color.RED);
							panelArticulo.getMensajeCrear().setText("Error: El articulo ya existe!!");
						}
						Pausa(2);
					} else {
						panelArticulo.getMensajeCrear().setForeground(Color.RED);
						panelArticulo.getMensajeCrear().setText("Error: Precio esta mal escrito!!");
						panelArticulo.getCrearPrecio().setText("");
						Pausa(2);
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
					panelArticulo.getMensajeConsulta().setForeground(Color.RED);
					panelArticulo.getMensajeConsulta().setText("Error: Vacio!!");
					Pausa(2);
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
						panelArticulo.getMensajeConsulta().setForeground(Color.RED);
						panelArticulo.getMensajeConsulta().setText("Error: Vacio!!");
						Pausa(2);
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
				String dniCif = panelCliente.getTxtDnicif().getText();
				String razonSocial = panelCliente.getTxtRazonSocial().getText();
				String direccion = panelCliente.getTxtDireccion().getText();
				String telefono = panelCliente.getTxtTelefono().getText();
				if (!dniCif.isEmpty() && !razonSocial.isEmpty() && !direccion.isEmpty() && !telefono.isEmpty()) {
					if (Validator.isDniCif(dniCif)) {
						if (Validator.isPhone(telefono)) {
							if (logica.agregarCliente(dniCif, razonSocial, direccion, telefono)) {
								panelCliente.getLblMensaje()
										.setText("Cliente " + razonSocial + " ha sido agregado correctamente");
								panelCliente.getTxtDnicif().setText(null);
								panelCliente.getTxtRazonSocial().setText(null);
								panelCliente.getTxtDireccion().setText(null);
								panelCliente.getTxtTelefono().setText(null);
							} else {
								panelCliente.getLblMensaje().setText(
										"Error en la operacion. Revise los campos de texto e intentelo de nuevo.");
							}
						} else {
							panelCliente.getLblMensaje().setText("El telefono introducido no es correcto");
							panelCliente.getTxtTelefono().setBackground(Color.YELLOW);
						}
					} else {
						panelCliente.getLblMensaje().setText("El DNI o CIF introducido no es correcto");
						panelCliente.getTxtDnicif().setBackground(Color.YELLOW);
					}
				} else {
					panelCliente.getLblMensaje().setText("Debe rellenar los campos de texto para continuar");
					if (dniCif.isEmpty()) {
						panelCliente.getTxtDnicif().setBackground(Color.YELLOW);
					}
					if (razonSocial.isEmpty()) {
						panelCliente.getTxtRazonSocial().setBackground(Color.YELLOW);
					}
					if (direccion.isEmpty()) {
						panelCliente.getTxtDireccion().setBackground(Color.YELLOW);
					}
					if (telefono.isEmpty()) {
						panelCliente.getTxtTelefono().setBackground(Color.YELLOW);
					}
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
				int indice = panelCliente.getComboBox().getSelectedIndex();
				if (indice >= 0) {
					if (logica.eliminarCliente(panelCliente.getTxtDnicifResultado().getText())) {
						// No se como evitar un NullPointerException sin hacer esto
						if (panelCliente.getComboBox().getItemCount() != 1) {
							panelCliente.getComboBox().removeItemAt(indice);
						} else {
							panelCliente.getTxtDnicifResultado().setText(null);
							panelCliente.getTxtRazonSocialResultado().setText(null);
							panelCliente.getTxtDireccionResultado().setText(null);
							panelCliente.getTxtTelefonoResultado().setText(null);
							panelCliente.getComboBox().removeAllItems();
						}
						panelCliente.getLblMensaje().setText("Borrado");
					} else {
						panelCliente.getLblMensaje().setText("Fallo al borrar");
					}
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
				panelCliente.getTxtClienteConsulta().setBackground(Color.WHITE);
			}
		});
	}

	/**
	 * listeners que usa el panel de pedidos
	 */
	private void ponerListenersPedido() {
		panelPedido.getBtnAdd().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comprobarPedidoProceso()) {
					if (panelPedido.getComboArticulos().getItemCount() != 0) {
						bloquearListener = true;
						String nombreArticulo = panelPedido.getComboArticulos().getSelectedItem().toString();
						logica.aniadirArticuloATabla(nombreArticulo, modeloTabla);
						panelPedido.revalidate();
						setMensaje("Insertado en el pedido el articulo " + nombreArticulo);
						panelPedido.getTxtMensaje().setBackground(Color.GREEN);
						bloquearListener = false;
					} else {
						setMensaje("No hay articulos");
						panelPedido.getTxtMensaje().setBackground(Color.RED);
					}
				}
			}
		});
		panelPedido.getBtnCancelar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comprobarPedidoProceso()) {
					pedidoProceso = false;
					logica.eliminarPedidoRejilla(modeloTabla);
					setMensaje("El pedido ha sido cancelado");
					panelPedido.getTxtMensaje().setBackground(Color.ORANGE);
				}
			}
		});
		panelPedido.getBtnNuevoPedido().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!comprobarPedidoProceso()) {
					pedidoProceso = true;
					String numeroPedido = String.valueOf(logica.getNumeroPosiblePedido());
					panelPedido.getTxtNumeroPedido().setText(numeroPedido);
					setMensaje("Nuevo pedido numero " + numeroPedido + " en proceso");
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
								setMensaje("Pedido completado satisfactoriamente");
								logica.eliminarPedidoRejilla(modeloTabla);
							} else {
								setMensaje("Fallo al encargar el pedido");
								panelPedido.getTxtMensaje().setBackground(Color.RED);
							}
						} else {
							setMensaje("Nada que encargar");
							panelPedido.getTxtMensaje().setBackground(Color.RED);
						}
					} else {
						setMensaje("No hay clientes");
						panelPedido.getTxtMensaje().setBackground(Color.RED);
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
						setMensaje("Linea borrada satisfactoriamente");
						panelPedido.getTxtMensaje().setBackground(Color.GREEN);
					} else {
						setMensaje("No se ha seleccionado linea de pedido");
						panelPedido.getTxtMensaje().setBackground(Color.RED);
					}
				}
			}
		});
		panelPedido.getComboClientesCrear().addActionListener((e) -> setMensaje("Cliente para el pedido seleccionado"));

		panelPedido.getComboArticulos()
				.addActionListener((e) -> setMensaje("Articulo seleccionado, pulse add para introducirlo al pedido"));

		panelPedido.getComboPedidos()
				.addActionListener((e) -> setMensaje("Pedido seleccionado, pulse ver para ver detalles"));

		panelPedido.getComboClientes().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!comprobarPedidoProceso()) {
					panelPedido.getComboPedidos().removeAllItems();
					panelPedido.getComboPedidos().setEnabled(true);
					logica.insertarPedidosEnCombo(panelPedido.getComboPedidos(),
							(String) panelPedido.getComboClientes().getSelectedItem(), panelPedido.getTxtMensaje());
					panelPedido.getBtnVer().setEnabled(true);
					panelPedido.revalidate();
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
						setMensaje("Mostrando el pedido " + numeroPedido + " del cliente con dni: " + dniNif);
						panelPedido.getTxtMensaje().setBackground(Color.GREEN);
					} else {
						panelPedido.getTxtMensaje().setBackground(Color.RED);
						setMensaje("No se ha seleccionado pedido");
					}
				}
			}
		});
		modeloTabla.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				if (pedidoProceso) {
					if (panelTabla.getTabla().getRowCount() != 0 && !bloquearListener) {
						bloquearListener = true;
						logica.cambiarPrecioRejilla(panelTabla.getTabla());
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
				panelArticulo.getMensajeConsulta().setText("");
				panelArticulo.getMensajeCrear().setText("");
				return null;
			}
		};
		worker.execute();
	}

	/**
	 * comprueba que hay un pedido en proceso o no e inserta un mensaje en el panel
	 * pedido
	 * 
	 * @return true si hay un pedido en proceso, false si no hay pedido en proceso
	 */
	private boolean comprobarPedidoProceso() {
		if (pedidoProceso) {
			setMensaje("Se esta creando un pedido ahora mismo, cancelelo o completelo");
		} else {
			setMensaje("Accion no disponible si no esta creando un pedido");
		}
		panelPedido.getTxtMensaje().setBackground(Color.RED);
		return pedidoProceso;
	}

	/**
	 * Pone el texto dado en el textfield del panelPedido para que salga como
	 * mensaje
	 * 
	 * @param mensaje
	 *            cadena de texto a poner como mensaje
	 */
	private void setMensaje(String mensaje) {
		panelPedido.getTxtMensaje().setText(mensaje);
		panelPedido.getTxtMensaje().setBackground(Color.GREEN);
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
				panelCliente.getLblMensaje().setText("No hay coincidencias");
			}
		} else {
			panelCliente.getLblMensaje().setText("Debe rellenar el campo de cliente");
		}
	}
}