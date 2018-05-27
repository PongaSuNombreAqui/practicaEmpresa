package vista;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;

import modelo.Articulo;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;

public class PanelPedido extends JPanel {
	private JButton btnAdd;
	private JButton btnCheck;
	private JComboBox comboArticulos;
	private JPanel panelTabla;
	private JTextField txtMensaje;
	private JButton btnNuevoPedido;
	private JButton btnEncargar;
	private JTextField txtNumeroPedido;
	private JButton btnDelete;
	private JButton btnVer;
	private JComboBox comboPedidos;
	private JComboBox comboClientes;
	private JComboBox comboClientesCrear;




	public PanelPedido() {
		setForeground(Color.GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 371, 319, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 80, 244, 12, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panelConsultarPedido = new JPanel();
		panelConsultarPedido.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_panelConsultarPedido = new GridBagConstraints();
		gbc_panelConsultarPedido.insets = new Insets(0, 0, 5, 5);
		gbc_panelConsultarPedido.fill = GridBagConstraints.BOTH;
		gbc_panelConsultarPedido.gridx = 1;
		gbc_panelConsultarPedido.gridy = 0;
		add(panelConsultarPedido, gbc_panelConsultarPedido);
		GridBagLayout gbl_panelConsultarPedido = new GridBagLayout();
		gbl_panelConsultarPedido.columnWidths = new int[]{23, 0, 77, 0, 0, 0};
		gbl_panelConsultarPedido.rowHeights = new int[]{6, 37, 0, 26, 0, 13, 0, 0};
		gbl_panelConsultarPedido.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelConsultarPedido.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panelConsultarPedido.setLayout(gbl_panelConsultarPedido);
		
		JLabel lblCrearPedido = new JLabel("Crear Pedido");
		lblCrearPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrearPedido.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblCrearPedido = new GridBagConstraints();
		gbc_lblCrearPedido.fill = GridBagConstraints.BOTH;
		gbc_lblCrearPedido.gridwidth = 5;
		gbc_lblCrearPedido.insets = new Insets(0, 0, 5, 0);
		gbc_lblCrearPedido.gridx = 0;
		gbc_lblCrearPedido.gridy = 1;
		panelConsultarPedido.add(lblCrearPedido, gbc_lblCrearPedido);
		
		btnNuevoPedido = new JButton("Nuevo Pedido");
		GridBagConstraints gbc_btnNuevoPedido = new GridBagConstraints();
		gbc_btnNuevoPedido.fill = GridBagConstraints.BOTH;
		gbc_btnNuevoPedido.insets = new Insets(0, 0, 5, 5);
		gbc_btnNuevoPedido.gridx = 1;
		gbc_btnNuevoPedido.gridy = 2;
		panelConsultarPedido.add(btnNuevoPedido, gbc_btnNuevoPedido);
		
		btnEncargar = new JButton("Encargar");
		btnEncargar.setEnabled(false);
		GridBagConstraints gbc_btnEncargar = new GridBagConstraints();
		gbc_btnEncargar.fill = GridBagConstraints.BOTH;
		gbc_btnEncargar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEncargar.gridx = 3;
		gbc_btnEncargar.gridy = 2;
		panelConsultarPedido.add(btnEncargar, gbc_btnEncargar);
		
		JLabel lblN = new JLabel("n\u00BA");
		GridBagConstraints gbc_lblN = new GridBagConstraints();
		gbc_lblN.anchor = GridBagConstraints.EAST;
		gbc_lblN.insets = new Insets(0, 0, 5, 5);
		gbc_lblN.gridx = 0;
		gbc_lblN.gridy = 3;
		panelConsultarPedido.add(lblN, gbc_lblN);
		
		txtNumeroPedido = new JTextField();
		txtNumeroPedido.setEditable(false);
		GridBagConstraints gbc_txtNumeroPedido = new GridBagConstraints();
		gbc_txtNumeroPedido.insets = new Insets(0, 0, 5, 5);
		gbc_txtNumeroPedido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumeroPedido.gridx = 1;
		gbc_txtNumeroPedido.gridy = 3;
		panelConsultarPedido.add(txtNumeroPedido, gbc_txtNumeroPedido);
		txtNumeroPedido.setColumns(10);
		
		JLabel lblNombrecliente = new JLabel("Cliente");
		GridBagConstraints gbc_lblNombrecliente = new GridBagConstraints();
		gbc_lblNombrecliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombrecliente.gridx = 2;
		gbc_lblNombrecliente.gridy = 3;
		panelConsultarPedido.add(lblNombrecliente, gbc_lblNombrecliente);
		
		comboClientesCrear = new JComboBox();
		comboClientesCrear.setEnabled(false);
		GridBagConstraints gbc_comboClientesCrear = new GridBagConstraints();
		gbc_comboClientesCrear.insets = new Insets(0, 0, 5, 5);
		gbc_comboClientesCrear.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboClientesCrear.gridx = 3;
		gbc_comboClientesCrear.gridy = 3;
		panelConsultarPedido.add(comboClientesCrear, gbc_comboClientesCrear);
		
		btnAdd = new JButton("add");
		btnAdd.setEnabled(false);

		btnAdd.setToolTipText("a\u00F1adir articulo al pedido");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.fill = GridBagConstraints.BOTH;
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 4;
		panelConsultarPedido.add(btnAdd, gbc_btnAdd);
		
		btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.fill = GridBagConstraints.BOTH;
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.gridx = 2;
		gbc_btnDelete.gridy = 4;
		panelConsultarPedido.add(btnDelete, gbc_btnDelete);
		
		btnCheck = new JButton("check");
		btnCheck.setEnabled(false);
		btnCheck.setToolTipText("checkear articulo del pedido");
		GridBagConstraints gbc_btnCheck = new GridBagConstraints();
		gbc_btnCheck.fill = GridBagConstraints.BOTH;
		gbc_btnCheck.insets = new Insets(0, 0, 5, 5);
		gbc_btnCheck.gridx = 3;
		gbc_btnCheck.gridy = 4;
		panelConsultarPedido.add(btnCheck, gbc_btnCheck);
		
		comboArticulos = new JComboBox();
		comboArticulos.setEnabled(false);
		comboArticulos.setToolTipText("seleccion de articulos posibles");
		GridBagConstraints gbc_comboArticulos = new GridBagConstraints();
		gbc_comboArticulos.gridwidth = 3;
		gbc_comboArticulos.insets = new Insets(0, 0, 0, 5);
		gbc_comboArticulos.fill = GridBagConstraints.BOTH;
		gbc_comboArticulos.gridx = 1;
		gbc_comboArticulos.gridy = 6;
		panelConsultarPedido.add(comboArticulos, gbc_comboArticulos);

		JPanel panelCrearPedido = new JPanel();
		panelCrearPedido.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_panelCrearPedido = new GridBagConstraints();
		gbc_panelCrearPedido.insets = new Insets(0, 0, 5, 5);
		gbc_panelCrearPedido.fill = GridBagConstraints.BOTH;
		gbc_panelCrearPedido.gridx = 2;
		gbc_panelCrearPedido.gridy = 0;
		add(panelCrearPedido, gbc_panelCrearPedido);
		GridBagLayout gbl_panelCrearPedido = new GridBagLayout();
		gbl_panelCrearPedido.columnWidths = new int[]{37, 87, 91, 0, 0};
		gbl_panelCrearPedido.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelCrearPedido.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelCrearPedido.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panelCrearPedido.setLayout(gbl_panelCrearPedido);
		
		JLabel lblConsultarPedido = new JLabel("Consultar Pedido");
		lblConsultarPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultarPedido.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblConsultarPedido = new GridBagConstraints();
		gbc_lblConsultarPedido.fill = GridBagConstraints.BOTH;
		gbc_lblConsultarPedido.insets = new Insets(0, 0, 5, 0);
		gbc_lblConsultarPedido.gridwidth = 4;
		gbc_lblConsultarPedido.gridx = 0;
		gbc_lblConsultarPedido.gridy = 1;
		panelCrearPedido.add(lblConsultarPedido, gbc_lblConsultarPedido);
		
		JLabel lblNombreCliente = new JLabel("Cliente");
		lblNombreCliente.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNombreCliente = new GridBagConstraints();
		gbc_lblNombreCliente.fill = GridBagConstraints.BOTH;
		gbc_lblNombreCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreCliente.gridx = 0;
		gbc_lblNombreCliente.gridy = 2;
		panelCrearPedido.add(lblNombreCliente, gbc_lblNombreCliente);
		
		comboClientes = new JComboBox();
		GridBagConstraints gbc_comboClientes = new GridBagConstraints();
		gbc_comboClientes.gridwidth = 2;
		gbc_comboClientes.insets = new Insets(0, 0, 5, 5);
		gbc_comboClientes.fill = GridBagConstraints.BOTH;
		gbc_comboClientes.gridx = 1;
		gbc_comboClientes.gridy = 2;
		panelCrearPedido.add(comboClientes, gbc_comboClientes);
		
		JLabel lblPedido = new JLabel("Pedidos");
		lblPedido.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblPedido = new GridBagConstraints();
		gbc_lblPedido.fill = GridBagConstraints.BOTH;
		gbc_lblPedido.insets = new Insets(0, 0, 5, 5);
		gbc_lblPedido.gridx = 0;
		gbc_lblPedido.gridy = 4;
		panelCrearPedido.add(lblPedido, gbc_lblPedido);
		
		comboPedidos = new JComboBox();
		comboPedidos.setEnabled(false);
		GridBagConstraints gbc_comboPedidos = new GridBagConstraints();
		gbc_comboPedidos.gridwidth = 2;
		gbc_comboPedidos.insets = new Insets(0, 0, 5, 5);
		gbc_comboPedidos.fill = GridBagConstraints.BOTH;
		gbc_comboPedidos.gridx = 1;
		gbc_comboPedidos.gridy = 4;
		panelCrearPedido.add(comboPedidos, gbc_comboPedidos);
		
		btnVer = new JButton("VER PEDIDO DEL CLIENTE");
		GridBagConstraints gbc_btnVer = new GridBagConstraints();
		gbc_btnVer.gridwidth = 2;
		gbc_btnVer.fill = GridBagConstraints.BOTH;
		gbc_btnVer.insets = new Insets(0, 0, 5, 5);
		gbc_btnVer.gridx = 1;
		gbc_btnVer.gridy = 5;
		panelCrearPedido.add(btnVer, gbc_btnVer);
		
		txtMensaje = new JTextField();
		txtMensaje.setEditable(false);
		GridBagConstraints gbc_txtMensaje = new GridBagConstraints();
		gbc_txtMensaje.gridwidth = 4;
		gbc_txtMensaje.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMensaje.gridx = 0;
		gbc_txtMensaje.gridy = 6;
		panelCrearPedido.add(txtMensaje, gbc_txtMensaje);
		txtMensaje.setColumns(10);

	}



	public JComboBox getComboPedidos() {
		return comboPedidos;
	}



	public JComboBox getComboClientes() {
		return comboClientes;
	}

	
	public JButton getBtnVer() {
		return btnVer;
	}



	public JButton getBtnDelete() {
		return btnDelete;
	}



	public JTextField getTxtNumeroPedido() {
		return txtNumeroPedido;
	}


	public JComboBox getComboClientesCrear() {
		return comboClientesCrear;
	}



	public JTextField getTxtMensaje() {
		return txtMensaje;
	}



	public JButton getBtnNuevoPedido() {
		return btnNuevoPedido;
	}



	public JButton getBtnEncargar() {
		return btnEncargar;
	}



	public void addPanelTabla(PanelTabla panel) {
		panelTabla = new JPanel();
		GridBagConstraints gbc_panelTabla = new GridBagConstraints();
		gbc_panelTabla.gridwidth = 2;
		gbc_panelTabla.insets = new Insets(0, 0, 5, 5);
		gbc_panelTabla.fill = GridBagConstraints.BOTH;
		gbc_panelTabla.gridx = 1;
		gbc_panelTabla.gridy = 1;
		add(panelTabla, gbc_panelTabla);
		panelTabla.setLayout(new GridLayout(0, 1, 0, 0));
		PanelTabla panelTabla_1 = panel;
		GridBagLayout gridBagLayout_1 = (GridBagLayout) panelTabla_1.getLayout();
		gridBagLayout_1.rowHeights = new int[] { 79 };
		panelTabla.add(panelTabla_1);
	}



	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JButton getBtnCheck() {
		return btnCheck;
	}

	public JComboBox getComboArticulos() {
		return comboArticulos;
	}

	public JPanel getPanelTabla() {
		return panelTabla;
	}


}
