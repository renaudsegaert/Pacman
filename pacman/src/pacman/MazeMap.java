package pacman;

import java.util.Arrays;

/**
 * Each instance of this class represents a maze layout, specifying the width and height of the maze
 * and, for each position in the maze, whether it is passable or not.
 * @immutable
 */
public class MazeMap {
	/**
	 * 
	 * 
	 * @invar | 1 <= width
	 * @invar | 1 <= height
	 * @invar | Arrays.stream(maze).allMatch(row -> row != null && row.length == width && 1 <= row.length )  
	 * 
	 */
	private int width; 
	private int height;
	private boolean[][] maze;
	
	/**
	 * Returns the width (i.e. the number of columns) of this maze map.

	 * @post | result >0
	 */
	public int getWidth() { 
		return this.width;
	}
	/**
	 * Returns the height (i.e. the number of rows) of this maze map.
	 * @post | result >0
	 */
	public int getHeight() { 
		return this.height;
	}
	/**
	 * Returns whether the square in this maze at row index {@code row} and column index {@code column} is passable.
	 * The square in the top-left corner of the maze has row index 0 and column index 0.
	 * 
	 * @throws IllegalArgumentException | rowIndex < 0
	 * @throws IllegalArgumentException | columnIndex < 0
	 * @throws IllegalArgumentException | rowIndex >= getHeight()
	 * @throws IllegalArgumentException | columnIndex >= getWidth()
	 * 
	 * 
	 * 
	 */
	public boolean isPassable(int rowIndex, int columnIndex) {
		if (rowIndex<0) {
			throw new IllegalArgumentException("rowIndex has to be a positive Integer!");
		}
		if (rowIndex>=getHeight()) {
			throw new IllegalArgumentException("rowIndex has to be less then the height of the mazemap!");
		}
		if (columnIndex <0) {
			throw new IllegalArgumentException("columnIndex has to be a positive Integer!");
		}
			
		if (columnIndex>=getWidth()) {
			throw new IllegalArgumentException("columnIndex has to be less then the width of the mazemap!");
		}
		
			
		return this.maze[rowIndex][columnIndex];
	}
	
	/**
	 * Initializes this object so that it represents a maze layout with the given width, height, and
	 * passable positions. The passable positions are given in row-major order (i.e. the first {@code width} elements
	 * of {@code passable} specify the passability of the maze positions in the first row of the maze). 
	 * 
	 * @throws IllegalArgumentException | width < 1
	 * @throws IllegalArgumentException | height < 1
	 * @throws IllegalArgumentException | passable == null
	 * @throws IllegalArgumentException | passable.length != width * height
	 * 
	 * @post | getHeight() == height
	 * @post | getWidth() == width
	 * 
	 */
	public MazeMap(int width, int height, boolean[] passable) {
		if (width <1) {
			throw new IllegalArgumentException("width has to be a positve integer!");
		}
		if (height<1) {
			throw new IllegalArgumentException("height has to be a positive integer!");
		}
		if (passable == null) {
			throw new IllegalArgumentException("passable can't be null");
		}
		if (passable.length != width*height) {
			throw new IllegalArgumentException("length of passable has to be the product of width and height!");
		}
		
		
		
		this.width = width;
		this.height = height;
		
		boolean[][] doolhof = new boolean[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				doolhof[i][j] = passable[(width*i)+j];
		this.maze = doolhof;		
			}
			
		}
	}
}
