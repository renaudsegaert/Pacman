package pacman_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pacman.MazeMap;

class MazeMapTest {
	boolean[] cars = {true, false, false,true};
	MazeMap appel = new MazeMap(2,2,  cars  );
	@Test
	void testGetWidth() {
		assert (appel.getWidth()==2);
				
		
		
	}

	@Test
	void testGetHeight() {
		assert (appel.getHeight()==2);
	}

	@Test
	void testIsPassable() {
		assert ( appel.isPassable(1, 1) == true );
	}

	

}
