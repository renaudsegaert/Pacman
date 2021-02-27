package pacman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SquareTest {
	MazeMap mapp = new MazeMap(2,2, new boolean[] {true, true, true, true}) ;
	Square vierkant = Square.of(mapp,1,1);
	@Test
	void testGetMazeMap() {

		
		assert (vierkant.getMazeMap() != mapp);
		
		
		
	}

	@Test
	void testGetRowIndex() {
		assert (vierkant.getRowIndex()==1);
	}

	@Test
	void testGetColumnIndex() {
		fail("Not yet implemented");
	}

	@Test
	void testIsPassable() {
		fail("Not yet implemented");
	}

	@Test
	void testOf() {
		fail("Not yet implemented");
	}

	@Test
	void testGetNeighbor() {
		fail("Not yet implemented");
	}

	@Test
	void testCanMove() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPassableDirectionsExcept() {
		fail("Not yet implemented");
	}

	@Test
	void testEqualsSquare() {
		fail("Not yet implemented");
	}

}
