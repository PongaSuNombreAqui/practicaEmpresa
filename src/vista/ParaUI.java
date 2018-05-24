package vista;

import control.AccionesArticulo;
import control.AccionesCliente;
import control.AccionesPedido;
import control.AlmacenArticulo;
import control.AlmacenCliente;

public class ParaUI extends UI{

	AccionesArticulo accionesArticulo;
	AccionesCliente accionesCliente;
	AccionesPedido accionesPedido;
	public ParaUI() {
		super();
		this.accionesArticulo=new AccionesArticulo();
		this.accionesCliente= new AccionesCliente();
		this.accionesPedido= new AccionesPedido();
		panelMain.add(new PanelMain());
		panelArticulo.add(new PanelArticulo());
		panelPedido.add(new PanelPedido());
		panelCliente.add(new PanelCliente());
		
		
		
		//TODO action listeners all
	}
}
