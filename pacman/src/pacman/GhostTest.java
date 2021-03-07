package pacman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GhostTest {
	MazeMap mapp = new MazeMap(2,2, new boolean[] {true, false, false, true}) ;
	Square vierkant = Square.of(mapp,1,1);
	Square vierkant1 = Square.of(mapp, 0, 0);
	Ghost geest = new Ghost(vierkant,Direction.UP);
	@Test
	void testGetSquare() {
		assert (geest.getSquare().equals(vierkant));
	}

	@Test
	void testGetDirection() {
		assert (geest.getDirection()==Direction.UP);
	}

	//miss nog constructor teste

	@Test
	void testSetSquare() {
		geest.setSquare(vierkant1);
		assert (geest.getSquare().equals(vierkant1));
	}

	@Test
	void testSetDirection() {
		geest.setDirection(Direction.DOWN);
		assert (geest.getDirection() == Direction.DOWN);
	}

}
