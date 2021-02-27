package pacman;

/**
 * Each instance of this class represents the player-controlled Pac-Man character in a Pac-Man maze.
 */
public class PacMan {
	Square vierkant;
	int lives;
	
	public Square getSquare() { 
		return this.vierkant;
	}
	
	public int getNbLives() { 
		return this.lives;
	}

	public PacMan(int nbLives, Square square) {
		this.lives = nbLives;
		this.vierkant = square;
	}
	
	public void setSquare(Square square) { 
		this.vierkant = square;
	}
	
	/**
	 * Decreases this Pac-Man character's number of lives by one.
	 */
	public void die() { 
		int oudelevens = this.lives;
		this.lives = oudelevens-1;
	}

}
