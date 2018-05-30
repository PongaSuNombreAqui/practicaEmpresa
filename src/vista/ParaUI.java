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

import control.Logica;
import control.almacenes.AlmacenIndice;
import modelo.Cliente;
import modelo.Linea;

public class ParaUI extends UI {

	Logica logica;
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
					logica.consultar(panelArticulo.getNombreConsultado().getText(),
							panelArticulo.getDetallesNombre(), panelArticulo.getDetallesID(),
							panelArticulo.getDetallesPrecio(), panelArticulo.getDetallesDescripcion());
				} else {
					panelArticulo.getMensajeConsulta().setForeground(Color.RED);
					panelArticulo.getMensajeConsulta().setText("Error : El articulo no existe!!");
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
					panelArticulo.getMensajeCrear().setText("El articulo ha sido creado");
				} else {
					panelArticulo.getMensajeCrear().setForeground(Color.RED);
					panelArticulo.getMensajeCrear().setText("Error : El articulo ya existe!!");
				}
				Pausa(2);
			}
		});

		panelEditarArticulo.getBtnEditar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logica.editar(panelArticulo.getDetallesNombre().getText(),
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
				logica.aniadirArticuloATabla(panelTabla.getTabla(),
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
				panelPedido.getTxtNumeroPedido().setText(String.valueOf(logica.getNumeroPosiblePedido()));
			}
		});
		panelPedido.getBtnEncargar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (panelPedido.getComboClientesCrear().getItemCount() != 0) {
					if (panelTabla.getTabla().getRowCount() != 0) {
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
						//TODO borrar tabla al encargar elpedido (eliminarPedidoRejilla)
						
						String dniNif = getClienteIDFromCombo(panelPedido.getComboClientesCrear());
						if (logica.crear(dniNif, modelo)) {
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
				logica.insertarPedidosEnCombo(panelPedido.getComboPedidos(),
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
				logica.consultar(panelTabla.getTabla(), numeroPedido, dniNif);
			}
		});
		DefaultTableModel dm = (DefaultTableModel) panelTabla.getTabla().getModel();
		dm.addTableModelListener(new TableModelListener() {
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
		logica.insertarArticulosEnCombo(panelPedido.getComboArticulos());
		logica.insertarClientesEnCombo(panelPedido.getComboClientes());
		logica.insertarClientesEnCombo(panelPedido.getComboClientesCrear());
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
		for (int i = rows - 1; i >= 0; i--) {
			modelo.removeRow(i);
		}
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
				panelArticulo.getMensajeConsulta().setText("");
				panelArticulo.getMensajeCrear().setText("");
				return null;
			}
		};
		worker.execute();
	}
}
