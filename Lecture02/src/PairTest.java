import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PairTest {

	@Test
	public void test1() {
		Pair<Integer> testPair = new Pair(3,3);
		
		assertTrue(testPair.contains(3));
	}

	@Test
	public void test2() {
		Pair<Integer> testPair = new Pair(3,5);
		testPair.swap();
		
		assertEquals(testPair.getA(),new Integer(5));
		assertEquals(testPair.getB(),new Integer(3));		
	}
	
	Pair<Integer> mainPair;
	
	@Before
	public void setup() {
		mainPair = new Pair(12,14);
	}
	
	@Test
	public void testA() {
		mainPair.swap();
		
		assertEquals(mainPair.getA(),new Integer(14));
		assertEquals(mainPair.getB(),new Integer(12));		
	}
	
	@Test
	public void testB() {
		assertEquals(mainPair.getA(),new Integer(12));		
	}
}
