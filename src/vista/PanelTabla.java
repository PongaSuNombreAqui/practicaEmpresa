package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import modelo.Articulo;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JTextField;

public class PanelTabla extends JPanel {

	private String [] nombresColumnas={"ID","Nombre","Precio"};
	
	private Object[][] data={
			{1,"ajo",55f},
			{1,"pan",32f}
	};
	
	Object[] lineaVacia={0,"",0f};
	
	public PanelTabla() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{390, 30, 0};
		gridBagLayout.rowHeights = new int[]{342, 0, 342, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		JTable tabla = new JTable(new DefaultTableModel(data,nombresColumnas));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridheight = 3;
		gbc.insets = new Insets(0, 0, 0, 5);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		JScrollPane scrollPane = new JScrollPane(tabla);
		add(scrollPane, gbc);
		
		Articulo item = new Articulo(1, "as", 32f); 
		
		JButton btnAdd = new JButton("add");
		btnAdd.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnAdd.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dm=(DefaultTableModel)tabla.getModel();
				dm.addRow(introducirRejilla(item));				
			}
		});
		btnAdd.setMinimumSize(new Dimension(100, 51));
		btnAdd.setMaximumSize(new Dimension(100, 51));
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdd.anchor = GridBagConstraints.WEST;
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 0;
		add(btnAdd, gbc_btnAdd);
		
		JComboBox comboArticulos = new JComboBox();
		GridBagConstraints gbc_comboArticulos = new GridBagConstraints();
		gbc_comboArticulos.insets = new Insets(0, 0, 5, 0);
		gbc_comboArticulos.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboArticulos.gridx = 1;
		gbc_comboArticulos.gridy = 1;
		add(comboArticulos, gbc_comboArticulos);
		
		JButton btnCheck = new JButton("check");
		btnCheck.setAlignmentY(Component.TOP_ALIGNMENT);
		btnCheck.setMinimumSize(new Dimension(100, 51));
		btnCheck.setMaximumSize(new Dimension(100, 51));
		btnCheck.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_btnCheck = new GridBagConstraints();
		gbc_btnCheck.gridx = 1;
		gbc_btnCheck.gridy = 2;
		add(btnCheck, gbc_btnCheck);
		
	}
	private Object[] introducirRejilla(Articulo item) {
		Object[] retorno= {item.getId(),item.getNombre(),item.getPrecio()};
		return retorno;
	}
}
