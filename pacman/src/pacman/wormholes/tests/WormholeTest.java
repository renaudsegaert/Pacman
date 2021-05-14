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
	Wormhole wormhol2 = new Wormhole(beginportaal,eindportaal2);
	@Test
	
	void getSquarefromPortals() {
		assert(beginportaal.getSquare().equals(vierkant));
		assert(eindportaal.getSquare().equals(neigbor));
		assert(beginportaal2.getSquare().equals(neigbor));
		assert(eindportaal2.getSquare().equals(vierkant));
	}
	@Test
	void getWormholesfromPortals() {
		assert(beginportaal.getWormholes().size() == 2);
		assert(eindportaal.getWormholes().size() == 1);
		assert(beginportaal.getWormholes().contains(wormhol));
		assert(eindportaal.getWormholes().contains(wormhol));
	}

	
	@Test
	void testGetPortalsfromWormhole() {
		
		assert wormhol.getArrivalPortal()==eindportaal;
		assert wormhol.getDeparturePortal()==beginportaal;
		assert wormhol2.getArrivalPortal()==eindportaal2;
		assert wormhol2.getDeparturePortal()==beginportaal;
	}

	@Test
	void testSetPortals() {
		wormhol.setArrivalPortal(eindportaal2);
		wormhol.setDeparturePortal(beginportaal2);
		assert(beginportaal2.getWormholes().contains(wormhol));
		assert(eindportaal2.getWormholes().contains(wormhol));
		assert(!beginportaal.getWormholes().contains(wormhol));
		assert(!eindportaal.getWormholes().contains(wormhol));
		assert(beginportaal.getWormholes().size() == 1);
		assert(eindportaal.getWormholes().size() == 0);
		assert(beginportaal2.getWormholes().size() == 1);
		assert(eindportaal2.getWormholes().size() == 2);
		assert(wormhol.getArrivalPortal()==eindportaal2);
		assert(wormhol.getDeparturePortal()==beginportaal2);
		wormhol.setArrivalPortal(eindportaal2);
		wormhol.setDeparturePortal(beginportaal2);
		assert(beginportaal2.getWormholes().contains(wormhol));
		assert(eindportaal2.getWormholes().contains(wormhol));
		assert(!beginportaal.getWormholes().contains(wormhol));
		assert(!eindportaal.getWormholes().contains(wormhol));
		assert(beginportaal.getWormholes().size() == 1);
		assert(eindportaal.getWormholes().size() == 0);
		assert(beginportaal2.getWormholes().size() == 1);
		assert(eindportaal2.getWormholes().size() == 2);
		assert(wormhol.getArrivalPortal()==eindportaal2);
		assert(wormhol.getDeparturePortal()==beginportaal2);
		wormhol.setArrivalPortal(eindportaal);
		wormhol.setDeparturePortal(beginportaal);
		assert(!beginportaal2.getWormholes().contains(wormhol));
		assert(!eindportaal2.getWormholes().contains(wormhol));
		assert(beginportaal.getWormholes().contains(wormhol));
		assert(eindportaal.getWormholes().contains(wormhol));
		assert(beginportaal.getWormholes().size() == 2);
		assert(eindportaal.getWormholes().size() == 1);
		assert(beginportaal2.getWormholes().size() == 0);
		assert(eindportaal2.getWormholes().size() == 1);
		assert(wormhol.getArrivalPortal()==eindportaal);
		assert(wormhol.getDeparturePortal()==beginportaal);
	}



}
