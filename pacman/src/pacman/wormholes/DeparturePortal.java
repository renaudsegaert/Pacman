package pacman.wormholes;

import java.util.HashSet;
import java.util.Set;

import pacman.Square;

public class DeparturePortal {
	private Square vierkant;
	
	private Set<Wormhole> wormhollen = new HashSet<Wormhole>();
	
	
	/*
	 * 
	 * @param vierkant1
	 * @post | getSquare() == vierkant
	 * 
	 */
	public DeparturePortal(Square vierkant) {
		this.vierkant = vierkant;
	}
	/*
	 * @post | result != null
	 * @post | old(getSquare())==getSquare()
	 * @immutable
	 */
	public Square getSquare() {
		return vierkant;
	}
	public Set<Wormhole> getWormholes(){
		return wormhollen;
	}
	void addWormhole(Wormhole wormhol) {
		wormhollen.add(wormhol);
	}
	void deleteWormhole(Wormhole wormhol) {
		wormhollen.remove(wormhol);
	}
	public DeparturePortal clone() {
		return this;
	}
}
