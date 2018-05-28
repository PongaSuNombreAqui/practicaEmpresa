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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class PanelArticulo extends JPanel {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private int contador = 1;

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
		gbl_panel_1.rowHeights = new int[] { 25, 20, 25, 18, 25, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
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
		gbc_lblNewLabel_1.insets = new Insets(10, 0, 10, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(10, 0, 10, 0);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("ID :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2.insets = new Insets(10, 0, 10, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(10, 0, 10, 0);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		panel_1.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Precio :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_3.insets = new Insets(10, 0, 10, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);

		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(10, 0, 10, 0);
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 3;
		panel_1.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton = new JButton("Crear");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(10, 0, 10, 0);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 4;
		panel_1.add(btnNewButton, gbc_btnNewButton);

		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(400, 500));
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 65, 157, 40, 0 };
		gbl_panel.rowHeights = new int[] { 25, 25, 25, 25, 25, 25, 25, 25, 25, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
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
		
				textField_3 = new JTextField();
				textField_3.setHorizontalAlignment(SwingConstants.CENTER);
				textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textField_3.setColumns(10);
				textField_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				GridBagConstraints gbc_textField_3 = new GridBagConstraints();
				gbc_textField_3.insets = new Insets(0, 0, 5, 5);
				gbc_textField_3.fill = GridBagConstraints.BOTH;
				gbc_textField_3.gridx = 1;
				gbc_textField_3.gridy = 1;
				panel.add(textField_3, gbc_textField_3);
				
						JButton btnBuscar = new JButton("Buscar");
						btnBuscar.setBackground(Color.LIGHT_GRAY);
						btnBuscar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								añadir();
								contentPane.updateUI();
								revalidate();
							}

						});
						btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
						btnBuscar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
						GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
						gbc_btnBuscar.fill = GridBagConstraints.BOTH;
						gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
						gbc_btnBuscar.gridx = 1;
						gbc_btnBuscar.gridy = 2;
						panel.add(btnBuscar, gbc_btnBuscar);
						
								JLabel lblDetallesartculo = new JLabel("Detalles Art\u00EDculo");
								lblDetallesartculo.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
								lblDetallesartculo.setHorizontalAlignment(SwingConstants.CENTER);
								lblDetallesartculo.setFont(new Font("Tahoma", Font.PLAIN, 20));
								GridBagConstraints gbc_lblDetallesartculo = new GridBagConstraints();
								gbc_lblDetallesartculo.insets = new Insets(0, 0, 5, 5);
								gbc_lblDetallesartculo.gridx = 1;
								gbc_lblDetallesartculo.gridy = 3;
								panel.add(lblDetallesartculo, gbc_lblDetallesartculo);
								
										JLabel label_2 = new JLabel("Nombre :");
										label_2.setHorizontalAlignment(SwingConstants.CENTER);
										label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
										GridBagConstraints gbc_label_2 = new GridBagConstraints();
										gbc_label_2.insets = new Insets(0, 0, 5, 5);
										gbc_label_2.gridx = 0;
										gbc_label_2.gridy = 4;
										panel.add(label_2, gbc_label_2);
						
								JLabel label_5 = new JLabel("");
								label_5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
								label_5.setHorizontalAlignment(SwingConstants.CENTER);
								label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
								GridBagConstraints gbc_label_5 = new GridBagConstraints();
								gbc_label_5.fill = GridBagConstraints.BOTH;
								gbc_label_5.insets = new Insets(10, 0, 10, 0);
								gbc_label_5.gridx = 1;
								gbc_label_5.gridy = 4;
								panel.add(label_5, gbc_label_5);
								
										JLabel label_3 = new JLabel("ID :");
										label_3.setHorizontalAlignment(SwingConstants.CENTER);
										label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
										GridBagConstraints gbc_label_3 = new GridBagConstraints();
										gbc_label_3.insets = new Insets(0, 0, 5, 5);
										gbc_label_3.gridx = 0;
										gbc_label_3.gridy = 5;
										panel.add(label_3, gbc_label_3);
								
										JLabel label_6 = new JLabel("");
										label_6.setHorizontalAlignment(SwingConstants.CENTER);
										label_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
										label_6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
										GridBagConstraints gbc_label_6 = new GridBagConstraints();
										gbc_label_6.fill = GridBagConstraints.BOTH;
										gbc_label_6.insets = new Insets(10, 0, 10, 0);
										gbc_label_6.gridx = 1;
										gbc_label_6.gridy = 5;
										panel.add(label_6, gbc_label_6);
								
										JLabel label_4 = new JLabel("Precio :");
										label_4.setHorizontalAlignment(SwingConstants.CENTER);
										label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
										GridBagConstraints gbc_label_4 = new GridBagConstraints();
										gbc_label_4.insets = new Insets(0, 0, 5, 5);
										gbc_label_4.gridx = 0;
										gbc_label_4.gridy = 6;
										panel.add(label_4, gbc_label_4);
				
						JLabel label_7 = new JLabel("");
						label_7.setHorizontalAlignment(SwingConstants.CENTER);
						label_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
						label_7.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
						GridBagConstraints gbc_label_7 = new GridBagConstraints();
						gbc_label_7.fill = GridBagConstraints.BOTH;
						gbc_label_7.insets = new Insets(10, 0, 10, 0);
						gbc_label_7.gridx = 1;
						gbc_label_7.gridy = 6;
						panel.add(label_7, gbc_label_7);
				
				JLabel lblDescripcion = new JLabel("Descripci\u00F3n :");
				lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 15));
				GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
				gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
				gbc_lblDescripcion.gridx = 0;
				gbc_lblDescripcion.gridy = 7;
				panel.add(lblDescripcion, gbc_lblDescripcion);
				
				JLabel lblNewLabel_4 = new JLabel("");
				lblNewLabel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
				GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
				gbc_lblNewLabel_4.fill = GridBagConstraints.BOTH;
				gbc_lblNewLabel_4.gridheight = 2;
				gbc_lblNewLabel_4.insets = new Insets(10, 0, 10, 0);
				gbc_lblNewLabel_4.gridx = 1;
				gbc_lblNewLabel_4.gridy = 7;
				panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
	}

	private void añadir() {
		if (contador == 1) {
			setLayout(new GridLayout(0, 3, 0, 0));
			JPanel ventana = new VentanaEditar();
			add(ventana, BorderLayout.EAST);
			contador--;
		}
	}
}
