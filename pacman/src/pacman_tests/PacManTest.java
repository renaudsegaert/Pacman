package pacman_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pacman.MazeMap;
import pacman.PacMan;
import pacman.Square;

class PacManTest {
	MazeMap mapp = new MazeMap(2,2, new boolean[] {true, false, false, true}) ;
	Square vierkant = Square.of(mapp,1,1);
	Square vierkant1 = Square.of(mapp, 0, 0);
	PacMan pak = new PacMan(3,vierkant);
	@Test
	void testGetSquare() {
		assert( pak.getSquare().equals(vierkant));
	}

	@Test
	void testGetNbLives() {
		assert (pak.getNbLives()==3);
	}

	@Test
	void testSetSquare() {
		pak.setSquare(vierkant1);
		assert (pak.getSquare().equals(vierkant1));
	}

	@Test
	void testDie() {
		pak.die();
		assert (pak.getNbLives()==2);
	}

}
