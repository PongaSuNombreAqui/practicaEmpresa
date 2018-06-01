package test.almacenes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
/**
 * 
 * @author fp-hermoso
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ AlmacenClienteTest.class, AlmacenPedidoTest.class, AlmacenArticuloTest.class })
public class AllTests {

}
