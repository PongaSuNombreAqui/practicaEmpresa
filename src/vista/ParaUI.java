package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.SwingWorker;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import control.Logica;
import utiles.Utiles;

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
	public ParaUI() {
		super();
		this.panelMain = new PanelMain();
		panelGeneralMain.add(panelMain);

		this.logica = new Logica();
		
		prepararTablaPedido();
		prepararTablaArticulo();
		prepararTablaCliente();

		// TODO action listeners all
		ponerListenersPedido();
		ponerListenerArticulo();
		ponerListenerCliente();

	}

	private void ponerListenerArticulo() {

		panelArticulo.getBtnBuscar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (true == logica.comprobarExistencia(panelArticulo.getNombreConsultado().getText())) {
					panelArticulo.aniadir(panelEditarArticulo);
					panelArticulo.revalidate();
					logica.consultar(panelArticulo.getNombreConsultado().getText(), panelArticulo.getDetallesNombre(),
							panelArticulo.getDetallesID(), panelArticulo.getDetallesPrecio(),
							panelArticulo.getDetallesDescripcion());
				} else {
					panelArticulo.getMensajeConsulta().setForeground(Color.RED);
					panelArticulo.getMensajeConsulta().setText("Error: El articulo no existe!!");
					Pausa(2);
				}
			}
		});

		panelArticulo.getBtnCrear().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (logica.crearArticulo(panelArticulo.getCrearNombre().getText(),
						Float.valueOf(panelArticulo.getCrearPrecio().getText()),
						Integer.valueOf(panelArticulo.getCrearID().getText()),
						panelArticulo.getCrearDescripcion().getText())) {
					logica.insertarArticulosEnCombo(panelPedido.getComboArticulos());
					panelArticulo.getMensajeCrear().setForeground(Color.GREEN);
					panelArticulo.getMensajeCrear().setText("El articulo ha sido creado.");
				} else {
					panelArticulo.getMensajeCrear().setForeground(Color.RED);
					panelArticulo.getMensajeCrear().setText("Error: El articulo ya existe!!");
				}
				Pausa(2);
			}
		});

		panelEditarArticulo.getBtnEditar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logica.editar(panelArticulo.getDetallesNombre().getText(),
						Float.valueOf(panelEditarArticulo.getNuevoPrecio().getText()));
				panelArticulo.getDetallesPrecio().setText(panelEditarArticulo.getNuevoPrecio().getText());
			}
		});

	}

	private void ponerListenerCliente() {
		// TODO Auto-generated method stub

	}

	private void ponerListenersPedido() {
		panelPedido.getBtnAdd().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comprobarPedidoProceso()) {
					String nombreArticulo = panelPedido.getComboArticulos().getSelectedItem().toString();
					logica.aniadirArticuloATabla(panelTabla.getTabla(), nombreArticulo);
					panelPedido.revalidate();
					panelPedido.getTxtMensaje().setText("Insertado en el pedido el articulo " + nombreArticulo);
				}
			}
		});
		panelPedido.getBtnCancelar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comprobarPedidoProceso()) {
					pedidoProceso=false;
					eliminarPedidoRejilla();
					panelPedido.getTxtMensaje().setText("El pedido ha sido cancelado");
				}
			}
		});
		panelPedido.getBtnNuevoPedido().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!comprobarPedidoProceso()) {
					pedidoProceso = true;
					String numeroPedido = String.valueOf(logica.getNumeroPosiblePedido());
					panelPedido.getTxtNumeroPedido().setText(numeroPedido);
					panelPedido.getTxtMensaje().setText("Nuevo pedido numero " + numeroPedido + " en proceso");
					logica.insertarArticulosEnCombo(panelPedido.getComboArticulos());
					logica.insertarClientesEnCombo(panelPedido.getComboClientesCrear());
					eliminarPedidoRejilla();
				}
			}

		});
		panelPedido.getBtnEncargar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comprobarPedidoProceso()) {
					if (panelPedido.getComboClientesCrear().getItemCount() != 0) {
						if (panelTabla.getTabla().getRowCount() != 0) {
							// TODO no se puede encargar si no hay nada en la
							// tabla
							// TODO que la combobox del nombre no este vacia,
							// por si
							// intenta crear un pedido
							// sin clientes en la aplicacion
							// TODO borrar tabla al encargar elpedido
							// (eliminarPedidoRejilla)
							String dniNif = getItemFromCombo(panelPedido.getComboClientesCrear());
							if (logica.crear(dniNif, panelTabla.getTabla())) {
								pedidoProceso = false;
								panelPedido.getTxtMensaje().setText("Pedido completado satisfactoriamente");
								eliminarPedidoRejilla();
							} else {
								panelPedido.getTxtMensaje().setText("Fallo al encargar el pedido");
							}
						} else {
							panelPedido.getTxtMensaje().setText("Nada que encargar");
						}
					} else {
						panelPedido.getTxtMensaje().setText("No hay clientes");
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
						panelPedido.getTxtMensaje().setText("Linea borrada satisfactoriamente");
					} else {
						panelPedido.getTxtMensaje().setText("No se ha seleccionado linea de pedido");
					}
				}
			}
		});
		panelPedido.getComboClientesCrear()
				.addActionListener((e) -> panelPedido.getTxtMensaje().setText("Cliente para el pedido seleccionado"));

		panelPedido.getComboArticulos().addActionListener((e) -> panelPedido.getTxtMensaje()
				.setText("Articulo seleccionado, pulse add para introducirlo al pedido"));

		panelPedido.getComboPedidos().addActionListener(
				(e) -> panelPedido.getTxtMensaje().setText("Pedido seleccionado, pulse ver para ver detalles"));

		panelPedido.getComboClientes().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!comprobarPedidoProceso()) {
					panelPedido.getComboPedidos().removeAllItems();
					panelPedido.getComboPedidos().setEnabled(true);
					logica.insertarPedidosEnCombo(panelPedido.getComboPedidos(),
							(String) panelPedido.getComboClientes().getSelectedItem(),panelPedido.getTxtMensaje());
					panelPedido.getBtnVer().setEnabled(true);
					panelPedido.revalidate();
				}
			}
		});

		panelPedido.getBtnVer().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!comprobarPedidoProceso()) {
					if (panelPedido.getComboPedidos().getItemCount() != 0 && panelPedido.getComboClientes().getItemCount() != 0) {
						panelPedido.getBtnVer().setEnabled(false);
						panelPedido.getComboPedidos().setEnabled(false);
						String dniNif = getItemFromCombo(panelPedido.getComboClientes());
						int numeroPedido =Integer.valueOf(getItemFromCombo(panelPedido.getComboPedidos()));
						eliminarPedidoRejilla();
						panelPedido.getTxtMensaje()
								.setText("Mostrando el pedido " + numeroPedido + " del cliente con dni: " + dniNif);
						logica.consultar(panelTabla.getTabla(), numeroPedido, dniNif);
					} else {
						panelPedido.getTxtMensaje().setText("No se ha seleccionado pedido");
					}
				}
			}
		});
		
		modeloTabla.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO actualizar los precios totales, si aumentan la cantidad
				// aumenta el total
				
			}
		});
	}

	private void prepararTablaPedido() {
		this.panelPedido = new PanelPedido(); // crea el panelpedido
		this.panelTabla = new PanelTabla(); // crea el paneltabla
		this.panelPedido.addPanelTabla(panelTabla); // mete el paneltabla en el
													// panelpedido
		panelGeneralPedido.add(panelPedido);
		logica.insertarClientesEnCombo(panelPedido.getComboClientes());
		this.pedidoProceso = false;
		this.modeloTabla = (DefaultTableModel) panelTabla.getTabla().getModel();
	}

	private void prepararTablaCliente() {
		this.panelCliente = new PanelCliente();
		panelGeneralCliente.add(panelCliente);

	}

	private void prepararTablaArticulo() {
		this.panelArticulo = new PanelArticulo();
		panelGeneralArticulo.add(panelArticulo);
		this.panelEditarArticulo = new PanelEditarArticulo();

	}

	private String getItemFromCombo(JComboBox combo) {
		String cadenaCliente = (String) combo.getSelectedItem();
		 return cadenaCliente.substring(cadenaCliente.indexOf(Utiles.separador) + 1);
		 
	}

	private void eliminarPedidoRejilla() {
		int rows = modeloTabla.getRowCount();
		for (int i = rows - 1; i >= 0; i--) {
			modeloTabla.removeRow(i);
		}
	}

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

	private boolean comprobarPedidoProceso() {
		if (!pedidoProceso) {
			panelPedido.getTxtMensaje().setText("Accion no disponible si no esta creando un pedido");
		} else {
			panelPedido.getTxtMensaje().setText("Se esta crendo un pedido ahora mismo, cancelelo o completelo");
		}
		return pedidoProceso;
	}
}
