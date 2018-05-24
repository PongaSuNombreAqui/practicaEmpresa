package vista;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.AccionesArticulo;
import control.AccionesCliente;
import control.AccionesPedido;
import control.AlmacenArticulo;
import control.AlmacenCliente;
import modelo.Articulo;

public class ParaUI extends UI {

	AccionesArticulo accionesArticulo;
	AccionesCliente accionesCliente;
	AccionesPedido accionesPedido;
	PanelPedido panelPedido;
	PanelTabla panelTabla;
	PanelCliente panelCliente;
	PanelArticulo panelArticulo;
	PanelMain panelMain;
	
	public ParaUI() {
		super();
		this.panelArticulo= new PanelArticulo();
		this.panelCliente= new PanelCliente();
		this.panelMain=new PanelMain();
		
		//acciones
		this.accionesArticulo = new AccionesArticulo();
		this.accionesCliente = new AccionesCliente();
		this.accionesPedido = new AccionesPedido();
		
		
		panelGeneralMain.add(panelMain);
		panelGeneralArticulo.add(panelArticulo);
		panelGeneralCliente.add(panelCliente);
		
		prepararTablaPedido();
		
		
		// TODO action listeners all
		ponerListenersPedido();
		ponerListenerArticulo();
		ponerListenerCliente();
	}
	
	private void ponerListenerArticulo() {
		// TODO Auto-generated method stub
		
	}

	private void ponerListenerCliente() {
		// TODO Auto-generated method stub
		
	}

	private void ponerListenersPedido() {
		panelPedido.getBtnAdd().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionesPedido.añadirArticuloATabla(panelTabla.getTabla(),"ajo"); //TODO pilla el nombre del combobox donde esta los articulos
				panelPedido.revalidate();
			}
		});
		panelPedido.getBtnCheck().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO no se que hace el check
			}
		});
	}

	private void prepararTablaPedido() {
		this.panelPedido= new PanelPedido(); //crea el panelpedido
		this.panelTabla = new PanelTabla();  //crea el paneltabla
		this.panelPedido.addPanelTabla(panelTabla); //mete el paneltabla en el panelpedido  
		panelGeneralPedido.add(panelPedido);
		new AlmacenArticulo<>().grabar(new Articulo(1, "ajo", 122), 1, "ajo");// TODO para testear tabla
		
	}
}
