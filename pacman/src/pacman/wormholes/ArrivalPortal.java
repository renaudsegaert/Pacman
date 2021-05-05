package pacman.wormholes;

import java.util.HashSet;
import java.util.Set;

import pacman.Square;
/**
 * 
 * @author renaud en josse :)
 * @invar| getSquare() != null
 * @invar| getSquare().isPassable()
 * @invar| getWormholes() != null
 * @invar| getWormholes().stream().allMatch(w-> w!=null && w.getArrivalPortal()==this)
 * 
 */
public class ArrivalPortal {
	/**
	 * @representationObject
	 * @invar | vierkant!=null
	 * @invar | vierkant.isPassable()
	 * 
	 */
	private Square vierkant;
	/**
	 * @peerObjects
	 * @invar | wormhollen !=null
	 * @invar | wormhollen.stream().allMatch(w-> w!=null && w.getArrivalPortal()==this)
	 */
	private Set<Wormhole> wormhollen  = new HashSet<Wormhole>();
	
	/**
	 * @param vierkant
	 * @throws IllegalArgumentException | !vierkant.isPassable()
	 * @throws IllegalArgumentException | vierkant==null
	 * @param vierkant1
	 * @post | getSquare() == vierkant
	 * @post | getWormholes().size()==0
	 * @mutates | this
	 * 
	 */
	public ArrivalPortal(Square vierkant) {
		if (vierkant==null) {
			throw new IllegalArgumentException("vierkant is null!");
		}
		
		if (!vierkant.isPassable()){
			throw new IllegalArgumentException("vierkant is niet passable!");
		}
		
		this.vierkant = vierkant;
	}
	/**
	 * @post | result != null
	 * @post | result.isPassable()
	 * @immutable
	 * @basic
	 */
	public Square getSquare() {
		return vierkant;
	}
	/**
	 * 
	 * @creates | result
	 * @post | result != null
	 * @post | result.stream().allMatch(w-> w!=null )
	 * @post | result.stream().allMatch(w-> w.getArrivalPortal()==this)
	 * @peerobjects
	 * @basic
	 */
	public Set<Wormhole> getWormholes(){
		return Set.copyOf(wormhollen);
	}
	
	/**
	 * 
	 * @throws IllegalArgumentException | wormhol == null
	 * @param wormhol
	 * 
	 * @mutates | this
	 * @mutates_properties getWormholes()
	 * 
	 * @post | old(getSquare()).equals(getSquare())
	 * @post  getWormholes().equals(LogicalSet.plus(old(getWormholes()),wormhol))
	 * 
	 */
	void addWormhole(Wormhole wormhol) {
		
		if (wormhol==null) {
			throw new IllegalArgumentException("wormhol is null en dat mag nu eenmaal niet in deze functie :(");
		}
		wormhollen.add(wormhol);
		
	}
	/**
	 * @throws IllegalArgumentException | wormhol == null
	 * @throws IllegalArgumentException | !getWormholes().contains(wormhol)
	 * @param wormhol
	 * 
	 * @mutates | this
	 * @mutates_properties getWormholes()
	 * 
	 * @post | old(getSquare()).equals(getSquare())
	 * @post  getWormholes().equals(LogicalSet.minus(old(getWormholes()),wormhol))
	 
	 */
	void deleteWormhole(Wormhole wormhol) {
		if (wormhol==null) {
			throw new IllegalArgumentException("wormhol is null en dat mag nu eenmaal niet in deze functie :(");
		}
		if (!getWormholes().contains(wormhol)) {
			throw new IllegalArgumentException("wormhol is nog niet toegevoegd aan dit arrivalportaal en kan dus niet verwijderd worden");
		}
		wormhollen.remove(wormhol);
	}
	public ArrivalPortal clone() {
		
		return this;
	}
}
