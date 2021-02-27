package pacman;

import java.util.Random;

/**
 * Each instance of this class represents a ghost in a Pac-Man maze.
 */
public class Ghost {
	Square vierkant;
	Direction richting;
	
	public Square getSquare() { 
		return this.vierkant;
	}
	
	/**
	 * Returns the direction in which this ghost will preferably move next.
	 */
	public Direction getDirection() { 
		return this.richting;
	}
	
	public Ghost(Square square, Direction direction) { 
		this.vierkant = square;
		this.richting = direction;
	}
	
	public void setSquare(Square square) { 
		this.vierkant = square;
	}
	
	public void setDirection(Direction direction) { 
		this.richting = direction;
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
	public void move(Random random) {
		setDirection(chooseNextMoveDirection(random));
		setSquare(getSquare().getNeighbor(getDirection()));
	}
}
