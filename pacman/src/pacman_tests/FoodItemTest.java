package pacman_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pacman.Dot;
import pacman.MazeMap;
import pacman.PowerPellet;
import pacman.Square;

class FoodItemTest {
	MazeMap mapp = new MazeMap(2,2, new boolean[] {true, false, false, true}) ;
	Square vierkant = Square.of(mapp,1,1);
	Square vierkant2 = Square.of(mapp, 0, 1);
	Dot punt = new Dot(vierkant);
	Dot punt2 = new Dot(vierkant2);
	PowerPellet powerpellet = new PowerPellet(vierkant);
	
	
	@Test
	void testGetSquare() {
		assert (punt.getSquare().equals(vierkant));
		assert (punt2.getSquare().equals(vierkant2));
	}

	@Test
	void testDot() {
		
		Square vierkant1 = Square.of(mapp,0,0);
		Dot punt1 = new Dot(vierkant1);
		assert (punt1.getSquare().equals(vierkant1));
	}
	void testGetSize() {
		assert(1== punt.getSize());
		assert(2==powerpellet.getSize());
	}
	void testisPowerPellet() {
		assert powerpellet.isPowerPellet();
		assert !(punt.isPowerPellet());
	}
		

}
