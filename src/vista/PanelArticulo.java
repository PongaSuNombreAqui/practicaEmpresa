package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelArticulo extends JFrame {

	private JPanel contentPane;
	private JTextField textField_3;
	private JTextField precioNewArt;
	private JTextField idNewArt;
	private JTextField nombreNewArt;
	private JTextField textField;

	public PanelArticulo() {

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout(0, 0));

		JPanel panelC = new JPanel();
		panelC.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		panelPrincipal.add(panelC, BorderLayout.CENTER);
		panelC.setLayout(new BorderLayout(0, 0));

		JPanel panelConsultar = new JPanel();
		panelConsultar.setBorder(new MatteBorder(1, 1, 3, 1, (Color) new Color(0, 0, 0)));
		panelC.add(panelConsultar, BorderLayout.NORTH);
		panelConsultar.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panelConsultar.add(panel, BorderLayout.CENTER);

		JLabel lblN = new JLabel("Nombre del Articulo :");
		lblN.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblN.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblN);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField_3);
		textField_3.setColumns(10);

		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		panel.add(btnNewButton);

		JLabel lblNewLabel_7 = new JLabel("Mensaje del Sistema");
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panelConsultar.add(lblNewLabel_7, BorderLayout.SOUTH);

		JLabel lblNewLabel = new JLabel("Consultar Art\u00EDculo");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		panelConsultar.add(lblNewLabel, BorderLayout.NORTH);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_1 = new JPanel();
		panelC.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);

		JLabel lblEditarArticulo = new JLabel("Editar Art\u00EDculo");
		lblEditarArticulo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblEditarArticulo.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_6 = new JLabel("Lista de Precios");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.PLAIN, 20));

		JLabel lblNuevoPrecio = new JLabel("Nuevo Precio :");
		lblNuevoPrecio.setFont(new Font("Segoe UI", Font.PLAIN, 13));

		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);

		JLabel listaPrecios = new JLabel("Lista de precios con sus fechas");
		listaPrecios.setFont(new Font("Segoe UI", Font.PLAIN, 13));

		JButton confirmar = new JButton("Confirmar");
		confirmar.setFont(new Font("Segoe UI", Font.PLAIN, 13));

		JLabel mensajeConfirmar = new JLabel("Mensaje del Sistema");
		mensajeConfirmar.setHorizontalAlignment(SwingConstants.LEFT);
		mensajeConfirmar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(75)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNuevoPrecio, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
										.addComponent(mensajeConfirmar, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
									.addGap(18))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(lblEditarArticulo)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(listaPrecios, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
								.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(confirmar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(25, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEditarArticulo)
						.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNuevoPrecio, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
							.addGap(3)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(confirmar)
							.addGap(11))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(27)
							.addComponent(listaPrecios)
							.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(mensajeConfirmar, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
					.addGap(55))
		);
		panel_2.setLayout(gl_panel_2);

		JPanel panelCreacion = new JPanel();
		panelCreacion.setBorder(new MatteBorder(3, 3, 3, 0, (Color) new Color(0, 0, 0)));
		panelPrincipal.add(panelCreacion, BorderLayout.WEST);
		GridBagLayout gbl_panelCreacion = new GridBagLayout();
		gbl_panelCreacion.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelCreacion.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelCreacion.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelCreacion.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		panelCreacion.setLayout(gbl_panelCreacion);

		JLabel lblNewLabel_3 = new JLabel("Crear Art\u00EDculo");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 1;
		panelCreacion.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Nombre :");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 3;
		panelCreacion.add(lblNewLabel_4, gbc_lblNewLabel_4);

		nombreNewArt = new JTextField();
		nombreNewArt.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		GridBagConstraints gbc_nombreNewArt = new GridBagConstraints();
		gbc_nombreNewArt.insets = new Insets(0, 0, 5, 5);
		gbc_nombreNewArt.fill = GridBagConstraints.HORIZONTAL;
		gbc_nombreNewArt.gridx = 2;
		gbc_nombreNewArt.gridy = 3;
		panelCreacion.add(nombreNewArt, gbc_nombreNewArt);
		nombreNewArt.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("ID :");
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 5;
		panelCreacion.add(lblNewLabel_5, gbc_lblNewLabel_5);

		idNewArt = new JTextField();
		idNewArt.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		GridBagConstraints gbc_idNewArt = new GridBagConstraints();
		gbc_idNewArt.insets = new Insets(0, 0, 5, 5);
		gbc_idNewArt.fill = GridBagConstraints.HORIZONTAL;
		gbc_idNewArt.gridx = 2;
		gbc_idNewArt.gridy = 5;
		panelCreacion.add(idNewArt, gbc_idNewArt);
		idNewArt.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Precio :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 7;
		panelCreacion.add(lblNewLabel_2, gbc_lblNewLabel_2);

		precioNewArt = new JTextField();
		precioNewArt.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		GridBagConstraints gbc_precioNewArt = new GridBagConstraints();
		gbc_precioNewArt.insets = new Insets(0, 0, 5, 5);
		gbc_precioNewArt.fill = GridBagConstraints.HORIZONTAL;
		gbc_precioNewArt.gridx = 2;
		gbc_precioNewArt.gridy = 7;
		panelCreacion.add(precioNewArt, gbc_precioNewArt);
		precioNewArt.setColumns(10);

		JButton btnNewButton_1 = new JButton("Crear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 9;
		panelCreacion.add(btnNewButton_1, gbc_btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("Mensaje del Sistema");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1.gridheight = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 10;
		panelCreacion.add(lblNewLabel_1, gbc_lblNewLabel_1);

	}
}
