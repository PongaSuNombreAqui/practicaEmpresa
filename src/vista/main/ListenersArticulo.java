package vista.main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import control.Logica;
import vista.paneles.PanelArticulo;
import vista.paneles.PanelEditarArticulo;
import vista.paneles.PanelPedido;

public class ListenersArticulo {
	private PanelArticulo panelArticulo;
	private PanelEditarArticulo panelEditarArticulo;
	private Logica logica;
	private PanelPedido panelPedido;

	public ListenersArticulo(AccionesParaUI accPUI, Logica logica, PanelArticulo panelArticulo,
			PanelEditarArticulo panelEditarArticulo, PanelPedido panelPedido) {
		this.panelArticulo = panelArticulo;
		this.panelEditarArticulo = panelEditarArticulo;
		this.logica = logica;
		this.panelPedido = panelPedido;
		ponerListenerArticulo(accPUI);
	}

	private void ponerListenerArticulo(AccionesParaUI accPUI) {

		logica.insertarArticulosEnCombo(panelArticulo.getComboPanelArticulo());

		panelEditarArticulo.getNuevoPrecio().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if ((e.getKeyChar() < '0' && e.getKeyChar() != '.' || e.getKeyChar() > '9') && e.getKeyChar() != '.') {
					e.consume();
				}
			}
		});

		panelArticulo.getCrearPrecio().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if ((e.getKeyChar() < '0' && e.getKeyChar() != '.' || e.getKeyChar() > '9') && e.getKeyChar() != '.') {
					e.consume();
				}
			}
		});

		panelArticulo.getCrearID().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if ((e.getKeyChar() < '0' || e.getKeyChar() > '9')) {
					e.consume();
				}
			}
		});

		panelArticulo.getCrearNombre().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if ((e.getKeyChar() < 'a' || e.getKeyChar() > 'z') && (e.getKeyChar() < 'A' || e.getKeyChar() > 'Z')) {
					e.consume();
				}
			}
		});

		panelArticulo.getComboPanelArticulo().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String articuloSeleccionado = (String) panelArticulo.getComboPanelArticulo().getSelectedItem();
				if (articuloSeleccionado != null) {
					logica.consultar(articuloSeleccionado, panelArticulo.getDetallesNombre(),
							panelArticulo.getDetallesID(), panelArticulo.getDetallesPrecio(),
							panelArticulo.getDetallesDescripcion());
				}
			}
		});

		panelArticulo.getBtnBuscar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelArticulo.aniadir(panelEditarArticulo);
				panelArticulo.revalidate();
			}
		});

		panelArticulo.getBtnCrear().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelArticulo.getCrearNombre().getText().isEmpty() || panelArticulo.getCrearID().getText().isEmpty()
						|| panelArticulo.getCrearPrecio().getText().isEmpty()
						|| panelArticulo.getCrearDescripcion().getText().isEmpty()) {
					accPUI.setMensaje("Error: Parametro vacio!!", Color.RED, panelArticulo.getTextMensajeSistema());
				} else {
					if (false == accPUI.comprobarPuntos(panelArticulo.getCrearPrecio().getText())) {
						if (logica.crearArticulo(panelArticulo.getCrearNombre().getText(),
								Float.valueOf(panelArticulo.getCrearPrecio().getText()),
								Integer.valueOf(panelArticulo.getCrearID().getText()),
								panelArticulo.getCrearDescripcion().getText())) {
							logica.insertarArticulosEnCombo(panelArticulo.getComboPanelArticulo());
							logica.insertarArticulosEnCombo(panelPedido.getComboArticulos());
							accPUI.setMensaje("El articulo ha sido creado.", Color.GREEN,
									panelArticulo.getTextMensajeSistema());
							accPUI.borrarTxt(panelArticulo.getCrearNombre(), panelArticulo.getCrearID(),
									panelArticulo.getCrearPrecio(), panelArticulo.getCrearDescripcion());
						} else {
							accPUI.setMensaje("Error: El articulo ya existe!!", Color.RED,
									panelArticulo.getTextMensajeSistema());
						}
					} else {
						accPUI.setMensaje("Error: Precio esta mal escrito!!", Color.RED,
								panelArticulo.getTextMensajeSistema());
					}
				}
			}
		});

		panelEditarArticulo.getBtnEditar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelArticulo.getDetallesNombre().getText() != null) {
					if (false == panelEditarArticulo.getNuevoPrecio().getText().isEmpty()) {
						if (false == accPUI.comprobarPuntos(panelEditarArticulo.getNuevoPrecio().getText())) {
							logica.editar(panelArticulo.getDetallesNombre().getText(),
									Float.valueOf(panelEditarArticulo.getNuevoPrecio().getText()));
							panelArticulo.getDetallesPrecio().setText(panelEditarArticulo.getNuevoPrecio().getText());
							panelEditarArticulo.getNuevoPrecio().setText("");
						} else {
							accPUI.setMensaje("Error: El nuevo precio esta mal escrito!!", Color.RED,
									panelArticulo.getTextMensajeSistema());
						}
					} else {
						accPUI.setMensaje("Error: Vacio!!", Color.RED, panelArticulo.getTextMensajeSistema());
					}
				} else {
					accPUI.setMensaje("Error: Debes consultar un articulo!!", Color.RED,
							panelArticulo.getTextMensajeSistema());
				}
			}
		});

		panelEditarArticulo.getBtnBuscar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!panelEditarArticulo.getTxtFecha().getText().isEmpty()) {
					if (!panelArticulo.getDetallesNombre().getText().isEmpty()) {
						String fecha = panelEditarArticulo.getTxtFecha().getText();
						float precioAnteriorSegunFecha = logica.getPrecioAnteriorSegunFecha(fecha,
								panelArticulo.getDetallesNombre().getText());
						panelEditarArticulo.getLblPrecio().setText(String.valueOf(precioAnteriorSegunFecha));
					} else {
						accPUI.setMensaje("Error: Vacio!!", Color.RED, panelArticulo.getTextMensajeSistema());
					}
				} else {
					panelEditarArticulo.getLblPrecio().setText("Error: Vacio!!");
				}
			}
		});
	}

}
