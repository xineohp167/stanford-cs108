// TabooTest.java
// Taboo class tests -- nothing provided.
package assign1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class TabooTest {
	
	
	// Test noFollow ///////////////////////////////////////////////////
	@Test
	public void testNoFollowBasic() {
		Set<Integer> orig = new HashSet<Integer>();
		orig.add(2);
		List<Integer> a = Arrays.asList(1, 2, 3, 4);
		Taboo<Integer> tbo = new Taboo<Integer>(a);
		assertEquals(orig, tbo.noFollow(1));
	}
	
	@Test
	public void testNoFollowEmpty() {
		Set<Integer> orig = new HashSet<Integer>();
		//orig.add(2);
		List<Integer> a = Arrays.asList(1, 2, 3, 4);
		Taboo<Integer> tbo = new Taboo<Integer>(a);
		assertEquals(orig, tbo.noFollow(5));
	}
	
	@Test
	public void testNoFollowNull() {
		Set<String> orig = new HashSet<String>();
		orig.add("b");
		List<String> a = Arrays.asList("a", "b", null, "c", "d");
		Taboo<String> tbo = new Taboo<String>(a);
		assertEquals(orig, tbo.noFollow("a"));
	}
	
	@Test
	public void testNoFollowMore() {
		Set<String> orig = new HashSet<String>();
		orig.add("b");
		orig.add("c");
		List<String> a = Arrays.asList("a", "c", "a", "b");
		Taboo<String> tbo = new Taboo<String>(a);
		assertEquals(orig, tbo.noFollow("a"));
	}
	
	
	//// Test reduce ///////////////////////////////////////////
	@Test
    public void reduceBasicTest() {
        List<String> list = Arrays.asList("a", "c", "a", "b");
        Taboo<String> taboo = new Taboo<String>(list);

        List<String> reducedList = new ArrayList<String>(Arrays.asList("a", "c", "b", "x", "c", "a"));
        taboo.reduce(reducedList);
        List<String> resultList = new ArrayList<String>(Arrays.asList("a", "x", "c"));
        assertTrue(resultList.equals(reducedList));

    }

    @Test
     public void reduceAdvancedTest() {
        List<String> list = Arrays.asList("a", "a");
        Taboo<String> taboo = new Taboo<String>(list);

        List<String> reducedList = new ArrayList<String>(Arrays.asList("a", "a", "a", "a"));
        taboo.reduce(reducedList);

        List<String> resultList = new ArrayList<String>(Arrays.asList("a"));
        assertTrue(resultList.equals(reducedList));

    }
    @Test
    public void reduceAdvancedTest2() {
        List<String> list = Arrays.asList("a");
        Taboo<String> taboo = new Taboo<String>(list);

        List<String> reducedList = new ArrayList<String>(Arrays.asList("a", "a", "a", "a"));
        taboo.reduce(reducedList);

        List<String> resultList = new ArrayList<String>(Arrays.asList("a", "a", "a", "a"));
        assertTrue(resultList.equals(reducedList));
    }

    @Test
    public void testReduceEdge() {
        List<String> rules1 = Arrays.asList("");
        Taboo<String> t1 = new Taboo<String>(rules1);

        List<String> a = Arrays.asList("");
        t1.reduce(a);
        assertTrue(a.equals(Arrays.asList("")));
    }
}
