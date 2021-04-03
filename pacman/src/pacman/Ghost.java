package pacman;

import java.util.Random;

/**
 * Each instance of this class represents a ghost in a Pac-Man maze.
 */
public class Ghost {
	private Square vierkant;
	private Direction richting;
	private GhostState ghoststate = new RegularGhostState();
	private Square ogvierkant;
	
	
	
	public Square getSquare() { 
		return this.vierkant;
	}
	
	
	public GhostState getGhostState() {
		return ghoststate;
	}
	public boolean isVulnerable() {
		return getGhostState().getVulnerable();
	}
	/**
	 * Returns the direction in which this ghost will preferably move next.
	 * 
	 */
	public Direction getDirection() { 
		return this.richting;
	}
	/**
	 * 
	 * @param square
	 * @param direction
	 * 
	 * @post |getSquare() == square
	 * @post |getDirection()== direction
	 */
	public Ghost(Square square, Direction direction) { 
		this.vierkant = square;
		this.richting = direction;
		
		this.ogvierkant = square;
	}
	/**
	 * 
	 * @param square
	 * 
	 * @post | getSquare() ==square
	 * @post | getDirection() == old(getDirection())
	 */
	
	public void setSquare(Square square) { 
		this.vierkant = square;
	}
	public void setOGSquare() {
		this.vierkant = ogvierkant;
	}
	/**
	 * 
	 * @param direction
	 * 
	 * @post | getDirection() == direction
	 * @post | getSquare() == old(getSquare())
	 */
	public void setDirection(Direction direction) { 
		this.richting = direction;
	}
	public void setStateVulnerable() {
		this.ghoststate = new VulnerableGhostState();
	}
	public void setStateRegular() {
		this.ghoststate = new RegularGhostState();
	}
	public void setState(GhostState ghoststate) {
		this.ghoststate = ghoststate;
	}
	
	public void pacManAtePowerPellet() {
		this.setDirection(getDirection().getOpposite());
		this.setStateVulnerable();
		
	}
	
	private static int MOVE_FORWARD_PREFERENCE = 10;
	
	// No formal document required
	public Direction chooseNextMoveDirection(Random random) {
		int moveForwardPreference = getSquare().canMove(getDirection()) ? MOVE_FORWARD_PREFERENCE : 0;
		Direction[] passableDirections = getSquare().getPassableDirectionsExcept(getDirection().getOpposite());
		if (passableDirections.length == 0)
			return getDirection().getOpposite();
		int result = random.nextInt(moveForwardPreference + passableDirections.length);
		if (result < moveForwardPreference)
			return getDirection();
		return passableDirections[result - moveForwardPreference];
	}
	
	// No formal document required
	public void reallyMove(Random random) {
		setDirection(chooseNextMoveDirection(random));
		setSquare(getSquare().getNeighbor(getDirection()));
	}
	
	public void move(Random random) {
		
		setState(getGhostState().move(this,random));
	}
	
	public void hitBy(PacMan pacMan) {

		setState(getGhostState().hitBy(this, pacMan));
	}
}
