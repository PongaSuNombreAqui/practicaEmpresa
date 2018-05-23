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
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class UI extends JFrame {

	private JPanel contentPane;
	protected JPanel panelMain;
	protected JPanel panelCliente;
	protected JPanel panelArticulo;
	protected JPanel panelPedido;
	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 474);
		
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
		
		panelMain = new JPanel();
		contentPane.add(panelMain, "panelMain");
		panelMain.setLayout(new GridLayout(1, 0, 0, 0));
		
		panelCliente = new JPanel();
		contentPane.add(panelCliente, "panelCliente");
		panelCliente.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelArticulo = new JPanel();
		contentPane.add(panelArticulo, "panelArticulo");
		panelArticulo.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelPedido = new JPanel();
		contentPane.add(panelPedido, "panelPedido");
		panelPedido.setLayout(new GridLayout(0, 1, 0, 0));
	}
	
	private void getPanel(String name) {
		((CardLayout) contentPane.getLayout()).show(contentPane, name);
	}
	
}
