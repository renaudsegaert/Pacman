package pacman.wormholes.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pacman.MazeMap;
import pacman.Square;
import pacman.wormholes.ArrivalPortal;
import pacman.wormholes.DeparturePortal;
import pacman.wormholes.Wormhole;

class WormholeTest {
	MazeMap mapp = new MazeMap(2,2, new boolean[] {true, false, false, true}) ;
	Square vierkant = Square.of(mapp,1,1);
	Square neigbor = Square.of(mapp, 0, 0);
	DeparturePortal beginportaal = new DeparturePortal(vierkant);
	ArrivalPortal eindportaal = new ArrivalPortal(neigbor);
	DeparturePortal beginportaal2 = new DeparturePortal(neigbor);
	ArrivalPortal eindportaal2 = new ArrivalPortal(vierkant);
	Wormhole wormhol = new Wormhole(beginportaal,eindportaal);
	
	@Test
	void testWormhole() {
		assert(true);
		
	}
	void getSquare() {
		assert(beginportaal.getSquare().equals(vierkant));
		assert(eindportaal.getSquare().equals(neigbor));
	}
	void getWormholes() {
		assert(beginportaal.getWormholes().contains(wormhol));
		assert(eindportaal.getWormholes().contains(wormhol));
	}

	@Test
	void testGetDeparturePortal() {
		
		
		assert wormhol.getDeparturePortal()==beginportaal;
	}

	@Test
	void testGetArrivalPortal() {
		
		assert wormhol.getArrivalPortal()==eindportaal;
	}

	@Test
	void testSetPortals() {
		wormhol.setArrivalPortal(eindportaal2);
		wormhol.setDeparturePortal(beginportaal2);
		assert(wormhol.getArrivalPortal()==eindportaal2);
		assert(wormhol.getDeparturePortal()==beginportaal2);
		wormhol.setArrivalPortal(eindportaal2);
		wormhol.setDeparturePortal(beginportaal2);
		assert(wormhol.getArrivalPortal()==eindportaal2);
		assert(wormhol.getDeparturePortal()==beginportaal2);
		wormhol.setArrivalPortal(eindportaal);
		wormhol.setDeparturePortal(beginportaal);
	}



}
