package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;

import control.AccionesArticulo;
import control.AccionesCliente;
import control.AccionesPedido;
import control.AlmacenCliente;
import modelo.Cliente;

public class ParaUI extends UI {

	AccionesArticulo accionesArticulo;
	AccionesCliente accionesCliente;
	AccionesPedido accionesPedido;
	PanelPedido panelPedido;
	PanelTabla panelTabla;
	PanelCliente panelCliente;
	PanelArticulo panelArticulo;
	PanelMain panelMain;

	public ParaUI() {
		super();
		this.panelMain = new PanelMain();
		panelGeneralMain.add(panelMain);

		AlmacenCliente<Cliente, Object> inst = new AlmacenCliente<>();
		;
		ArrayList<Cliente> clientes = new ArrayList<>();
		for (Cliente cliente : clientes) {
			inst.grabar(cliente, cliente.getNumero());
		}

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

	private void ponerListenerArticulo() {

		panelArticulo.getBtnBuscar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionesArticulo.consultar(panelArticulo.getNombreConsultado().getText(),
						panelArticulo.getDetallesNombre(), panelArticulo.getDetallesID(),
						panelArticulo.getDetallesPrecio(), panelArticulo.getDetallesDescripcion());
			}
		});

		panelArticulo.getBtnCrear().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionesArticulo.crearArticulo(panelArticulo.getCrearNombre().getText(),
						Integer.parseInt(panelArticulo.getCrearPrecio().getText()),
						Integer.parseInt(panelArticulo.getCrearID().getText()),
						panelArticulo.getCrearDescripcion().getText());
			}
		});
		
		panelArticulo.getBtnCrear().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
				// TODO pilla el nombre del combobox donde esta los articulos
				panelPedido.getBtnCheck().setEnabled(true);
				panelPedido.getBtnDelete().setEnabled(true);
				panelPedido.revalidate();
			}
		});
		panelPedido.getBtnCheck().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TOD no se que hace el check
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
				ArrayList lineaPedido = new ArrayList<>();// TODO sacar las lineas de pedido desde la tabla, cada fila
															// una linwa
				int numero = getClienteIDFromCombo(panelPedido.getComboClientesCrear());
				if (accionesPedido.crear(lineaPedido, numero)) {
					panelPedido.getTxtMensaje().setText("Pedido completado satisfactoriamente");
				} else {
					panelPedido.getTxtMensaje().setText("Fallo al encargar el pedido");
				}

			}

		});
		panelPedido.getBtnDelete().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(panelTabla.getTabla().getRowCount());
				int row = panelTabla.getTabla().getSelectedRow();
				System.out.println(row);
				panelTabla.getTabla().remove(row);// TODO ????

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

	}

	private int getClienteIDFromCombo(JComboBox combo) {
		String cadenaCliente = combo.getSelectedItem().toString();
		int numero = Integer.valueOf(cadenaCliente.substring(0, cadenaCliente.indexOf("-")));
		return numero;
	}

}
