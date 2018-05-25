package vista;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.omg.Messaging.SyncScopeHelper;

import control.AccionesArticulo;
import control.AccionesCliente;
import control.AccionesPedido;
import control.AlmacenArticulo;
import control.AlmacenCliente;
import modelo.Articulo;
import modelo.Cliente;

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
				accionesPedido.aniadirArticuloATabla(panelTabla.getTabla(),(String) panelPedido.getComboArticulos().getSelectedItem()); //TODO pilla el nombre del combobox donde esta los articulos
				panelPedido.getBtnCheck().setEnabled(true);
				panelPedido.getBtnDelete().setEnabled(true);
				panelPedido.revalidate();
			}
		});
		panelPedido.getBtnCheck().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TOD no se que hace el check
			}
		});
		panelPedido.getBtnNuevoPedido().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPedido.getComboArticulos().setEnabled(true);
				panelPedido.getBtnEncargar().setEnabled(true);
				panelPedido.getTxtNombreCliente().setEditable(true);
				panelPedido.getBtnNuevoPedido().setEnabled(false);
				panelPedido.getBtnVer().setEnabled(false);
				panelPedido.getTxtNumeroPedido().setText(String.valueOf(accionesPedido.getNumeroPosiblePedido()));
			}
		});
		panelPedido.getBtnEncargar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!panelPedido.getTxtNombreCliente().getText().isEmpty()) {
					panelPedido.getBtnNuevoPedido().setEnabled(true);
					panelPedido.getComboArticulos().setEnabled(false);
					panelPedido.getBtnEncargar().setEnabled(false);
					panelPedido.getBtnDelete().setEnabled(false);
					panelPedido.getTxtNombreCliente().setEditable(false);
					panelPedido.getBtnCheck().setEnabled(false);
					panelPedido.getBtnAdd().setEnabled(false);
					panelPedido.getBtnVer().setEnabled(true);
					ArrayList lineaPedido = new ArrayList<>();
					if(accionesPedido.crear(lineaPedido,Integer.valueOf(panelPedido.getTxtNombreCliente().getText()))){
						panelPedido.getTxtMensaje().setText("Pedido completado satisfactoriamente");
					}else{
						panelPedido.getTxtMensaje().setText("Fallo al encargar el pedido");
					}
				}else{
					panelPedido.getTxtMensaje().setText("Campo cliente vacio o erroneo");
				}
			}
		});
		panelPedido.getBtnDelete().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(panelTabla.getTabla().getRowCount());
				int row = panelTabla.getTabla().getSelectedRow();
				System.out.println(row);
				panelTabla.getTabla().remove(row);//TODO ????
				
			}
		});
		panelPedido.getComboArticulos().addActionListener((e)->	panelPedido.getBtnAdd().setEnabled(true)
		);			
	}

	private void prepararTablaPedido() {
		this.panelPedido= new PanelPedido(); //crea el panelpedido
		this.panelTabla = new PanelTabla();  //crea el paneltabla
		this.panelPedido.addPanelTabla(panelTabla); //mete el paneltabla en el panelpedido  
		panelGeneralPedido.add(panelPedido);
		
		panelPedido.getComboArticulos().addItem("ajo");//TODO recorrer articulos para insertarlos en el commbobox
		panelPedido.getComboArticulos().addItem("pan");
		Cliente cliente = (Cliente) new AlmacenCliente<>().obtener(0);
		File[] listFiles = new File("./data/pedidos/"+cliente.getID()).listFiles();
		for (int i = 0; i < listFiles.length; i++) {
			panelPedido.getComboPedidos().addItem(listFiles[i].getName());
		}
		
	}
	
	
	
	
	
	
}
