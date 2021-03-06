package pacman;

import java.util.Arrays;

/**
 * Each instance of this class represents a position in a maze, specified by a row index and a column index.
 * The top row and the leftmost column have index 0.
 * 
 * @immutable
 * 
 */
public class Square {
	
	/**
	 * rijen moeten index 0 of meer hebben en kleiner zijn dan de hoogte van de map
	 * kolommen moeten index 0 of meer hebben en kleiner zijn dan de breedte van de map
	 * 
	 * @invar	| 0 <= row && row <= map.getHeight()
	 * @invar | 0 <= column && column <= map.getWidth()
	 * 
	 */
	private MazeMap map;
	private int row;
	private int column;
	
	/*
	 * @basic
	 */
	
	public MazeMap getMazeMap() { 
		return this.map;
		
	}
	
	/*
	 * @basic
	 */
	
	public int getRowIndex() { 
		return this.row;
		
	}
	
	/*
	 * @basic
	 */
	
	public int getColumnIndex() { 
		return this.column;
	}
	
	public boolean isPassable() { 
		return this.map.isPassable(this.row,this.column);
	}
	
	/*
	 * mazeMap, rowIndex en columnIndex moeten juiste waarden hebben.
	 * 
	 * @pre	| 0 <= columnIndex && columnIndex <= mazemap.width
	 * @pre	| 0 <= rowIndex && rowIndex <= mazeMap.height
	 * 
	 * @post | vierkant.row == getRowIndex()
	 * @post | vierkant.column == getColumnIndex()
	 * 
	 */
	
	public static Square of(MazeMap mazeMap, int rowIndex, int columnIndex) {
		
		Square vierkant = new Square();
		vierkant.map = mazeMap;
		vierkant.row = rowIndex;
		vierkant.column = columnIndex;
		return vierkant;
	}
	
	/**
	 * Returns this square's neighbor in the given direction.
	 * If this square has no neigbor in the given direction, return the square that is furthest away in the opposite direction.
	 */
	// No formal documentation required
	public Square getNeighbor(Direction direction) {
		// Implementation hint: use method java.lang.Math.floorMod.
		
		
		MazeMap mapp = this.getMazeMap();
		
		int breedte = mapp.getWidth();
		int hoogte = mapp.getHeight();
		int roww = getRowIndex();
		int ogcolumn = getColumnIndex();
		int newrow;
		int newcolumn;
		
		if (direction == Direction.LEFT) {
			 newrow = roww;
			
			if (ogcolumn == 0) {
				 newcolumn = breedte-1;
			}else {
				 newcolumn = ogcolumn-1;
				
			}
		}
		else if (direction == Direction.RIGHT) {
			 newrow = roww;
			
			if (ogcolumn == breedte-1) {
				 newcolumn = 0;
			}else {
				 newcolumn = ogcolumn+1;
				
			}
		}
		else if (direction == Direction.UP) {
			
			 newcolumn = ogcolumn;
			if (roww == 0) {
				 newrow = hoogte-1 ;
			}else {
				 newrow = roww-1;
				
			}
			
		}
		else if (direction == Direction.DOWN) {
			
			 newcolumn = ogcolumn;
			if (roww == hoogte-1) {
				 newrow = 0 ;
			}else {
				 newrow = roww+1;
				
			}
			
			
			
		}
		else {
			throw new IllegalArgumentException("the direction is not one of the possible directions");
		}
		
		
		Square newvierkant = of(mapp, newrow, newcolumn);
		
		return newvierkant;
		
	}

	/**
	 * Returns whether this square's neighbor in the given direction is passable.
	 */
	// No formal documentation required
	public boolean canMove(Direction direction) {
		
		Square neighbor = getNeighbor(direction);
		return neighbor.isPassable();
	}

	/**
	 * Returns the directions that are different from the given excluded direction and such that the neighbor in that direction is passable.
	 * The returned array shall have no null elements and shall have no duplicates.
	 */
	// No formal documentation required
	public Direction[] getPassableDirectionsExcept(Direction excludedDirection) {
		int counter = 0 ;
		Direction[] richtingen = new Direction[4];
		
		if ((canMove(Direction.UP)) && (excludedDirection != Direction.UP)){
			richtingen[0] = Direction.UP;
			counter++;
		}
		if ((canMove(Direction.DOWN)) && (excludedDirection != Direction.DOWN)){
			richtingen[1] = Direction.DOWN;
			counter++;
		}
		if ((canMove(Direction.LEFT)) && (excludedDirection != Direction.LEFT)){
			richtingen[2] = Direction.LEFT;
			counter++;
		}
		if ((canMove(Direction.RIGHT)) && (excludedDirection != Direction.RIGHT)){
			richtingen[3] = Direction.RIGHT;
			counter++;
		}
		
		Direction[] eindrichtingen = new Direction[counter];
		int telding = 0;
			for (int i=0 ; i<4; i++)
				if (richtingen[i] != null) {
					eindrichtingen[i-telding] = richtingen[i];
					
					
				}else {
					telding++;
				}
		
		
		return eindrichtingen;
		
	}
	
	/**
	 * Returns whether the given square refers to the same {@code MazeMap} object and has the same row and column index as this square.  
	 * 
	 * @pre | other != null
	 * @pre | other.getRowIndex() == getRowIndex()
	 * @pre | other.getColumnIndex() == getColumnIndex()
	 * 
	 * @post | getRowIndex() == old(getRowIndex())
	 * @post | getColumnIndex() == old(getColumnIndex())
	 * @post | getMazeMap() == old(getMazeMap())
	 * 
	 */
	public boolean equals(Square other) {
		if(( this.getMazeMap() == other.getMazeMap()) && (this.getRowIndex() == other.getRowIndex()) && ( this.getColumnIndex()== other.getColumnIndex())) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
}
