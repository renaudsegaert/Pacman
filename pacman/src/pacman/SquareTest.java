package pacman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SquareTest {
	MazeMap mapp = new MazeMap(2,2, new boolean[] {true, false, false, true}) ;
	Square vierkant = Square.of(mapp,1,1);
	Square neigbor = Square.of(mapp, 1, 0);
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
		assert (vierkant.getColumnIndex()==1);
	}

	@Test
	void testIsPassable() {
		assert vierkant.isPassable();
	}

	@Test
	void testOf() {
		fail("Not yet implemented");
	}

	@Test
	void testGetNeighbor() {
		  
		Square neigbor1 = vierkant.getNeighbor(Direction.LEFT);
		assert ( neigbor1.getRowIndex() == neigbor.getRowIndex());
		assert ( neigbor1.getColumnIndex() == neigbor.getColumnIndex());
		assert ( neigbor1.getMazeMap() == neigbor.getMazeMap());
		
	}

	@Test
	void testCanMove() {
		
		assert (!(vierkant.canMove(Direction.UP) ) );
		
	}

	@Test
	void testGetPassableDirectionsExcept() {
		System.out.println(neigbor.getPassableDirectionsExcept(Direction.DOWN).length);
	}

	@Test
	void testEqualsSquare() {
		fail("Not yet implemented");
	}

}
