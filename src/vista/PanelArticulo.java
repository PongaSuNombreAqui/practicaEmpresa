package vista;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Dimension;

public class PanelArticulo extends JPanel {

	private JPanel contentPane;
	private JTextField crearNombre;
	private JTextField crearID;
	private JTextField crearPrecio;
	private JTextField nombreConsultado;
	private JButton btnBuscar;
	private JButton btnCrear;
	private JLabel detallesNombre;
	private JLabel detallesID;
	private JLabel detallesPrecio;
	private JLabel detallesDescripcion;
	private int contador = 1;
	private JTextField crearDescripcion;
	private JPanel ventana;
	private JLabel mensajeCrear;
	private JLabel mensajeConsulta;

	public PanelArticulo() {
		setVisible(true);
		setBounds(100, 100, 800, 500);
		setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setMaximumSize(new Dimension(400, 500));
		panel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 95, 147, 76, 0 };
		gbl_panel_1.rowHeights = new int[] { 25, 20, 25, 18, 25, 25, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNewLabel = new JLabel("Crear Art\u00EDculo");
		lblNewLabel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(10, 0, 10, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

		crearNombre = new JTextField();
		crearNombre.setHorizontalAlignment(SwingConstants.CENTER);
		crearNombre.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		crearNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_crearNombre = new GridBagConstraints();
		gbc_crearNombre.insets = new Insets(10, 0, 10, 5);
		gbc_crearNombre.fill = GridBagConstraints.BOTH;
		gbc_crearNombre.gridx = 1;
		gbc_crearNombre.gridy = 1;
		panel_1.add(crearNombre, gbc_crearNombre);
		crearNombre.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("ID :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2.insets = new Insets(10, 0, 10, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

		crearID = new JTextField();
		crearID.setHorizontalAlignment(SwingConstants.CENTER);
		crearID.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		crearID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_crearID = new GridBagConstraints();
		gbc_crearID.insets = new Insets(10, 0, 10, 5);
		gbc_crearID.fill = GridBagConstraints.BOTH;
		gbc_crearID.gridx = 1;
		gbc_crearID.gridy = 2;
		panel_1.add(crearID, gbc_crearID);
		crearID.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Precio :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_3.insets = new Insets(10, 0, 10, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);

		crearPrecio = new JTextField();
		crearPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		crearPrecio.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		crearPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_crearPrecio = new GridBagConstraints();
		gbc_crearPrecio.insets = new Insets(10, 0, 10, 5);
		gbc_crearPrecio.fill = GridBagConstraints.BOTH;
		gbc_crearPrecio.gridx = 1;
		gbc_crearPrecio.gridy = 3;
		panel_1.add(crearPrecio, gbc_crearPrecio);
		crearPrecio.setColumns(10);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n :");
		lblDescripcin.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
		gbc_lblDescripcin.fill = GridBagConstraints.BOTH;
		gbc_lblDescripcin.insets = new Insets(10, 0, 10, 5);
		gbc_lblDescripcin.gridx = 0;
		gbc_lblDescripcin.gridy = 4;
		panel_1.add(lblDescripcin, gbc_lblDescripcin);

		crearDescripcion = new JTextField();
		crearDescripcion.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		crearDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		crearDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_crearDescripcion = new GridBagConstraints();
		gbc_crearDescripcion.insets = new Insets(10, 0, 10, 5);
		gbc_crearDescripcion.fill = GridBagConstraints.BOTH;
		gbc_crearDescripcion.gridx = 1;
		gbc_crearDescripcion.gridy = 4;
		panel_1.add(crearDescripcion, gbc_crearDescripcion);
		crearDescripcion.setColumns(10);

		btnCrear = new JButton("Crear");
		btnCrear.setBackground(Color.LIGHT_GRAY);
		btnCrear.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnCrear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnCrear = new GridBagConstraints();
		gbc_btnCrear.fill = GridBagConstraints.BOTH;
		gbc_btnCrear.insets = new Insets(10, 0, 10, 5);
		gbc_btnCrear.gridx = 1;
		gbc_btnCrear.gridy = 5;
		panel_1.add(btnCrear, gbc_btnCrear);

		mensajeCrear = new JLabel("");
		mensajeCrear.setForeground(Color.BLACK);
		mensajeCrear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mensajeCrear.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_mensajeCrear = new GridBagConstraints();
		gbc_mensajeCrear.fill = GridBagConstraints.BOTH;
		gbc_mensajeCrear.insets = new Insets(10, 0, 10, 0);
		gbc_mensajeCrear.gridx = 1;
		gbc_mensajeCrear.gridy = 6;
		panel_1.add(mensajeCrear, gbc_mensajeCrear);

		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(400, 500));
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 65, 157, 40, 0 };
		gbl_panel.rowHeights = new int[] { 25, 25, 25, 0, 25, 25, 25, 25, 25, 25, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel label = new JLabel("Consultar Art\u00EDculo");
		label.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);

		JLabel label_1 = new JLabel("Nombre :");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		panel.add(label_1, gbc_label_1);

		nombreConsultado = new JTextField();
		nombreConsultado.setHorizontalAlignment(SwingConstants.CENTER);
		nombreConsultado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nombreConsultado.setColumns(10);
		nombreConsultado.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GridBagConstraints gbc_textField_31 = new GridBagConstraints();
		gbc_textField_31.insets = new Insets(0, 0, 5, 5);
		gbc_textField_31.fill = GridBagConstraints.BOTH;
		gbc_textField_31.gridx = 1;
		gbc_textField_31.gridy = 1;
		panel.add(nombreConsultado, gbc_textField_31);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(Color.LIGHT_GRAY);

		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.fill = GridBagConstraints.BOTH;
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 1;
		gbc_btnBuscar.gridy = 2;
		panel.add(btnBuscar, gbc_btnBuscar);

		mensajeConsulta = new JLabel("");
		mensajeConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		mensajeConsulta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_mensajeConsulta = new GridBagConstraints();
		gbc_mensajeConsulta.fill = GridBagConstraints.BOTH;
		gbc_mensajeConsulta.insets = new Insets(0, 0, 5, 5);
		gbc_mensajeConsulta.gridx = 1;
		gbc_mensajeConsulta.gridy = 3;
		panel.add(mensajeConsulta, gbc_mensajeConsulta);

		JLabel lblDetallesartculo = new JLabel("Detalles Art\u00EDculo");
		lblDetallesartculo.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblDetallesartculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetallesartculo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblDetallesartculo = new GridBagConstraints();
		gbc_lblDetallesartculo.insets = new Insets(0, 0, 5, 5);
		gbc_lblDetallesartculo.gridx = 1;
		gbc_lblDetallesartculo.gridy = 4;
		panel.add(lblDetallesartculo, gbc_lblDetallesartculo);

		JLabel label_2 = new JLabel("Nombre :");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 5;
		panel.add(label_2, gbc_label_2);

		detallesNombre = new JLabel("");
		detallesNombre.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		detallesNombre.setHorizontalAlignment(SwingConstants.CENTER);
		detallesNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_detallesNombre = new GridBagConstraints();
		gbc_detallesNombre.fill = GridBagConstraints.BOTH;
		gbc_detallesNombre.insets = new Insets(10, 0, 10, 5);
		gbc_detallesNombre.gridx = 1;
		gbc_detallesNombre.gridy = 5;
		panel.add(detallesNombre, gbc_detallesNombre);

		JLabel label_3 = new JLabel("ID :");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 6;
		panel.add(label_3, gbc_label_3);

		detallesID = new JLabel("");
		detallesID.setHorizontalAlignment(SwingConstants.CENTER);
		detallesID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		detallesID.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GridBagConstraints gbc_detallesID = new GridBagConstraints();
		gbc_detallesID.fill = GridBagConstraints.BOTH;
		gbc_detallesID.insets = new Insets(10, 0, 10, 5);
		gbc_detallesID.gridx = 1;
		gbc_detallesID.gridy = 6;
		panel.add(detallesID, gbc_detallesID);

		JLabel label_4 = new JLabel("Precio :");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 7;
		panel.add(label_4, gbc_label_4);

		detallesPrecio = new JLabel("");
		detallesPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		detallesPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		detallesPrecio.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GridBagConstraints gbc_detallesPrecio = new GridBagConstraints();
		gbc_detallesPrecio.fill = GridBagConstraints.BOTH;
		gbc_detallesPrecio.insets = new Insets(10, 0, 10, 5);
		gbc_detallesPrecio.gridx = 1;
		gbc_detallesPrecio.gridy = 7;
		panel.add(detallesPrecio, gbc_detallesPrecio);

		JLabel lblDescripcion = new JLabel("Descripci\u00F3n :");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 8;
		panel.add(lblDescripcion, gbc_lblDescripcion);

		detallesDescripcion = new JLabel("");
		detallesDescripcion.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		detallesDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_detallesDescripcion = new GridBagConstraints();
		gbc_detallesDescripcion.fill = GridBagConstraints.BOTH;
		gbc_detallesDescripcion.gridheight = 2;
		gbc_detallesDescripcion.insets = new Insets(10, 0, 10, 5);
		gbc_detallesDescripcion.gridx = 1;
		gbc_detallesDescripcion.gridy = 8;
		panel.add(detallesDescripcion, gbc_detallesDescripcion);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
	}

	public void aniadir(JPanel ventanaEditar) {
		if (contador == 1) {
			setLayout(new GridLayout(0, 3, 0, 0));
			ventana = ventanaEditar;
			add(ventana, BorderLayout.EAST);
			contador--;
		}
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JTextField getTextField_3() {
		return nombreConsultado;
	}

	public JTextField getNombreConsultado() {
		return nombreConsultado;
	}

	public JLabel getDetallesNombre() {
		return detallesNombre;
	}

	public JLabel getDetallesID() {
		return detallesID;
	}

	public JLabel getDetallesPrecio() {
		return detallesPrecio;
	}

	public JLabel getDetallesDescripcion() {
		return detallesDescripcion;
	}

	public JButton getBtnCrear() {
		return btnCrear;
	}

	public JTextField getCrearNombre() {
		return crearNombre;
	}

	public JTextField getCrearID() {
		return crearID;
	}

	public JTextField getCrearPrecio() {
		return crearPrecio;
	}

	public JTextField getCrearDescripcion() {
		return crearDescripcion;
	}

	public JPanel getVentana() {
		return ventana;
	}

	public JLabel getMensajeCrear() {
		return mensajeCrear;
	}

	public JLabel getMensajeConsulta() {
		return mensajeConsulta;
	}

}
