package vista;


import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import modelo.Articulo;
import modelo.Cliente;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;


public class PanelPedido extends JPanel {
	private JTable tablePedido;
	public PanelPedido() {
		setForeground(Color.GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{80, 244, 12, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panelConsultarPedido = new JPanel();
		GridBagConstraints gbc_panelConsultarPedido = new GridBagConstraints();
		gbc_panelConsultarPedido.insets = new Insets(0, 0, 5, 5);
		gbc_panelConsultarPedido.fill = GridBagConstraints.BOTH;
		gbc_panelConsultarPedido.gridx = 1;
		gbc_panelConsultarPedido.gridy = 0;
		add(panelConsultarPedido, gbc_panelConsultarPedido);
		GridBagLayout gbl_panelConsultarPedido = new GridBagLayout();
		gbl_panelConsultarPedido.columnWidths = new int[]{0, 0, 0};
		gbl_panelConsultarPedido.rowHeights = new int[]{0, 0, 0};
		gbl_panelConsultarPedido.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelConsultarPedido.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelConsultarPedido.setLayout(gbl_panelConsultarPedido);
		
		JPanel panelCrearPedido = new JPanel();
		GridBagConstraints gbc_panelCrearPedido = new GridBagConstraints();
		gbc_panelCrearPedido.insets = new Insets(0, 0, 5, 5);
		gbc_panelCrearPedido.fill = GridBagConstraints.BOTH;
		gbc_panelCrearPedido.gridx = 2;
		gbc_panelCrearPedido.gridy = 0;
		add(panelCrearPedido, gbc_panelCrearPedido);

		
		JPanel panelTabla = new JPanel();
		GridBagConstraints gbc_panelTabla = new GridBagConstraints();
		gbc_panelTabla.gridwidth = 2;
		gbc_panelTabla.insets = new Insets(0, 0, 5, 5);
		gbc_panelTabla.fill = GridBagConstraints.BOTH;
		gbc_panelTabla.gridx = 1;
		gbc_panelTabla.gridy = 1;
		add(panelTabla, gbc_panelTabla);
		panelTabla.setLayout(new GridLayout(0, 1, 0, 0));
		PanelTabla panelTabla_1 = new PanelTabla();
		GridBagLayout gridBagLayout_1 = (GridBagLayout) panelTabla_1.getLayout();
		gridBagLayout_1.rowHeights = new int[]{79};
		panelTabla.add(panelTabla_1);
	}
	private Object[] introducirRejilla(Articulo item) {
		Object[] retorno= {item.getId(),item.getNombre(),item.getPrecio()};
		return retorno;
	}

}
