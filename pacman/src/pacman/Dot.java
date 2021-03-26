package pacman;

/**
 * Each instance of this class represents a dot (a piece of food for Pac-Man) in a Pac-Man maze.
 */
public class Dot extends FoodItem{
	static int size = 1;
	
	
	/**
	 * 
	 * @param square
	 * 
	 * @post | getSquare() == square
	 */
	public Dot(Square square) { 
		super(square);
		
		
	}
	
	public int getSize() {
		return size;
	}

}
