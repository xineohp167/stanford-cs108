// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

package assign1;

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid. Does not make a copy.
	 * 
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}

	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * 
	 * @param ch
	 *            char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		boolean found = false;
		int maxCol = 0;
		int maxRow = 0;
		int minRow = grid.length;
		int minCol = minRow > 0 ? grid[0].length : 0;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				if (grid[row][col] == ch) {
					found = true;
					if (minRow > row)
						minRow = row;
					if (minCol > col)
						minCol = col;
					maxRow = row + 1;
					maxCol = col + 1;
				}
			}
		}
		if (found) {
			return (maxRow - minRow) * (maxCol - minCol);
		}
		return 0;
	}

	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * 
	 * @return number of + in grid
	 */
	public int countPlus() {
		int numOfPlus = 0;

		for (int row = 0; row < grid.length; row++)
			for (int col = 0; col < grid[0].length; col++)
				if (isValidPlus(row, col))
					numOfPlus++;

		return numOfPlus;
	}

	private boolean isValidPlus(int row, int col) {
		int left = nCharsInDirection(row, col, 0, -1);
		int right = nCharsInDirection(row, col, 0, 1);
		int down = nCharsInDirection(row, col, -1, 0);
		int up = nCharsInDirection(row, col, 1, 0);

		return left != 0 && left == right && left == up && left == down;
	}

	private int nCharsInDirection(int row, int col, int shiftRow, int shiftCol) {
		int nextRow = row + shiftRow;
		int nextCol = col + shiftCol;

		if (isValidCell(nextRow, nextCol)
				&& grid[row][col] == grid[nextRow][nextCol])
			return 1 + nCharsInDirection(nextRow, nextCol, shiftRow, shiftCol);
		else
			return 0;
	}

	private boolean isValidCell(int row, int col) {
		return row < grid.length && grid.length > 0 && col < grid[0].length
				&& col >= 0 && row >= 0;
	}

}
