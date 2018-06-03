package vista;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class PanelCliente extends JPanel {
	private JTextField txtRazonSocial;
	private JTextField txtDnicif;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtClienteConsulta;
	private JTextField txtDnicifResultado;
	private JTextField txtRazonSocialResultado;
	private JTextField txtDireccionResultado;
	private JTextField txtTelefonoResultado;
	private JComboBox comboBox;
	private JButton btnBuscar;
	private JButton btnEliminarCliente;
	private JButton btnAgregar;
	private JLabel lblMensaje;

	public PanelCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 11, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panelAgregarCliente = new JPanel();
		panelAgregarCliente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_panelAgregarCliente = new GridBagConstraints();
		gbc_panelAgregarCliente.insets = new Insets(0, 0, 5, 6);
		gbc_panelAgregarCliente.fill = GridBagConstraints.BOTH;
		gbc_panelAgregarCliente.gridx = 0;
		gbc_panelAgregarCliente.gridy = 0;
		add(panelAgregarCliente, gbc_panelAgregarCliente);
		GridBagLayout gbl_panelAgregarCliente = new GridBagLayout();
		gbl_panelAgregarCliente.columnWidths = new int[] { 0, 0, 0 };
		gbl_panelAgregarCliente.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelAgregarCliente.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelAgregarCliente.rowWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		panelAgregarCliente.setLayout(gbl_panelAgregarCliente);

		JLabel lblAgregarCliente = new JLabel("Agregar cliente");
		lblAgregarCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblAgregarCliente = new GridBagConstraints();
		gbc_lblAgregarCliente.gridwidth = 2;
		gbc_lblAgregarCliente.insets = new Insets(5, 0, 5, 0);
		gbc_lblAgregarCliente.gridx = 0;
		gbc_lblAgregarCliente.gridy = 0;
		panelAgregarCliente.add(lblAgregarCliente, gbc_lblAgregarCliente);

		JLabel lblDatosDelCliente = new JLabel("Datos del cliente:");
		lblDatosDelCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDatosDelCliente = new GridBagConstraints();
		gbc_lblDatosDelCliente.gridwidth = 2;
		gbc_lblDatosDelCliente.anchor = GridBagConstraints.WEST;
		gbc_lblDatosDelCliente.insets = new Insets(0, 5, 5, 5);
		gbc_lblDatosDelCliente.gridx = 0;
		gbc_lblDatosDelCliente.gridy = 1;
		panelAgregarCliente.add(lblDatosDelCliente, gbc_lblDatosDelCliente);

		JLabel lblDnicif = new JLabel("DNI/CIF:");
		lblDnicif.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDnicif = new GridBagConstraints();
		gbc_lblDnicif.anchor = GridBagConstraints.WEST;
		gbc_lblDnicif.insets = new Insets(0, 5, 5, 5);
		gbc_lblDnicif.gridx = 0;
		gbc_lblDnicif.gridy = 2;
		panelAgregarCliente.add(lblDnicif, gbc_lblDnicif);

		txtDnicif = new JTextField();
		txtDnicif.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_txtDnicif = new GridBagConstraints();
		gbc_txtDnicif.insets = new Insets(0, 0, 5, 5);
		gbc_txtDnicif.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDnicif.gridx = 1;
		gbc_txtDnicif.gridy = 2;
		panelAgregarCliente.add(txtDnicif, gbc_txtDnicif);
		txtDnicif.setColumns(10);

		JLabel lblRazonSocial = new JLabel("Raz\u00F3n Social:");
		lblRazonSocial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblRazonSocial = new GridBagConstraints();
		gbc_lblRazonSocial.anchor = GridBagConstraints.WEST;
		gbc_lblRazonSocial.insets = new Insets(0, 5, 5, 5);
		gbc_lblRazonSocial.gridx = 0;
		gbc_lblRazonSocial.gridy = 3;
		panelAgregarCliente.add(lblRazonSocial, gbc_lblRazonSocial);

		txtRazonSocial = new JTextField();
		txtRazonSocial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_txtRazonSocial = new GridBagConstraints();
		gbc_txtRazonSocial.insets = new Insets(0, 0, 5, 5);
		gbc_txtRazonSocial.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRazonSocial.gridx = 1;
		gbc_txtRazonSocial.gridy = 3;
		panelAgregarCliente.add(txtRazonSocial, gbc_txtRazonSocial);
		txtRazonSocial.setColumns(10);

		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.anchor = GridBagConstraints.WEST;
		gbc_lblDireccion.insets = new Insets(0, 5, 5, 5);
		gbc_lblDireccion.gridx = 0;
		gbc_lblDireccion.gridy = 4;
		panelAgregarCliente.add(lblDireccion, gbc_lblDireccion);

		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_txtDireccion = new GridBagConstraints();
		gbc_txtDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_txtDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDireccion.gridx = 1;
		gbc_txtDireccion.gridy = 4;
		panelAgregarCliente.add(txtDireccion, gbc_txtDireccion);
		txtDireccion.setColumns(10);

		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.WEST;
		gbc_lblTelefono.insets = new Insets(0, 5, 5, 5);
		gbc_lblTelefono.gridx = 0;
		gbc_lblTelefono.gridy = 5;
		panelAgregarCliente.add(lblTelefono, gbc_lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_txtTelefono = new GridBagConstraints();
		gbc_txtTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefono.gridx = 1;
		gbc_txtTelefono.gridy = 5;
		panelAgregarCliente.add(txtTelefono, gbc_txtTelefono);
		txtTelefono.setColumns(10);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.insets = new Insets(0, 0, 5, 0);
		gbc_btnAgregar.gridwidth = 2;
		gbc_btnAgregar.gridx = 0;
		gbc_btnAgregar.gridy = 6;
		panelAgregarCliente.add(btnAgregar, gbc_btnAgregar);

		JPanel panelConsultarCliente = new JPanel();
		panelConsultarCliente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_panelConsultarCliente = new GridBagConstraints();
		gbc_panelConsultarCliente.insets = new Insets(0, 0, 5, 0);
		gbc_panelConsultarCliente.fill = GridBagConstraints.BOTH;
		gbc_panelConsultarCliente.gridx = 1;
		gbc_panelConsultarCliente.gridy = 0;
		add(panelConsultarCliente, gbc_panelConsultarCliente);
		GridBagLayout gbl_panelConsultarCliente = new GridBagLayout();
		gbl_panelConsultarCliente.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panelConsultarCliente.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panelConsultarCliente.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelConsultarCliente.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panelConsultarCliente.setLayout(gbl_panelConsultarCliente);

		JLabel lblConsultarCliente = new JLabel("Consultar cliente");
		lblConsultarCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblConsultarCliente = new GridBagConstraints();
		gbc_lblConsultarCliente.gridwidth = 3;
		gbc_lblConsultarCliente.insets = new Insets(0, 0, 5, 0);
		gbc_lblConsultarCliente.gridx = 0;
		gbc_lblConsultarCliente.gridy = 0;
		panelConsultarCliente.add(lblConsultarCliente, gbc_lblConsultarCliente);

		JLabel lblClienteConsulta = new JLabel("Cliente:");
		lblClienteConsulta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblClienteConsulta = new GridBagConstraints();
		gbc_lblClienteConsulta.insets = new Insets(0, 5, 5, 5);
		gbc_lblClienteConsulta.anchor = GridBagConstraints.EAST;
		gbc_lblClienteConsulta.gridx = 0;
		gbc_lblClienteConsulta.gridy = 1;
		panelConsultarCliente.add(lblClienteConsulta, gbc_lblClienteConsulta);

		txtClienteConsulta = new JTextField();
		txtClienteConsulta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_txtClienteConsulta = new GridBagConstraints();
		gbc_txtClienteConsulta.insets = new Insets(0, 0, 5, 5);
		gbc_txtClienteConsulta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtClienteConsulta.gridx = 1;
		gbc_txtClienteConsulta.gridy = 1;
		panelConsultarCliente.add(txtClienteConsulta, gbc_txtClienteConsulta);
		txtClienteConsulta.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 2;
		gbc_btnBuscar.gridy = 1;
		panelConsultarCliente.add(btnBuscar, gbc_btnBuscar);

		JPanel panelResultado = new JPanel();
		panelResultado.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_panelResultado = new GridBagConstraints();
		gbc_panelResultado.gridwidth = 3;
		gbc_panelResultado.insets = new Insets(0, 5, 5, 0);
		gbc_panelResultado.fill = GridBagConstraints.BOTH;
		gbc_panelResultado.gridx = 0;
		gbc_panelResultado.gridy = 2;
		panelConsultarCliente.add(panelResultado, gbc_panelResultado);
		GridBagLayout gbl_panelResultado = new GridBagLayout();
		gbl_panelResultado.columnWidths = new int[] { 0, 0, 0 };
		gbl_panelResultado.rowHeights = new int[] { 0, 0, 0, 0, 21, 0, 0 };
		gbl_panelResultado.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelResultado.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		panelResultado.setLayout(gbl_panelResultado);

		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 5, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 0;
		panelResultado.add(comboBox, gbc_comboBox);

		JLabel lblDnicifResultado = new JLabel("DNI/CIF:");
		lblDnicifResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDnicifResultado = new GridBagConstraints();
		gbc_lblDnicifResultado.anchor = GridBagConstraints.WEST;
		gbc_lblDnicifResultado.insets = new Insets(0, 5, 5, 5);
		gbc_lblDnicifResultado.gridx = 0;
		gbc_lblDnicifResultado.gridy = 1;
		panelResultado.add(lblDnicifResultado, gbc_lblDnicifResultado);

		txtDnicifResultado = new JTextField();
		txtDnicifResultado.setEditable(false);
		txtDnicifResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_txtDnicifResultado = new GridBagConstraints();
		gbc_txtDnicifResultado.insets = new Insets(0, 0, 5, 5);
		gbc_txtDnicifResultado.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDnicifResultado.gridx = 1;
		gbc_txtDnicifResultado.gridy = 1;
		panelResultado.add(txtDnicifResultado, gbc_txtDnicifResultado);
		txtDnicifResultado.setColumns(10);

		JLabel lblRazonSocialResultado = new JLabel("Raz\u00F3n Social:");
		lblRazonSocialResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblRazonSocialResultado = new GridBagConstraints();
		gbc_lblRazonSocialResultado.anchor = GridBagConstraints.WEST;
		gbc_lblRazonSocialResultado.insets = new Insets(0, 5, 5, 5);
		gbc_lblRazonSocialResultado.gridx = 0;
		gbc_lblRazonSocialResultado.gridy = 2;
		panelResultado.add(lblRazonSocialResultado, gbc_lblRazonSocialResultado);

		txtRazonSocialResultado = new JTextField();
		txtRazonSocialResultado.setEditable(false);
		txtRazonSocialResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_txtRazonSocialResultado = new GridBagConstraints();
		gbc_txtRazonSocialResultado.insets = new Insets(0, 0, 5, 5);
		gbc_txtRazonSocialResultado.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRazonSocialResultado.gridx = 1;
		gbc_txtRazonSocialResultado.gridy = 2;
		panelResultado.add(txtRazonSocialResultado, gbc_txtRazonSocialResultado);
		txtRazonSocialResultado.setColumns(10);

		JLabel lblDireccionResultado = new JLabel("Direcci\u00F3n:");
		lblDireccionResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDireccionResultado = new GridBagConstraints();
		gbc_lblDireccionResultado.anchor = GridBagConstraints.WEST;
		gbc_lblDireccionResultado.insets = new Insets(0, 5, 5, 5);
		gbc_lblDireccionResultado.gridx = 0;
		gbc_lblDireccionResultado.gridy = 3;
		panelResultado.add(lblDireccionResultado, gbc_lblDireccionResultado);

		txtDireccionResultado = new JTextField();
		txtDireccionResultado.setEditable(false);
		txtDireccionResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDireccionResultado.setText("");
		GridBagConstraints gbc_txtDireccionResultado = new GridBagConstraints();
		gbc_txtDireccionResultado.insets = new Insets(0, 0, 5, 5);
		gbc_txtDireccionResultado.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDireccionResultado.gridx = 1;
		gbc_txtDireccionResultado.gridy = 3;
		panelResultado.add(txtDireccionResultado, gbc_txtDireccionResultado);
		txtDireccionResultado.setColumns(10);

		JLabel lblTelefonoResultado = new JLabel("Tel\u00E9fono:");
		lblTelefonoResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblTelefonoResultado = new GridBagConstraints();
		gbc_lblTelefonoResultado.anchor = GridBagConstraints.WEST;
		gbc_lblTelefonoResultado.insets = new Insets(0, 5, 5, 5);
		gbc_lblTelefonoResultado.gridx = 0;
		gbc_lblTelefonoResultado.gridy = 4;
		panelResultado.add(lblTelefonoResultado, gbc_lblTelefonoResultado);

		txtTelefonoResultado = new JTextField();
		txtTelefonoResultado.setEditable(false);
		txtTelefonoResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_txtTelefonoResultado = new GridBagConstraints();
		gbc_txtTelefonoResultado.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefonoResultado.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefonoResultado.gridx = 1;
		gbc_txtTelefonoResultado.gridy = 4;
		panelResultado.add(txtTelefonoResultado, gbc_txtTelefonoResultado);
		txtTelefonoResultado.setColumns(10);

		btnEliminarCliente = new JButton("Eliminar cliente");
		btnEliminarCliente.setEnabled(false);
		btnEliminarCliente.setForeground(Color.RED);
		btnEliminarCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_btnEliminarCliente = new GridBagConstraints();
		gbc_btnEliminarCliente.gridwidth = 2;
		gbc_btnEliminarCliente.insets = new Insets(0, 0, 0, 5);
		gbc_btnEliminarCliente.gridx = 0;
		gbc_btnEliminarCliente.gridy = 5;
		panelResultado.add(btnEliminarCliente, gbc_btnEliminarCliente);

		JPanel panelMensaje = new JPanel();
		GridBagConstraints gbc_panelMensaje = new GridBagConstraints();
		gbc_panelMensaje.gridwidth = 2;
		gbc_panelMensaje.insets = new Insets(0, 0, 0, 5);
		gbc_panelMensaje.fill = GridBagConstraints.BOTH;
		gbc_panelMensaje.gridx = 0;
		gbc_panelMensaje.gridy = 1;
		add(panelMensaje, gbc_panelMensaje);
		GridBagLayout gbl_panelMensaje = new GridBagLayout();
		gbl_panelMensaje.columnWidths = new int[] { 54, 0 };
		gbl_panelMensaje.rowHeights = new int[] { 17, 0, 0 };
		gbl_panelMensaje.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panelMensaje.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		panelMensaje.setLayout(gbl_panelMensaje);

		lblMensaje = new JLabel(" ");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblMensaje = new GridBagConstraints();
		gbc_lblMensaje.insets = new Insets(0, 5, 5, 5);
		gbc_lblMensaje.anchor = GridBagConstraints.WEST;
		gbc_lblMensaje.gridx = 0;
		gbc_lblMensaje.gridy = 0;
		panelMensaje.add(lblMensaje, gbc_lblMensaje);
	}

	public JTextField getTxtRazonSocial() {
		return txtRazonSocial;
	}

	public JTextField getTxtDnicif() {
		return txtDnicif;
	}

	public JTextField getTxtDireccion() {
		return txtDireccion;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public JTextField getTxtClienteConsulta() {
		return txtClienteConsulta;
	}

	public JTextField getTxtDnicifResultado() {
		return txtDnicifResultado;
	}

	public JTextField getTxtRazonSocialResultado() {
		return txtRazonSocialResultado;
	}

	public JTextField getTxtDireccionResultado() {
		return txtDireccionResultado;
	}

	public JTextField getTxtTelefonoResultado() {
		return txtTelefonoResultado;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JButton getBtnEliminarCliente() {
		return btnEliminarCliente;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JLabel getLblMensaje() {
		return lblMensaje;
	}

}
