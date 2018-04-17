import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDado {
	
	private Dado test;

	@Before
	public void setUp(){
		test = new Dado();
	}

	@After
	public void tearDown(){
		test = null;
	}
	
	@Test
	public void testGetLadoNew(){
		assertEquals(0, test.getLado());
	}
	
	@Test
	public void testSetDadoN(){
		Dado dn = new Dado(9);
		dn.toString();
		Dado db = new Dado(-1);
		db.toString();
	}
	
	@Test
	public void testRolar(){
		int k = test.rolar();
		assertTrue(k > 0 && k < 7);
	}
	
	@Test
	public void testToString(){
		for(int i = 0; i < 10000; i++){
			test.rolar();
			test.toString();
		}
	}

}
