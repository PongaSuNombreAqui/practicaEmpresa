package test.almacenes;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Path;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import control.almacenes.AlmacenIndice;
import modelo.Articulo;
/**
 * 
 * @author fp-hermoso
 *
 * @param <T> object
 * @param <K> key
 */
public class AlmacenArticuloTest<T, K> {

	Articulo articuloUno = new Articulo(0, "pan", null, 0);
	Articulo articuloDos = new Articulo(1, "ajo", null, 0);
	Articulo articuloTres = new Articulo(2, "sal", null, 0);
	String path = "./dataTest/articulos/";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		File dir = new File("./dataTest/articulos");
		File[] list = dir.listFiles();
		for (int i = 0; i < list.length; i++) {
			list[i].delete();
		}
		dir.delete();
	}

	@Test
	public void testGrabar() {
		new AlmacenIndice<T, K>(path).grabar((T) articuloDos, articuloDos.getIdArticulo(), articuloDos.getNombre());
		Articulo articuloDos = new Articulo(2, "sal", null, 50);
		new AlmacenIndice<T, K>(path).grabar((T) articuloDos, articuloDos.getIdArticulo(), articuloDos.getNombre());
		new AlmacenIndice<T, K>(path).grabar((T) articuloTres, articuloTres.getIdArticulo(), articuloTres.getNombre());
		new AlmacenIndice<T, K>(path).grabar((T) articuloUno, articuloUno.getIdArticulo(), articuloUno.getNombre());
		Articulo leer = (Articulo) new AlmacenIndice<T, K>(path).leer(articuloDos.getNombre());
		assertEquals(leer.getCurrentPrice(), this.articuloDos.getCurrentPrice(), 0); // no sobreescribe el precio al
																						// guardarlo de nuevos

		// si repites nombre si se guarda, solo tiene en cuenta el id, esta comentado
		// para que no altere el testLeer
		// Articulo antes = inst.leer("ajo");
		// Articulo unoQueRepiteNombre = new Articulo(3, "ajo", "s", 20);
		// inst.grabar(unoQueRepiteNombre, unoQueRepiteNombre.getIdArticulo(),
		// unoQueRepiteNombre.getNombre());
		// Articulo despues = inst.leer("ajo");
		// assertNotEquals(antes.getIdArticulo(),despues.getIdArticulo());
		// assertEquals(antes.getNombre(),despues.getNombre());

	}

	@Test
	public void testLeer() {
		testGrabar();
		assertTrue(articuloUno.equals(new AlmacenIndice<T, K>(path).leer(articuloUno.getNombre())));
		assertTrue(articuloTres.equals(new AlmacenIndice<T, K>(path).leer(articuloTres.getNombre())));
		assertTrue(articuloDos.equals(new AlmacenIndice<T, K>(path).leer(articuloDos.getNombre())));
	}

}
