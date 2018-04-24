import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

public class ImagemTest {

	Imagem circulo = null;
	Imagem oval = null;

	@Before
		public void setUp() throws Exception {
			circulo = new Imagem("src/circulo.png");
			oval = new Imagem("src/oval.png");
		}

	@After
		public void tearDown() throws Exception {
			circulo = null;
			oval = null;
		}

	@Test
		public void testGetIniX() {
			assertEquals(23, circulo.getIniX());
			assertEquals(139, oval.getIniX());
		}

	@Test
		public void testGetIniY() {
			assertEquals(16, circulo.getIniY());
			assertEquals(51, oval.getIniY());
		}

	@Test
		public void testGetMaiorLargura() {
			assertEquals(20, circulo.getMaiorLargura());
			assertEquals(196, oval.getMaiorLargura());
		}

	@Test
		public void testGetMaiorAltura() {
			assertEquals(20, circulo.getMaiorAltura());
			assertEquals(61, oval.getMaiorAltura());
		}

	@Test
		public void testGetPoints() {
			assertEquals(52, circulo.getPoints());
			assertEquals(407, oval.getPoints());
		}

	@Test
		public void testGetPeri() {
			assertEquals(61.94112549695426, circulo.getPeri(), 0.000000001);
			assertEquals(449.6639969244296, oval.getPeri(), 0.000000001);
		}

}
