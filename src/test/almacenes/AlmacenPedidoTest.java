package test.almacenes;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import control.almacenes.AlmacenRuta;
import modelo.Cliente;
import modelo.Pedido;
/**
 * 
 * @author fp-hermoso
 *
 */
public class AlmacenPedidoTest {
	Cliente clienteUno, clienteDos, clienteTres;
	Pedido pedidoUno, pedidoDos, pedidoTres, pedidoCuatro, pedidoCinco, pedidoSeis;
	String path = "./dataTest/pedidos/";

	@Before
	public void setUp() throws Exception {
		Cliente clienteUno = new Cliente("dni1", "uno", "asd", "123");
		Cliente clienteDos = new Cliente("dni2", "uno", "asd", "123");
		Cliente clienteTres = new Cliente("dni3", "uno", "asd", "123");
		pedidoUno = new Pedido(1, clienteUno);
		pedidoDos = new Pedido(2, clienteDos);
		pedidoTres = new Pedido(3, clienteUno);
		pedidoCuatro = new Pedido(4, clienteDos);
		pedidoCinco = new Pedido(5, clienteTres);
		pedidoSeis = new Pedido(6, clienteUno);

	}

	@After
	public void tearDown() throws Exception {
		File dir = new File("./dataTest/pedidos");
		File[] list = dir.listFiles();
		for (int i = 0; i < list.length; i++) {
			File[] files = list[i].listFiles();
			for (int j = 0; j < files.length; j++) {
				files[j].delete();
			}
			list[i].delete();
		}
		dir.delete();
	}

	@Test
	public void testGrabar() {
		assertTrue(new AlmacenRuta(path).grabar(pedidoUno.getCliente().getDniCif(), pedidoUno));
		assertTrue(new AlmacenRuta(path).grabar(pedidoDos.getCliente().getDniCif(), pedidoDos));
		assertTrue(new AlmacenRuta(path).grabar(pedidoTres.getCliente().getDniCif(), pedidoTres));
		assertTrue(new AlmacenRuta(path).grabar(pedidoCuatro.getCliente().getDniCif(), pedidoCuatro));
		assertTrue(new AlmacenRuta(path).grabar(pedidoCinco.getCliente().getDniCif(), pedidoCinco));
		assertTrue(new AlmacenRuta(path).grabar(pedidoSeis.getCliente().getDniCif(), pedidoSeis));
	}

	@Test
	public void testLeer() {
		testGrabar();
		assertEquals(pedidoUno, new AlmacenRuta(path).leer(pedidoUno.getCliente().getDniCif(), pedidoUno.getNumero()));
		assertEquals(pedidoDos, new AlmacenRuta(path).leer(pedidoDos.getCliente().getDniCif(), pedidoDos.getNumero()));
		assertEquals(pedidoTres,
				new AlmacenRuta(path).leer(pedidoTres.getCliente().getDniCif(), pedidoTres.getNumero()));
		assertEquals(pedidoCuatro,
				new AlmacenRuta(path).leer(pedidoCuatro.getCliente().getDniCif(), pedidoCuatro.getNumero()));
		assertEquals(pedidoCinco,
				new AlmacenRuta(path).leer(pedidoCinco.getCliente().getDniCif(), pedidoCinco.getNumero()));
		assertEquals(pedidoSeis,
				new AlmacenRuta(path).leer(pedidoSeis.getCliente().getDniCif(), pedidoSeis.getNumero()));
	}

}
