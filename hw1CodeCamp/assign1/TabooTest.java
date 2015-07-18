// TabooTest.java
// Taboo class tests -- nothing provided.
package assign1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class TabooTest {

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
		orig.add("c");
		orig.add("b");
		List<String> a = Arrays.asList("a", "c", "a", "b");
		Taboo<String> tbo = new Taboo<String>(a);
		assertEquals(orig, tbo.noFollow("a"));
	}
}
