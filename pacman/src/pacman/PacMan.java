package pacman;

/**
 * Each instance of this class represents the player-controlled Pac-Man character in a Pac-Man maze.
 * 
 * @invar | getNbLives() >= 0
 */
public class PacMan {
	/**
	 * @invar | lives >=0
	 * 
	 * 
	 */
	private Square vierkant;
	private int lives;
	
	public Square getSquare() { 
		return this.vierkant;
	}
	
	public int getNbLives() { 
		return this.lives;
	}
	/**
	 * 
	 * @param nbLives
	 * @param square
	 * 
	 * @post| getSquare()==square
	 * @post| getNbLives() == nbLives
	 * 
	 */
	public PacMan(int nbLives, Square square) {
		this.lives = nbLives;
		this.vierkant = square;
	}
	/**
	 * 
	 * @param square
	 * 
	 * @post | getSquare() == square
	 * @post | getNbLives() == old(getNbLives())
	 * 
	 */
	public void setSquare(Square square) { 
		this.vierkant = square;
	}
	
	/**
	 * Decreases this Pac-Man character's number of lives by one.
	 * @throws IllegalArgumentException | getNbLives()<=0
	 * 
	 * @post | getNbLives() == old(getNbLives()-1)
	 * 
	 * @mutates | this
	 * 
	 * 
	 */
	public void die() { 
		if ( getNbLives()<=0) {
			throw new IllegalArgumentException("levens zijn al te weinig");
			
		}
		
			int oudelevens = this.lives;
		
		this.lives = oudelevens-1;
	}

}
