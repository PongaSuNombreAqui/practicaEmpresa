package vista.main;

import java.awt.Color;
import java.awt.event.*;
import java.io.File;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import control.Logica;
import utiles.Utiles;
import utiles.Validator;
import vista.paneles.PanelArticulo;
import vista.paneles.PanelCliente;
import vista.paneles.PanelEditarArticulo;
import vista.paneles.PanelMain;
import vista.paneles.PanelPedido;
import vista.paneles.PanelTabla;
import vista.paneles.UI;

/**
 * 
 * @author fp-hermoso
 *
 */
public class ParaUI extends UI {

	private Logica logica;
	private PanelPedido panelPedido;
	private PanelTabla panelTabla;
	private PanelCliente panelCliente;
	private PanelArticulo panelArticulo;
	private PanelMain panelMain;
	private PanelEditarArticulo panelEditarArticulo;
	private AccionesParaUI AccPUI;

	/**
	 * constructor ParaUI
	 */
	public ParaUI() {
		super();
		this.logica = new Logica();

		this.panelMain = new PanelMain();
		panelGeneralMain.add(panelMain);
		prepararPanelPedido();
		prepararPanelArticulo();
		prepararPanelCliente();

		AccPUI = new AccionesParaUI(logica, panelPedido, panelCliente, panelArticulo);
		AccPUI.directorios();
		new ListenersArticulo(AccPUI, logica, panelArticulo, panelEditarArticulo, panelPedido);
		new ListenersCliente(logica, panelPedido, panelCliente, AccPUI);
		new ListenersPedido(panelPedido, panelTabla, AccPUI, logica);

	}

	/**
	 * preparacion del panel pedido
	 */
	private void prepararPanelPedido() {
		this.panelPedido = new PanelPedido(); // crea el panelpedido
		this.panelTabla = new PanelTabla(); // crea el paneltabla
		this.panelPedido.addPanelTabla(panelTabla); // mete el paneltabla en el
													// panelpedido
		panelGeneralPedido.add(panelPedido);
		logica.insertarClientesEnCombo(panelPedido.getComboClientes());
	}

	/**
	 * preparacion del panel cliente
	 */
	private void prepararPanelCliente() {
		this.panelCliente = new PanelCliente();
		panelGeneralCliente.add(panelCliente);

	}

	/**
	 * preparacion del panel articulo
	 */
	private void prepararPanelArticulo() {
		this.panelArticulo = new PanelArticulo();
		panelGeneralArticulo.add(panelArticulo);
		this.panelEditarArticulo = new PanelEditarArticulo();

	}

}