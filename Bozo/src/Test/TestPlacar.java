import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import BozoException.BozoException;

public class TestPlacar {
	
	private Placar test;

	@Before
	public void setUp() {
		test = new Placar();
	}

	@After
	public void tearDown() {
		test = null;
	}
	
	@Test(expected=BozoException.class)
	public void testAddPosInvalida(){
		try {
			test.add(-1, new int[] {1,2,3,4,5});
		} catch (BozoException e) {
			;
		}
		try {
			test.add(11, new int[] {1,2,3,4,5});
		} catch (BozoException e) {
			;
		}
	}
	
	@Test
	public void testAdd(){
		for(int i = 0; i < 11; i++){
			try {
				test.add(i, new int[] {1,2,3,4,5});
			} catch (BozoException e) {
				;
			}
		}
		assertEquals(35, test.getScore());
	}
	
	@Test
	public void testReAdd(){
		try {
			test.add(1, new int[] {1,2,3,4,5});
		} catch (BozoException e) {
			;
		}
		try {
			test.add(1, new int[] {1,2,3,4,5});
		} catch (BozoException e) {
			;
		}
	}
	
	@Test
	public void testAddRepetitions(){
		for(int i = 0; i < 11; i++){
			try {
				test.add(i, new int[] {1,1,1,1,1});
			} catch (BozoException e) {
				;
			}
		}
		assertEquals(90, test.getScore());
	}
	
	@Test
	public void testAddBreaks(){
		for(int i = 0; i < 11; i++){
			try {
				test.add(i, new int[] {1,2,1,1,1});
			} catch (BozoException e) {
				;
			}
		}
		assertEquals(36, test.getScore());
	}
	
	@Test
	public void testGetScore(){
		assertEquals(0, test.getScore());
	}
	
	@Test
	public void testToString(){
		test.toString();
	}
	
	@Test
	public void testToStringWithValues(){
		try {
			test.add(1, new int[] {1,2,1,1,1});
		} catch (BozoException e) {
			;
		}
		test.toString();
	}


}
