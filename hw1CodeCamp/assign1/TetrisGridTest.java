package assign1;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.*;

public class TetrisGridTest {
	
	// Provided simple clearRows() test
	// width 2, height 3 grid
	@Test
	public void testClear1() {
		boolean[][] before =
		{	
			{true, true, false, },
			{false, true, true, }
		};
		
		boolean[][] after =
		{	
			{true, false, false},
			{false, true, false}
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	
	@Test
	public void testClearMultipleRows(){
		boolean[][] before =
			{
				{true, true, false, false, true},
				{false, true, true, false, false}
			};
		
		 boolean[][] after =
             {
                 {true, false, false, true, false},
                 {false, true, false, false, false}
             };
		 
		 boolean[][] wrongAfter =
             {
				 {true, true, false, false, true},
				 {false, true, true, false, false}
             };
		 
		 TetrisGrid tetris = new TetrisGrid(before);
	     tetris.clearRows();

	     assertTrue(Arrays.deepEquals(after, tetris.getGrid()));
	     assertFalse(Arrays.deepEquals(wrongAfter, tetris.getGrid()));
	}
	
	@Test
	public void emptyGridShouldBeEmptyGrid(){
		boolean[][] before ={};
		
		 boolean[][] after = {};
		 
		 TetrisGrid tetris = new TetrisGrid(before);
	     tetris.clearRows();

	     assertTrue(Arrays.deepEquals(after, tetris.getGrid()));
	}
	
	@Test
	public void verticalGridShouldNotBeChanged(){
		boolean[][] before ={
				{true, false, true, true ,false}
		};
		
		 boolean[][] after = {
				 {true, false, true, true ,false}
		 };
		 
		 TetrisGrid tetris = new TetrisGrid(before);
	     tetris.clearRows();

	     assertTrue(Arrays.deepEquals(after, tetris.getGrid()));
	}
	
	@Test
	public void testHorizontalGridShouldBeCleared(){
		boolean[][] before ={
				{true},
				{true},
				{true}
		};
		
		 boolean[][] after = {
				 {false},
				 {false},
				 {false}
		 };
		 
		 TetrisGrid tetris = new TetrisGrid(before);
	     tetris.clearRows();

	     assertTrue(Arrays.deepEquals(after, tetris.getGrid()));
	}
	
	@Test
	public void testHorizontalGridShouldNotBeCleared(){
		boolean[][] before ={
				{true},
				{false},
				{true}
		};
		
		 boolean[][] after = {
				 {true},
				 {false},
				 {true}
		 };
		 
		 TetrisGrid tetris = new TetrisGrid(before);
	     tetris.clearRows();

	     assertTrue(Arrays.deepEquals(after, tetris.getGrid()));
	}
	
}
