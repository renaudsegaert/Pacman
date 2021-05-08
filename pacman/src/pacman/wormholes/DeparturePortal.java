package pacman.wormholes;

import java.util.HashSet;
import java.util.Set;
import logicalcollections.LogicalSet;
import pacman.Square;
/**
 * 
 * @author renaud en josse :)
 * @invar | getSquare() != null
 * @invar | getSquare().isPassable()
 * @invar | getWormholes() != null
 * @invar | getWormholes().stream().allMatch(w-> w!=null && w.getDeparturePortal()==this)
 * 
 * 
 */
public class DeparturePortal {
	/**
	 * 
	 * @invar | vierkant!=null
	 * @invar | vierkant.isPassable()
	 * @immutable
	 */
	private final Square vierkant;
	/**
	 * @representationobject
	 * @invar | wormhollen !=null
	 * @invar | wormhollen.stream().allMatch(w-> w!=null)
	 * @invar | wormhollen.stream().allMatch(w->w.getDeparturePortal()==this)
	 */
	private Set<Wormhole> wormhollen = new HashSet<Wormhole>();
	
	
	/**
	 * @param vierkant
	 * @throws IllegalArgumentException | !vierkant.isPassable()
	 * @throws IllegalArgumentException | vierkant==null
	 * 
	 * @post | getSquare() == vierkant
	 * @post | getWormholes().size()==0
	 * @mutates | this
	 * 
	 */
	public DeparturePortal(Square vierkant) {
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
	 * @post | result.stream().allMatch(w-> w.getDeparturePortal()==this)
	 * @peerobjects
	 * @basic
	 */
	public Set<Wormhole> getWormholes(){
		return wormhollen;
	}
	/**
	 * 
	 * @throws IllegalArgumentException | wormhol == null
	 * @throws IllegalArgumentException | wormhol.getDeparturePortal()!=this
	 * @param wormhol
	 * 
	 * 
	 * @mutates_properties getWormholes()
	 * 
	 * @post | old(getSquare()).equals(getSquare())
	 * @post | getWormholes().equals(LogicalSet.plus(old(getWormholes()),wormhol))
	 * 
	 */
	void addWormhole(Wormhole wormhol) {
		if (wormhol==null) {
			throw new IllegalArgumentException("wormhol is null");
		}
		if (wormhol.getDeparturePortal()!=this) {
			throw new IllegalArgumentException("wormhol heeft dit departure portal niet als departureportal");
		}
		wormhollen.add(wormhol);
	}
	/**
	 * @throws IllegalArgumentException | wormhol == null
	 * @throws IllegalArgumentException | !getWormholes().contains(wormhol)
	 * @param wormhol
	 * 
	 *
	 * @mutates_properties getWormholes()
	 * 
	 * @post | old(getSquare()).equals(getSquare())
	 * @post | getWormholes().equals(LogicalSet.minus(old(getWormholes()),wormhol))
	 
	 */
	void deleteWormhole(Wormhole wormhol) {
		if (wormhol==null) {
			throw new IllegalArgumentException("wormhol is null!!");
		}
		if (!getWormholes().contains(wormhol)) {
			throw new IllegalArgumentException("wormhol is nog niet toegevoegd aan dit arrivalportaal en kan dus niet verwijderd worden");
		}
		wormhollen.remove(wormhol);
	}
	
	
}
