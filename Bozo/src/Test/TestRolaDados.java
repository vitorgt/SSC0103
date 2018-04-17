import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestRolaDados {
	
	private RolaDados test;
	private int n = 5;

	@Before
	public void setUp() throws Exception {
		test = new RolaDados(n);
	}

	@After
	public void tearDown() throws Exception {
		test = null;
	}

	@Test
	public void testRolar() {
		test.Rolar();
	}

	@Test
	public void testRolarQuaisBool() {
		boolean mudar[] = {true, true, true, false, false};
		int antes[] = test.Rolar().clone();
		int depois[] = test.Rolar(mudar).clone();
		for(int i = 0; i < n; i++){
			if(!mudar[i])
				assertEquals(antes[i], depois[i]);
		}
		boolean mudar2[] = {false, false, false, false, false};
		antes = test.Rolar().clone();
		depois = test.Rolar(mudar2).clone();
		for(int i = 0; i < n; i++){
			if(!mudar2[i])
				assertEquals(antes[i], depois[i]);
		}
	}

	@Test
	public void testRolarQuaisStri() {
		int antes[] = test.Rolar().clone();
		int depois[] = test.Rolar("1 2").clone();
		for(int i = 2; i < n; i++){
			assertEquals(antes[i], depois[i]);
		}
		antes = test.Rolar().clone();
		depois = test.Rolar("").clone();
		for(int i = 0; i < n; i++){
			assertEquals(antes[i], depois[i]);
		}
	}

	@Test
	public void testResultadosDados() {
		test.setResultadosDados(new int[] {1,1,1,1,1});
		assertArrayEquals(new int[] {1,1,1,1,1}, test.getResultadosDados());
	}

}
