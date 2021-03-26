package pacman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DotTest {
	MazeMap mapp = new MazeMap(2,2, new boolean[] {true, false, false, true}) ;
	Square vierkant = Square.of(mapp,1,1);
	Dot punt = new Dot(vierkant);
	
	@Test
	void testGetSquare() {
		assert (punt.getSquare().equals(vierkant));
	}

	@Test
	void testDot() {
		Square vierkant1 = Square.of(mapp,0,0);
		Dot punt1 = new Dot(vierkant1);
		assert (punt1.getSquare().equals(vierkant1));
	}
	void testGetSize() {
		assert(1== punt.getSize());
	}
		

}
