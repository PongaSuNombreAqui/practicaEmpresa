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

public class PanelPedido extends JPanel {
	private JButton btnAdd;
	private JButton btnCheck;
	private JComboBox comboArticulos;
	private JPanel panelTabla;
	private JTextField textField_1;




	public PanelPedido() {
		setForeground(Color.GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 371, 319, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 80, 244, 12, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panelConsultarPedido = new JPanel();
		GridBagConstraints gbc_panelConsultarPedido = new GridBagConstraints();
		gbc_panelConsultarPedido.insets = new Insets(0, 0, 5, 5);
		gbc_panelConsultarPedido.fill = GridBagConstraints.BOTH;
		gbc_panelConsultarPedido.gridx = 1;
		gbc_panelConsultarPedido.gridy = 0;
		add(panelConsultarPedido, gbc_panelConsultarPedido);
		GridBagLayout gbl_panelConsultarPedido = new GridBagLayout();
		gbl_panelConsultarPedido.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelConsultarPedido.rowHeights = new int[]{6, 37, 26, 0, 0, 13, 0, 0};
		gbl_panelConsultarPedido.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelConsultarPedido.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panelConsultarPedido.setLayout(gbl_panelConsultarPedido);
		
		JLabel lblCrearPedido = new JLabel("Crear Pedido");
		lblCrearPedido.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblCrearPedido = new GridBagConstraints();
		gbc_lblCrearPedido.gridwidth = 5;
		gbc_lblCrearPedido.insets = new Insets(0, 0, 5, 0);
		gbc_lblCrearPedido.gridx = 0;
		gbc_lblCrearPedido.gridy = 1;
		panelConsultarPedido.add(lblCrearPedido, gbc_lblCrearPedido);
		
		JLabel lblN = new JLabel("n\u00BA");
		GridBagConstraints gbc_lblN = new GridBagConstraints();
		gbc_lblN.anchor = GridBagConstraints.EAST;
		gbc_lblN.insets = new Insets(0, 0, 5, 5);
		gbc_lblN.gridx = 0;
		gbc_lblN.gridy = 2;
		panelConsultarPedido.add(lblN, gbc_lblN);
		
		JTextField txtNumeroPedido = new JTextField();
		txtNumeroPedido.setEditable(false);
		GridBagConstraints gbc_txtNumeroPedido = new GridBagConstraints();
		gbc_txtNumeroPedido.insets = new Insets(0, 0, 5, 5);
		gbc_txtNumeroPedido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumeroPedido.gridx = 1;
		gbc_txtNumeroPedido.gridy = 2;
		panelConsultarPedido.add(txtNumeroPedido, gbc_txtNumeroPedido);
		txtNumeroPedido.setColumns(10);
		
		JLabel lblNombrecliente = new JLabel("Nombre Cliente");
		GridBagConstraints gbc_lblNombrecliente = new GridBagConstraints();
		gbc_lblNombrecliente.anchor = GridBagConstraints.EAST;
		gbc_lblNombrecliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombrecliente.gridx = 2;
		gbc_lblNombrecliente.gridy = 2;
		panelConsultarPedido.add(lblNombrecliente, gbc_lblNombrecliente);
		
		JTextField txtNombreCliente = new JTextField();
		GridBagConstraints gbc_txtNombreCliente = new GridBagConstraints();
		gbc_txtNombreCliente.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombreCliente.gridx = 3;
		gbc_txtNombreCliente.gridy = 2;
		panelConsultarPedido.add(txtNombreCliente, gbc_txtNombreCliente);
		txtNombreCliente.setColumns(10);
		
		JLabel label = new JLabel(" ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 3;
		panelConsultarPedido.add(label, gbc_label);
		
		btnAdd = new JButton("add");

		btnAdd.setToolTipText("a\u00F1adir articulo al pedido");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.fill = GridBagConstraints.BOTH;
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 4;
		panelConsultarPedido.add(btnAdd, gbc_btnAdd);
		
		btnCheck = new JButton("check");
		btnCheck.setToolTipText("checkear articulo del pedido");
		GridBagConstraints gbc_btnCheck = new GridBagConstraints();
		gbc_btnCheck.fill = GridBagConstraints.BOTH;
		gbc_btnCheck.insets = new Insets(0, 0, 5, 5);
		gbc_btnCheck.gridx = 3;
		gbc_btnCheck.gridy = 4;
		panelConsultarPedido.add(btnCheck, gbc_btnCheck);
		
		comboArticulos = new JComboBox();
		comboArticulos.setToolTipText("seleccion de articulos posibles");
		GridBagConstraints gbc_comboArticulos = new GridBagConstraints();
		gbc_comboArticulos.gridwidth = 3;
		gbc_comboArticulos.insets = new Insets(0, 0, 0, 5);
		gbc_comboArticulos.fill = GridBagConstraints.BOTH;
		gbc_comboArticulos.gridx = 1;
		gbc_comboArticulos.gridy = 6;
		panelConsultarPedido.add(comboArticulos, gbc_comboArticulos);

		JPanel panelCrearPedido = new JPanel();
		GridBagConstraints gbc_panelCrearPedido = new GridBagConstraints();
		gbc_panelCrearPedido.insets = new Insets(0, 0, 5, 5);
		gbc_panelCrearPedido.fill = GridBagConstraints.BOTH;
		gbc_panelCrearPedido.gridx = 2;
		gbc_panelCrearPedido.gridy = 0;
		add(panelCrearPedido, gbc_panelCrearPedido);
		GridBagLayout gbl_panelCrearPedido = new GridBagLayout();
		gbl_panelCrearPedido.columnWidths = new int[]{0, 0, 0, 91, 0, 0};
		gbl_panelCrearPedido.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelCrearPedido.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelCrearPedido.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCrearPedido.setLayout(gbl_panelCrearPedido);
		
		JLabel lblConsultarPedido = new JLabel("Consultar Pedido");
		lblConsultarPedido.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblConsultarPedido = new GridBagConstraints();
		gbc_lblConsultarPedido.insets = new Insets(0, 0, 5, 0);
		gbc_lblConsultarPedido.gridwidth = 5;
		gbc_lblConsultarPedido.gridx = 0;
		gbc_lblConsultarPedido.gridy = 1;
		panelCrearPedido.add(lblConsultarPedido, gbc_lblConsultarPedido);
		
		JLabel lblNombreCliente = new JLabel("Nombre Cliente");
		GridBagConstraints gbc_lblNombreCliente = new GridBagConstraints();
		gbc_lblNombreCliente.anchor = GridBagConstraints.EAST;
		gbc_lblNombreCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreCliente.gridx = 1;
		gbc_lblNombreCliente.gridy = 2;
		panelCrearPedido.add(lblNombreCliente, gbc_lblNombreCliente);
		
		JComboBox comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 2;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 2;
		panelCrearPedido.add(comboBox_1, gbc_comboBox_1);
		
		JLabel label_1 = new JLabel("n\u00BA");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 4;
		panelCrearPedido.add(label_1, gbc_label_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 4;
		panelCrearPedido.add(comboBox, gbc_comboBox);
		
		JButton btnVer = new JButton("VER");
		GridBagConstraints gbc_btnVer = new GridBagConstraints();
		gbc_btnVer.insets = new Insets(0, 0, 5, 5);
		gbc_btnVer.gridx = 2;
		gbc_btnVer.gridy = 5;
		panelCrearPedido.add(btnVer, gbc_btnVer);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 3;
		gbc_textField_1.insets = new Insets(0, 0, 0, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 6;
		panelCrearPedido.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

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
