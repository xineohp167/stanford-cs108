import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PairTest {

	@Test
	public void testContains() {
		Pair<Integer> testPair = new Pair<Integer>(3,3);
		
		assertTrue(testPair.contains(3));
	}

	@Test
	public void testSwap() {
		Pair<Integer> testPair = new Pair<Integer>(3,5);
		testPair.swap();
		
		assertEquals(new Integer(5), testPair.getA());
		assertEquals(new Integer(3), testPair.getB());		
	}
	
	Pair<Integer> mainPair;
	
	@Before
	public void setup() {
		mainPair = new Pair<Integer>(12,14);
	}
	
	@Test
	public void testSwap2() {
		mainPair.swap();
		
		assertEquals(new Integer(14), mainPair.getA());
		assertEquals(new Integer(12), mainPair.getB());		
	}
	
	@Test
	public void testGet() {
		assertEquals(new Integer(12), mainPair.getA());		
	}
}
