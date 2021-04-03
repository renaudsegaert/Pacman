package pacman;

/**
 * Each instance of this class represents a dot (a piece of food for Pac-Man) in a Pac-Man maze.
 */
public class Dot extends FoodItem{
	static int relativesize = 1;
	
	
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
		return relativesize;
	}

	@Override
	public boolean isPowerPellet() {
		
		return false;
	}

	@Override
	public void eatenbypacman(Maze maze) {
		
		
		
	}

}
