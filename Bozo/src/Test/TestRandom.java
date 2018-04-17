import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestRandom {
	
	private Random test;

	@Before
	public void setUp() {
		test = new Random();
	}

	@After
	public void tearDown() {
		test = null;
	}
	
	@Test
	public void testGetRand(){
		double k = test.getRand();
		assertTrue(k >= 0 && k <= 1);
	}
	
	@Test
	public void testGetIntRand(){
		for(int i = 0; i < 100; i++){
			int n = test.getIntRand(100);
			double k = test.getIntRand(n);
			assertTrue(k >= 0 && k <= n);
		}
	}
	
	@Test
	public void testSettingSeed(){
		Random t = new Random(1023);
		double k = t.getRand();
		assertEquals(0.9, k, 0.1);
	}
	
	@Test
	public void testSetSemente(){
		test.setSemente(1023);
		double k = test.getRand();
		assertEquals(0.9, k, 0.1);
	}

}
