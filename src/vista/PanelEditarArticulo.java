package vista;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

public class PanelEditarArticulo extends JPanel {

	private JTextField nuevoPrecio;
	private JButton btnEditar;
	private JTextField txtFecha;
	private JLabel lblPrecio;
	private JButton btnBuscar;

	public PanelEditarArticulo() {
		setBounds(0, 0, 400, 300);
		setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 100, 100, 100, 100, 0 };
		gridBagLayout.rowHeights = new int[] { 25, 0, 21, 23, 25, 25, 25, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewLabel_3 = new JLabel("Antiguos Precios");
		lblNewLabel_3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_3.gridwidth = 2;
		gbc_lblNewLabel_3.insets = new Insets(10, 0, 10, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 0;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha a comprobar");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 1;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtFecha = new JTextField();
		txtFecha.setText("a\u00F1o-mes-dia");
		GridBagConstraints gbc_txtFecha = new GridBagConstraints();
		gbc_txtFecha.insets = new Insets(0, 0, 5, 5);
		gbc_txtFecha.fill = GridBagConstraints.BOTH;
		gbc_txtFecha.gridx = 2;
		gbc_txtFecha.gridy = 1;
		add(txtFecha, gbc_txtFecha);
		txtFecha.setColumns(10);
		
		btnBuscar = new JButton("BuscarPrecio");
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.fill = GridBagConstraints.BOTH;
		gbc_btnBuscar.gridwidth = 2;
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 1;
		gbc_btnBuscar.gridy = 2;
		add(btnBuscar, gbc_btnBuscar);

		lblPrecio = new JLabel("New label");
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.gridwidth = 4;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 0);
		gbc_lblPrecio.gridx = 0;
		gbc_lblPrecio.gridy = 3;
		add(lblPrecio, gbc_lblPrecio);

		JLabel lblEditar = new JLabel("Editar");
		lblEditar.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblEditar = new GridBagConstraints();
		gbc_lblEditar.gridwidth = 2;
		gbc_lblEditar.insets = new Insets(10, 0, 10, 5);
		gbc_lblEditar.gridx = 1;
		gbc_lblEditar.gridy = 4;
		add(lblEditar, gbc_lblEditar);

		JLabel lblNewLabel = new JLabel("Nuevo Precio :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(10, 0, 10, 10);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 5;
		add(lblNewLabel, gbc_lblNewLabel);

		nuevoPrecio = new JTextField();
		nuevoPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		nuevoPrecio.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		nuevoPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_nuevoPrecio = new GridBagConstraints();
		gbc_nuevoPrecio.insets = new Insets(10, 0, 10, 5);
		gbc_nuevoPrecio.fill = GridBagConstraints.BOTH;
		gbc_nuevoPrecio.gridx = 2;
		gbc_nuevoPrecio.gridy = 5;
		add(nuevoPrecio, gbc_nuevoPrecio);
		nuevoPrecio.setColumns(10);

		btnEditar = new JButton("Editar");
		btnEditar.setName("botonEditar");
		btnEditar.setBackground(Color.LIGHT_GRAY);
		btnEditar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.fill = GridBagConstraints.BOTH;
		gbc_btnEditar.gridwidth = 2;
		gbc_btnEditar.insets = new Insets(10, 0, 10, 5);
		gbc_btnEditar.gridx = 1;
		gbc_btnEditar.gridy = 6;
		add(btnEditar, gbc_btnEditar);

	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JTextField getTxtFecha() {
		return txtFecha;
	}

	public JLabel getLblPrecio() {
		return lblPrecio;
	}

	public JTextField getNuevoPrecio() {
		return nuevoPrecio;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

}
