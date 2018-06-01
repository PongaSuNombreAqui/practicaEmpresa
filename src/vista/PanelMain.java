package vista;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
/**
 * 
 * @author fp-hermoso
 *
 */
public class PanelMain extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelMain() {
		setBackground(Color.GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 360, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 24, 59, 47, 47, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNombreEmpresa = new JLabel("Nombre empresa");
		lblNombreEmpresa.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		GridBagConstraints gbc_lblNombreEmpresa = new GridBagConstraints();
		gbc_lblNombreEmpresa.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreEmpresa.gridx = 1;
		gbc_lblNombreEmpresa.gridy = 1;
		add(lblNombreEmpresa, gbc_lblNombreEmpresa);

		JLabel lblDatos = new JLabel("datos");
		GridBagConstraints gbc_lblDatos = new GridBagConstraints();
		gbc_lblDatos.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatos.gridx = 1;
		gbc_lblDatos.gridy = 4;
		add(lblDatos, gbc_lblDatos);

	}

}
