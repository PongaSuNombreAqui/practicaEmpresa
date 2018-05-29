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

		final SwingWorker worker = new SwingWorker() {
			@Override
			protected Object doInBackground() throws Exception {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				panelArticulo.getMensajeCrear().setText("");
				panelArticulo.getMensajeConsulta().setText("");
				return null;
			}
		};

		panelArticulo.getBtnBuscar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionesArticulo.consultar(panelArticulo.getNombreConsultado().getText(),
						panelArticulo.getDetallesNombre(), panelArticulo.getDetallesID(),
						panelArticulo.getDetallesPrecio(), panelArticulo.getDetallesDescripcion());
			}
		});

		panelArticulo.getBtnCrear().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Thread
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
				worker.execute();
			}
		});

		panelArticulo.getBtnBuscar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (true == accionesArticulo.comprobarExistencia(panelArticulo.getNombreConsultado().getText())) {
					panelArticulo.aniadir(panelEditarArticulo);
					panelArticulo.revalidate();
				} else {
					panelArticulo.getMensajeConsulta().setForeground(Color.RED);
					panelArticulo.getMensajeConsulta().setText("Error : El articulo no existe!!");
				}
				worker.execute();
			}
		});

		panelEditarArticulo.getBtnEditar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionesArticulo.editar(panelArticulo.getDetallesNombre().getText(),
						Integer.valueOf(panelEditarArticulo.getNuevoPrecio().getText()));
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
				ArrayList<Linea> lineas = new ArrayList<>();
				// TODO sacar las  lineas de pedido desde la tabla, cada fila una linwa
				//TODO no se puede encargar si no hay nada en la tabla
				String dniNif = getClienteIDFromCombo(panelPedido.getComboClientesCrear());
				if (accionesPedido.crear(dniNif)) {
					panelPedido.getTxtMensaje().setText("Pedido completado satisfactoriamente");
				} else {
					panelPedido.getTxtMensaje().setText("Fallo al encargar el pedido");
				}
			}

		});
		panelPedido.getBtnDelete().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) panelTabla.getTabla().getModel();
				int seleccionada = panelTabla.getTabla().getSelectedRow();
				model.removeRow(seleccionada);
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
			}
		});
		DefaultTableModel dm=(DefaultTableModel) panelTabla.getTabla().getModel();
		dm.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				//TODO actualizar los precios totales, si aumentan la cantidad aumenta el total
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

}
