import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DictionaryTest {
	
	private Dictionary<Integer,String> test;

	@Before
	public void setUp() throws Exception {
		test = new Dictionary<Integer,String>();
		test.add(4952, "Vitor");
		test.add(4667, "Fabio");
	}

	@After
	public void tearDown() throws Exception {
		test = null;
	}
	
	@Test
	public void testSearch() {
		assertEquals("Fabio", test.search(4667));
	}
	
	@Test
	public void testSearchNull() {
		assertNull(test.search(1563));
	}

	@Test
	public void testContainsKey() {
		assertTrue(test.containsKey(4952));
	}

	@Test
	public void testContainsKeyNotFound() {
		assertFalse(test.containsKey(1563));
	}

	@Test
	public void testContainsValue() {
		assertTrue(test.containsValue("Fabio"));
	}

	@Test
	public void testContainsValueNotFound() {
		assertFalse(test.containsValue("Joao"));
	}

}
