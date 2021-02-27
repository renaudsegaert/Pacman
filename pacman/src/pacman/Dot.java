package pacman;

/**
 * Each instance of this class represents a dot (a piece of food for Pac-Man) in a Pac-Man maze.
 */
public class Dot {
	private Square vierkant;
	
	public Square getSquare() { 
		return this.vierkant;
	}
	
	public Dot(Square square) { 
		this.vierkant = square;
	}

}
