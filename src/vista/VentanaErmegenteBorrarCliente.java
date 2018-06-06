package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class VentanaErmegenteBorrarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnConfirmar;
	private JButton btnCancelar;

	public VentanaErmegenteBorrarCliente() {
		setVisible(true);
		setBounds(100, 100, 352, 125);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 394, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("\u00BF Desea eliminar este cliente ? ");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel.insets = new Insets(10, 0, 10, 0);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			GridBagLayout gbl_buttonPane = new GridBagLayout();
			gbl_buttonPane.columnWidths = new int[] { 176, 176, 0 };
			gbl_buttonPane.rowHeights = new int[] { 30, 0 };
			gbl_buttonPane.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
			gbl_buttonPane.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
			buttonPane.setLayout(gbl_buttonPane);
			{
				btnConfirmar = new JButton("Confirmar");
				btnConfirmar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				GridBagConstraints gbc_okButton = new GridBagConstraints();
				gbc_okButton.fill = GridBagConstraints.BOTH;
				gbc_okButton.insets = new Insets(0, 0, 0, 5);
				gbc_okButton.gridx = 0;
				gbc_okButton.gridy = 0;
				buttonPane.add(btnConfirmar, gbc_okButton);
				getRootPane().setDefaultButton(btnConfirmar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				btnCancelar.setActionCommand("Cancel");
				GridBagConstraints gbc_cancelButton = new GridBagConstraints();
				gbc_cancelButton.fill = GridBagConstraints.BOTH;
				gbc_cancelButton.gridx = 1;
				gbc_cancelButton.gridy = 0;
				buttonPane.add(btnCancelar, gbc_cancelButton);
			}
		}
	}

	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	

}
