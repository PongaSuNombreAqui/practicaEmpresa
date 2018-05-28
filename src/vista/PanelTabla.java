package vista;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Articulo;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JLabel;

public class PanelTabla extends JPanel {

	private JTable tabla;
	private JScrollPane scrollPane;

	public JTable getTabla() {
		return tabla;
	}

	public PanelTabla() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 390, 0 };
		gridBagLayout.rowHeights = new int[] { 342, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		tabla = new JTable(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nombre", "Precio", "Cantidad", "Precio Total" }) {
			Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Integer.class, Float.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, true, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		scrollPane = new JScrollPane(tabla);
		add(scrollPane, gbc_scrollPane);


	}

}
