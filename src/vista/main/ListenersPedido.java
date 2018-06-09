package vista.main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import control.Logica;
import vista.paneles.PanelPedido;
import vista.paneles.PanelTabla;

public class ListenersPedido {

	private Logica logica;
	private PanelPedido panelPedido;
	private PanelTabla panelTabla;
	private boolean pedidoProceso;
	private DefaultTableModel modeloTabla;
	private boolean bloquearListener;
	private AccionesParaUI accPUI;

	public ListenersPedido(PanelPedido panelPedido, PanelTabla panelTabla, AccionesParaUI accPUI, Logica logica) {
		this.pedidoProceso = false;
		this.bloquearListener = false;
		this.modeloTabla = (DefaultTableModel) panelTabla.getTabla().getModel();
		this.panelPedido = panelPedido;
		this.panelTabla = panelTabla;
		this.accPUI = accPUI;
		this.logica = logica;
		ponerListenersPedido();
	}

	private void ponerListenersPedido() {
		panelPedido.getBtnAdd().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if (comprobarPedidoProceso()) {
				if (panelPedido.getComboArticulos().getItemCount() != 0) {
					bloquearListener = false;
					String nombreArticulo = panelPedido.getComboArticulos().getSelectedItem().toString();
					int linea = logica.comprobarArticuloPedido(modeloTabla, nombreArticulo);
					if (linea == -1) {
						logica.aniadirArticuloATabla(nombreArticulo, modeloTabla);
						panelPedido.revalidate();
						accPUI.setMensaje("Insertado en el pedido el articulo " + nombreArticulo, Color.GREEN,
								panelPedido.getTextMensaje());
					} else {
						panelTabla.getTabla().changeSelection(linea, 3, false, false);
						logica.cambiarCantidadArticuloTabla(modeloTabla, linea);
						
					}
					bloquearListener = false;
				} else {
					accPUI.setMensaje("No hay articulos", Color.RED, panelPedido.getTextMensaje());
				}
			}
		});

		panelPedido.getBtnCancelar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comprobarPedidoProceso()) {
					pedidoProceso = false;
					logica.eliminarPedidoRejilla(modeloTabla);
					accPUI.setMensaje("El pedido ha sido cancelado", Color.ORANGE, panelPedido.getTextMensaje());
				}
			}
		});

		panelPedido.getBtnNuevoPedido().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!comprobarPedidoProceso()) {
					pedidoProceso = true;
					String numeroPedido = String.valueOf(logica.getNumeroPosiblePedido());
					panelPedido.getTxtNumeroPedido().setText(numeroPedido);
					accPUI.setMensaje("Nuevo pedido numero " + numeroPedido + " en proceso", Color.GREEN,
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
								accPUI.setMensaje("Pedido completado satisfactoriamente", Color.GREEN,
										panelPedido.getTextMensaje());
								logica.eliminarPedidoRejilla(modeloTabla);
							} else {
								accPUI.setMensaje("Fallo al encargar el pedido", Color.RED, panelPedido.getTextMensaje());
							}
						} else {
							accPUI.setMensaje("Nada que encargar", Color.RED, panelPedido.getTextMensaje());
							panelPedido.getTextMensaje().setBackground(Color.RED);
						}
					} else {
						accPUI.setMensaje("No hay clientes", Color.RED, panelPedido.getTextMensaje());
					}
				}
			}
		});
		panelPedido.getBtnDelete().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comprobarPedidoProceso()) {
					if (!panelTabla.getTabla().getSelectionModel().isSelectionEmpty()) {
						int seleccionada = panelTabla.getTabla().getSelectedRow();
						panelTabla.getTabla().clearSelection();
						modeloTabla.removeRow(seleccionada);
						accPUI.setMensaje("Linea borrada satisfactoriamente", Color.GREEN, panelPedido.getTextMensaje());
					} else {
						accPUI.setMensaje("No se ha seleccionado linea de pedido", Color.RED, panelPedido.getTextMensaje());
					}
				}
			}
		});
		panelPedido.getComboClientesCrear().addActionListener(
				(e) -> accPUI.setMensaje("Cliente para el pedido seleccionado", Color.GREEN, panelPedido.getTextMensaje()));

		panelPedido.getComboArticulos()
				.addActionListener((e) -> accPUI.setMensaje("Articulo seleccionado, pulse add para introducirlo al pedido",
						Color.GREEN, panelPedido.getTextMensaje()));

		panelPedido.getComboPedidos()
				.addActionListener((e) -> accPUI.setMensaje("Pedido seleccionado, pulse ver para ver detalles", Color.GREEN,
						panelPedido.getTextMensaje()));

		panelPedido.getComboClientes().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!comprobarPedidoProceso()) {
					if (panelPedido.getComboClientes().getItemCount() > 0) {
						panelPedido.getComboPedidos().removeAllItems();
						panelPedido.getComboPedidos().setEnabled(true);
						if (logica.insertarPedidosEnCombo(panelPedido.getComboPedidos(),
								(String) panelPedido.getComboClientes().getSelectedItem())) {
							panelPedido.getBtnVer().setEnabled(true);
						} else {
							accPUI.setMensaje("El cliente seleccionado no tiene pedidos", Color.RED,
									panelPedido.getTextMensaje());
							panelPedido.getComboPedidos().setEnabled(false);
							panelPedido.getBtnVer().setEnabled(false);
						}
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
						accPUI.setMensaje("Mostrando el pedido " + numeroPedido + " del cliente con dni: " + dniNif,
								Color.GREEN, panelPedido.getTextMensaje());
					} else {
						accPUI.setMensaje("No se ha seleccionado pedido", Color.RED, panelPedido.getTextMensaje());
					}
				}
			}
		});
		modeloTabla.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				float precioTotal = logica.cambiarPrecioTotalPedido(panelTabla.getTabla());
				// TODO eliminar comillas
				panelPedido.getLblTotalPrecio().setText("" + precioTotal);
				if (pedidoProceso) {
					int fila = panelTabla.getTabla().getSelectedRow();
					if (panelTabla.getTabla().getRowCount() != 0 && !bloquearListener && fila != -1) {
						bloquearListener = true;
						logica.cambiarPrecioRejilla(modeloTabla, fila);
						bloquearListener = false;
					}
				}
			}
		});
	}

	/**
	 * comprueba que hay un pedido en proceso o no e inserta un mensaje en el
	 * panel pedido
	 * 
	 * @return true si hay un pedido en proceso, false si no hay pedido en
	 *         proceso
	 */
	boolean comprobarPedidoProceso() {
		if (pedidoProceso) {
			accPUI.setMensaje("Se esta creando un pedido ahora mismo, cancelelo o completelo", Color.RED,
					panelPedido.getTextMensaje());
		} else {
			accPUI.setMensaje("Accion no disponible si no esta creando un pedido", Color.RED,
					panelPedido.getTextMensaje());
		}
		return pedidoProceso;
	}
}
