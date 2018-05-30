package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.SwingWorker;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import control.AccionesArticulo;
import control.AccionesCliente;
import control.AccionesPedido;
import control.AlmacenIndice;
import modelo.Cliente;
import modelo.Linea;

public class ParaUI extends UI {

	AccionesArticulo accionesArticulo;
	AccionesCliente accionesCliente;
	AccionesPedido accionesPedido;
	PanelPedido panelPedido;
	PanelTabla panelTabla;
	PanelCliente panelCliente;
	PanelArticulo panelArticulo;
	PanelMain panelMain;
	PanelEditarArticulo panelEditarArticulo;

	public ParaUI() {
		super();
		this.panelMain = new PanelMain();
		panelGeneralMain.add(panelMain);

		this.accionesArticulo = new AccionesArticulo();
		this.accionesCliente = new AccionesCliente();
		this.accionesPedido = new AccionesPedido();

		prepararTablaPedido();
		prepararTablaArticulo();
		prepararTablaCliente();

		// TODO action listeners all
		ponerListenersPedido();
		ponerListenerArticulo();
		ponerListenerCliente();

	}

	private void Pausa(int tiempo) {

		final SwingWorker worker = new SwingWorker() {
			@Override
			protected Object doInBackground() throws Exception {
				try {
					Thread.sleep(tiempo * 1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				return null;
			}
		};
		worker.execute();
	}

	private void ponerListenerArticulo() {

		panelArticulo.getBtnBuscar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (true == accionesArticulo.comprobarExistencia(panelArticulo.getNombreConsultado().getText())) {
					accionesArticulo.consultar(panelArticulo.getNombreConsultado().getText(),
							panelArticulo.getDetallesNombre(), panelArticulo.getDetallesID(),
							panelArticulo.getDetallesPrecio(), panelArticulo.getDetallesDescripcion());
				}
			}
		});

		panelArticulo.getBtnCrear().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final SwingWorker borrarMensajeCrear = new SwingWorker() {
					@Override
					protected Object doInBackground() throws Exception {
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						panelArticulo.getMensajeCrear().setText("");
						return null;
					}
				};
				if (accionesArticulo.crearArticulo(panelArticulo.getCrearNombre().getText(),
						Float.valueOf(panelArticulo.getCrearPrecio().getText()),
						Integer.valueOf(panelArticulo.getCrearID().getText()),
						panelArticulo.getCrearDescripcion().getText())) {
					accionesArticulo.insertarArticulosEnCombo(panelPedido.getComboArticulos());
					panelArticulo.getMensajeCrear().setForeground(Color.GREEN);
					panelArticulo.getMensajeCrear().setText("El articulo ha sido creado");
				} else {
					panelArticulo.getMensajeCrear().setForeground(Color.RED);
					panelArticulo.getMensajeCrear().setText("Error : El articulo ya existe!!");
				}
				borrarMensajeCrear.execute();
			}
		});

		panelArticulo.getBtnBuscar().addActionListener(new ActionListener() {
			final SwingWorker borrarMensajeConsulta = new SwingWorker() {
				@Override
				protected Object doInBackground() throws Exception {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					panelArticulo.getMensajeConsulta().setText("");
					return null;
				}
			};

			public void actionPerformed(ActionEvent arg0) {
				if (true == accionesArticulo.comprobarExistencia(panelArticulo.getNombreConsultado().getText())) {
					panelArticulo.aniadir(panelEditarArticulo);
					panelArticulo.revalidate();
				} else {
					panelArticulo.getMensajeConsulta().setForeground(Color.RED);
					panelArticulo.getMensajeConsulta().setText("Error : El articulo no existe!!");
					borrarMensajeConsulta.execute();
				}
			}
		});

		panelEditarArticulo.getBtnEditar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionesArticulo.editar(panelArticulo.getDetallesNombre().getText(),
						Integer.valueOf(panelEditarArticulo.getNuevoPrecio().getText()));
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
				accionesPedido.aniadirArticuloATabla(panelTabla.getTabla(),
						(String) panelPedido.getComboArticulos().getSelectedItem());
				panelPedido.getBtnCheck().setEnabled(true);
				panelPedido.getBtnDelete().setEnabled(true);
				panelPedido.revalidate();
			}
		});
		panelPedido.getBtnCheck().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO no se que hace el check(posible cancelar pedido)
			}
		});
		panelPedido.getBtnNuevoPedido().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPedido.getComboArticulos().setEnabled(true);
				panelPedido.getBtnEncargar().setEnabled(true);
				panelPedido.getComboClientesCrear().setEnabled(true);
				panelPedido.getBtnNuevoPedido().setEnabled(false);
				panelPedido.getBtnVer().setEnabled(false);
				panelPedido.getComboClientes().setEnabled(false);
				panelPedido.getTxtNumeroPedido().setText(String.valueOf(accionesPedido.getNumeroPosiblePedido()));
			}
		});
		panelPedido.getBtnEncargar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelPedido.getBtnNuevoPedido().setEnabled(true);
				panelPedido.getComboArticulos().setEnabled(false);
				panelPedido.getBtnEncargar().setEnabled(false);
				panelPedido.getBtnDelete().setEnabled(false);
				panelPedido.getComboClientesCrear().setEditable(false);
				panelPedido.getBtnCheck().setEnabled(false);
				panelPedido.getBtnAdd().setEnabled(false);
				panelPedido.getComboClientes().setEnabled(true);
				// TODO no se puede encargar si no hay nada en la tabla
				// TODO que la combobox del nombre no este vacia, por si intenta crear un pedido
				// sin clientes en la aplicacion
				//TODO borrar tabla al encargar elpedido
				DefaultTableModel modelo = (DefaultTableModel) panelTabla.getTabla().getModel();
				String dniNif = getClienteIDFromCombo(panelPedido.getComboClientesCrear());
				if (accionesPedido.crear(dniNif, modelo)) {
					panelPedido.getTxtMensaje().setText("Pedido completado satisfactoriamente");
				} else {
					panelPedido.getTxtMensaje().setText("Fallo al encargar el pedido");
				}
			}

		});
		panelPedido.getBtnDelete().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) panelTabla.getTabla().getModel();
				if (!panelTabla.getTabla().getSelectionModel().isSelectionEmpty()) {
					int seleccionada = panelTabla.getTabla().getSelectedRow();
					model.removeRow(seleccionada);
				} else {
					panelPedido.getTxtMensaje().setText("No se ha seleccionado linea de pedido");
				}
			}
		});
		panelPedido.getComboArticulos().addActionListener((e) -> panelPedido.getBtnAdd().setEnabled(true));
		panelPedido.getComboClientes().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPedido.getComboPedidos().removeAllItems();
				panelPedido.getComboPedidos().setEnabled(true);
				accionesCliente.insertarPedidosEnCombo(panelPedido.getComboPedidos(),
						(String) panelPedido.getComboClientes().getSelectedItem());
				panelPedido.revalidate();
				panelPedido.getBtnVer().setEnabled(true);
			}
		});
		panelPedido.getBtnVer().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPedido.getBtnVer().setEnabled(false);
				String dniNif = getClienteIDFromCombo(panelPedido.getComboClientesCrear());
				int numeroPedido = getNumeroPedidoFromCombo(panelPedido.getComboPedidos());				
				eliminarPedidoRejilla();
				accionesPedido.consultar(panelTabla.getTabla(), numeroPedido, dniNif);
			}
		});
		DefaultTableModel dm = (DefaultTableModel) panelTabla.getTabla().getModel();
		dm.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO actualizar los precios totales, si aumentan la cantidad aumenta el total
			}
		});
	}

	private void prepararTablaPedido() {
		this.panelPedido = new PanelPedido(); // crea el panelpedido
		this.panelTabla = new PanelTabla(); // crea el paneltabla
		this.panelPedido.addPanelTabla(panelTabla); // mete el paneltabla en el
													// panelpedido
		panelGeneralPedido.add(panelPedido);
		accionesArticulo.insertarArticulosEnCombo(panelPedido.getComboArticulos());
		accionesCliente.insertarClientesEnCombo(panelPedido.getComboClientes());
		accionesCliente.insertarClientesEnCombo(panelPedido.getComboClientesCrear());
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

	private String getClienteIDFromCombo(JComboBox<String> combo) {
		String cadenaCliente = combo.getSelectedItem().toString();
		String dniNif = cadenaCliente.substring(cadenaCliente.indexOf(" ") + 1);
		return dniNif;
	}
	
	protected int getNumeroPedidoFromCombo(JComboBox comboPedidos) {
		String numeroPedido = comboPedidos.getSelectedItem().toString();
		numeroPedido = numeroPedido.substring(numeroPedido.lastIndexOf(" ") + 1);
		return Integer.parseInt(numeroPedido);
	}

	private void eliminarPedidoRejilla() {
		DefaultTableModel modelo = (DefaultTableModel) panelTabla.getTabla().getModel(); 
		int rows = modelo.getRowCount(); 
		for(int i = rows - 1; i >=0; i--)
		{
		   modelo.removeRow(i);
		}
	}

}
