package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class UI extends JFrame {

	private JPanel contentPane;
	protected JPanel panelGeneralMain;
	protected JPanel panelGeneralCliente;
	protected JPanel panelGeneralArticulo;
	protected JPanel panelGeneralPedido;

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 501);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenuItem menuMain = new JMenuItem("MAIN");
		menuMain.setHorizontalAlignment(SwingConstants.CENTER);
		menuMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getPanel("panelMain");
			}
		});
		menuBar.add(menuMain);

		JMenuItem menuCliente = new JMenuItem("CLIENTE");
		menuCliente.setHorizontalAlignment(SwingConstants.CENTER);
		menuCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getPanel("panelCliente");
			}
		});
		menuBar.add(menuCliente);

		JMenuItem menuArticulo = new JMenuItem("ARTICULO");
		menuArticulo.setHorizontalAlignment(SwingConstants.CENTER);
		menuArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getPanel("panelArticulo");
			}
		});
		menuBar.add(menuArticulo);

		JMenuItem menuPedido = new JMenuItem("PEDIDO");
		menuPedido.setHorizontalAlignment(SwingConstants.CENTER);
		menuPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getPanel("panelPedido");
			}
		});
		menuBar.add(menuPedido);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		contentPane.setLayout(new CardLayout(0, 0));

		panelGeneralMain = new JPanel();
		contentPane.add(panelGeneralMain, "panelMain");
		panelGeneralMain.setLayout(new GridLayout(1, 0, 0, 0));

		panelGeneralCliente = new JPanel();
		contentPane.add(panelGeneralCliente, "panelCliente");
		panelGeneralCliente.setLayout(new GridLayout(0, 1, 0, 0));

		panelGeneralArticulo = new JPanel();
		contentPane.add(panelGeneralArticulo, "panelArticulo");
		panelGeneralArticulo.setLayout(new GridLayout(1, 0, 0, 0));

		panelGeneralPedido = new JPanel();
		contentPane.add(panelGeneralPedido, "panelPedido");
		panelGeneralPedido.setLayout(new GridLayout(0, 1, 0, 0));
	}

	private void getPanel(String name) {
		((CardLayout) contentPane.getLayout()).show(contentPane, name);
	}

}
