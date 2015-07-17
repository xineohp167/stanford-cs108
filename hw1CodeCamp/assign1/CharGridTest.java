// Test cases for CharGrid -- a few basic tests are provided.
package assign1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class CharGridTest {
	
	@Test
	public void testCharArea1() {
		char[][] grid = new char[][] {
				{'a', 'y', ' '},
				{'x', 'a', 'z'},
			};
		
		
		CharGrid cg = new CharGrid(grid);
				
		assertEquals(4, cg.charArea('a'));
		assertEquals(1, cg.charArea('z'));
	}
	
	
	@Test
	public void testCharArea2() {
		char[][] grid = new char[][] {
				{'c', 'a', ' '},
				{'b', ' ', 'b'},
				{' ', ' ', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(6, cg.charArea('a'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
		assertEquals(0, cg.charArea('d'));
	}
	
	
	@Test
	public void testCharAreaVerticalGrid() {
		char[][] grid = new char[][]{
                {'c', 'a', ' '}
        };
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(1, cg.charArea('a'));
        assertEquals(1, cg.charArea(' '));
        assertEquals(1, cg.charArea('c'));
        assertEquals(0, cg.charArea('z'));
	}
	
	@Test
	public void testCharAreaVHorizontalGrid() {
		char[][] grid = new char[][]{
                {' '},
                {'b'},
                {'a'}
        };

        CharGrid cg = new CharGrid(grid);

        assertEquals(1, cg.charArea(' '));
        assertEquals(1, cg.charArea('b'));
        assertEquals(1, cg.charArea('a'));
        assertEquals(0, cg.charArea('z'));
	}
	
	@Test
	public void testCharAreaEmptyGrid() {
		char[][] grid = new char[0][0];
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(0, cg.charArea('a'));
		assertEquals(0, cg.charArea('b'));
	}
	
}
