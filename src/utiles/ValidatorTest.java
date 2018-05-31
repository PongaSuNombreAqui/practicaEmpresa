package utiles;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ValidatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsNumber() {
		assertFalse(Validator.isNumber("cosa"));
		assertTrue(Validator.isNumber("2323232"));
		assertTrue(Validator.isNumber("2.323232"));
		assertTrue(Validator.isNumber(".2323232"));
		assertFalse(Validator.isNumber("j2323232"));
		assertTrue(Validator.isNumber("2323232."));
		assertFalse(Validator.isNumber("23d23232"));
		assertFalse(Validator.isNumber("2323232f"));
		assertFalse(Validator.isNumber("2323232d"));
	}

	@Test
	public void testIsPhone() {
		assertTrue(Validator.isPhone("912123987"));
		assertTrue(Validator.isPhone("612123987"));
		assertTrue(Validator.isPhone("712123987"));
		assertFalse(Validator.isPhone("56"));
		assertFalse(Validator.isPhone("56ddd"));
		assertFalse(Validator.isPhone("569876654"));
	}

	@Test
	public void testIsInteger() {
		assertTrue(Validator.isInteger("912123987"));
		assertTrue(Validator.isInteger("2323232"));
		assertTrue(Validator.isInteger("45"));
		assertFalse(Validator.isInteger(".612123987"));
		assertFalse(Validator.isInteger("2.323232"));
		assertFalse(Validator.isInteger("2323232d"));
		assertFalse(Validator.isInteger("2323232f"));
		assertFalse(Validator.isInteger("23d23232"));

	}

}
