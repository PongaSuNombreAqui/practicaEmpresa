package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelArticulo extends JFrame {
	private JTextField textCrearID;
	private JTextField textCrearNombre;
	private JTextField textCrearPrecio;
	private JTextField textConsultarNombre;
	private JTextField textNuevoPrecio;

	public PanelArticulo() {

		JPanel panelArticulo = new JPanel();

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));

		JPanel panel_1 = new JPanel();
		GroupLayout gl_panelArticulo = new GroupLayout(panelArticulo);
		gl_panelArticulo.setHorizontalGroup(gl_panelArticulo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelArticulo.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE).addGap(18)));
		gl_panelArticulo.setVerticalGroup(gl_panelArticulo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelArticulo.createSequentialGroup().addGap(17)
						.addGroup(gl_panelArticulo.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
						.addContainerGap()));

		JPanel panelConsultar = new JPanel();
		panelConsultar.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));

		JPanel panelEditar = new JPanel();
		panelEditar.setBackground(Color.WHITE);
		panelEditar.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));

		JLabel lblListaDePrecios = new JLabel("Lista de Precios");
		lblListaDePrecios.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDePrecios.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblListaDePrecios.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.DARK_GRAY));

		JLabel lblNewLabel_3 = new JLabel("FECHA - PRECIO");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_2
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2.createSequentialGroup()
						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE).addContainerGap())
						.addGroup(Alignment.TRAILING,
								gl_panel_2
										.createSequentialGroup().addComponent(lblListaDePrecios,
												GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
										.addGap(56)))));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
						.addComponent(lblListaDePrecios, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
						.addContainerGap()));
		panel_2.setLayout(gl_panel_2);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panelConsultar, GroupLayout.PREFERRED_SIZE, 247, Short.MAX_VALUE)
						.addComponent(panelEditar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addComponent(panelConsultar, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panelEditar, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE));

		JLabel lblEditarArtculo = new JLabel("Editar Art\u00EDculo");
		lblEditarArtculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarArtculo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblEditarArtculo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.DARK_GRAY));

		JLabel lblNuevoPrecio = new JLabel("Nuevo Precio :");
		lblNuevoPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoPrecio.setFont(new Font("Segoe UI", Font.PLAIN, 13));

		textNuevoPrecio = new JTextField();
		textNuevoPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		textNuevoPrecio.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textNuevoPrecio.setColumns(10);
		textNuevoPrecio.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnEditar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		JLabel label_1 = new JLabel("Mensaje del sistema");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		GroupLayout gl_panelEditar = new GroupLayout(panelEditar);
		gl_panelEditar.setHorizontalGroup(gl_panelEditar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEditar.createSequentialGroup().addContainerGap(25, Short.MAX_VALUE)
						.addGroup(gl_panelEditar.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_panelEditar
										.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelEditar.createSequentialGroup().addComponent(lblNuevoPrecio)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textNuevoPrecio, GroupLayout.PREFERRED_SIZE, 119,
														GroupLayout.PREFERRED_SIZE)
												.addContainerGap())
										.addGroup(Alignment.TRAILING,
												gl_panelEditar.createSequentialGroup()
														.addComponent(lblEditarArtculo, GroupLayout.PREFERRED_SIZE, 166,
																GroupLayout.PREFERRED_SIZE)
														.addGap(37)))
								.addGroup(Alignment.TRAILING,
										gl_panelEditar.createSequentialGroup()
												.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 119,
														GroupLayout.PREFERRED_SIZE)
												.addContainerGap())
								.addGroup(Alignment.TRAILING,
										gl_panelEditar
												.createSequentialGroup().addComponent(label_1,
														GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
												.addContainerGap()))));
		gl_panelEditar.setVerticalGroup(gl_panelEditar.createParallelGroup(Alignment.LEADING).addGroup(gl_panelEditar
				.createSequentialGroup().addContainerGap()
				.addComponent(lblEditarArtculo, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addGroup(gl_panelEditar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNuevoPrecio, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(textNuevoPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelEditar.setLayout(gl_panelEditar);

		JLabel lblNewLabel_2 = new JLabel("Consultar Art\u00EDculo");
		lblNewLabel_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.DARK_GRAY));
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel label = new JLabel("Nombre :");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Segoe UI", Font.PLAIN, 13));

		textConsultarNombre = new JTextField();
		textConsultarNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textConsultarNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textConsultarNombre.setColumns(10);
		textConsultarNombre.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		JButton botonBuscar = new JButton("Buscar");
		botonBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		botonBuscar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		JLabel lblMensajeDelSistema = new JLabel("Mensaje del sistema");
		lblMensajeDelSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajeDelSistema.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		GroupLayout gl_panelConsultar = new GroupLayout(panelConsultar);
		gl_panelConsultar.setHorizontalGroup(gl_panelConsultar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelConsultar.createSequentialGroup().addGap(46)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panelConsultar.createParallelGroup(Alignment.LEADING, false)
								.addComponent(botonBuscar, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
								.addComponent(textConsultarNombre, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
								.addComponent(lblMensajeDelSistema, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addGap(21))
				.addGroup(
						gl_panelConsultar
								.createSequentialGroup().addGap(38).addComponent(lblNewLabel_2,
										GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(39)));
		gl_panelConsultar.setVerticalGroup(gl_panelConsultar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelConsultar.createSequentialGroup().addContainerGap().addComponent(lblNewLabel_2)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panelConsultar.createParallelGroup(Alignment.BASELINE)
								.addComponent(textConsultarNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(botonBuscar, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(lblMensajeDelSistema, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(17, Short.MAX_VALUE)));
		panelConsultar.setLayout(gl_panelConsultar);
		panel_1.setLayout(gl_panel_1);

		JLabel tituloCrear = new JLabel("Crear Art\u00EDculo");
		tituloCrear.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.DARK_GRAY));
		tituloCrear.setHorizontalAlignment(SwingConstants.CENTER);
		tituloCrear.setFont(new Font("Segoe UI", Font.PLAIN, 20));

		JLabel lblNewLabel = new JLabel("Nombre :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));

		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_1 = new JLabel("Precio :");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		JButton botonCrear = new JButton("Crear");
		botonCrear.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		botonCrear.setFont(new Font("Segoe UI", Font.PLAIN, 13));

		textCrearID = new JTextField();
		textCrearID.setHorizontalAlignment(SwingConstants.CENTER);
		textCrearID.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		textCrearID.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textCrearID.setColumns(10);

		textCrearNombre = new JTextField();
		textCrearNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textCrearNombre.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		textCrearNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textCrearNombre.setColumns(10);

		textCrearPrecio = new JTextField();
		textCrearPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		textCrearPrecio.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		textCrearPrecio.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textCrearPrecio.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup().addGap(41)
												.addComponent(tituloCrear, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGap(22))
										.addGroup(gl_panel.createSequentialGroup().addContainerGap()
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(lblNewLabel).addComponent(lblId))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(textCrearNombre, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textCrearID, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_panel.createSequentialGroup().addContainerGap()
												.addComponent(lblNewLabel_1).addGap(18)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
														.addComponent(botonCrear, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(textCrearPrecio))))
								.addGap(19)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap().addComponent(tituloCrear).addGap(18)
				.addGroup(gl_panel
						.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel).addComponent(textCrearNombre,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(28)
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addComponent(lblId).addComponent(textCrearID,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(39)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1).addComponent(
						textCrearPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(34).addComponent(botonCrear).addContainerGap(84, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		panelArticulo.setLayout(gl_panelArticulo);

	}
}
