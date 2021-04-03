package pacman_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pacman.Direction;
import pacman.Ghost;
import pacman.MazeMap;
import pacman.RegularGhostState;
import pacman.VulnerableGhostState;
import pacman.Square;

class GhostTest {
	MazeMap mapp = new MazeMap(2,2, new boolean[] {true, false, false, true}) ;
	Square vierkant = Square.of(mapp,1,1);
	Square vierkant1 = Square.of(mapp, 0, 0);
	Ghost geest = new Ghost(vierkant,Direction.UP);
	Ghost geest1 = new Ghost(vierkant1,Direction.DOWN);
	
	@Test
	void testGetSquare() {
		assert (geest.getSquare().equals(vierkant));
		assert (geest1.getSquare().equals(vierkant1));
	}
	void testGetGhostState() {
		assert geest.getGhostState() instanceof RegularGhostState;
		geest1.setStateVulnerable();
		assert geest1.getGhostState() instanceof VulnerableGhostState;
		geest1.setStateRegular();
	}
	void testIsVulnerable() {
		assert !geest.isVulnerable();
		geest1.setStateVulnerable();
		assert geest1.isVulnerable();
		geest1.setStateRegular();
	}
	@Test
	void testGetDirection() {
		assert (geest.getDirection()==Direction.UP);
		assert (geest1.getDirection()==Direction.DOWN);
	}

	//miss nog constructor teste

	@Test
	void testSetSquare() {
		geest.setSquare(vierkant1);
		assert (geest.getSquare().equals(vierkant1));
		geest.setSquare(vierkant);
		geest1.setSquare(vierkant);
		assert geest1.getSquare().equals(vierkant);
		geest1.setSquare(vierkant1);
	}

	@Test
	void testSetDirection() {
		geest.setDirection(Direction.DOWN);
		assert (geest.getDirection() == Direction.DOWN);
	}
	
	
	
	void testpacManAtePowerPellet() {
		assert(geest.getDirection()==Direction.UP);
		geest.pacManAtePowerPellet();
		assert(geest.getDirection()==Direction.DOWN);
		assert(geest.isVulnerable());
		geest1.pacManAtePowerPellet();
		assert(geest1.getDirection()==Direction.UP);
		assert(geest1.isVulnerable());
		
	}
}
