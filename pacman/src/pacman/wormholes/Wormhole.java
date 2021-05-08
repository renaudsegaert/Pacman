package pacman.wormholes;

import java.util.HashSet;
import java.util.Set;
import logicalcollections.LogicalSet;
/**
 * 
 * @author renaud en josse
 * 
 * @invar | getDeparturePortal()!=null
 * @invar  getDeparturePortal().getWormholes().contains(this)
 * @invar | getArrivalPortal()!=null
 * @invar  getArrivalPortal().getWormholes().contains(this)
 * 
 */
public class Wormhole {
	/**
	 * @peerobject
	 * @invar |  beginportaal!=null
	 * 
	 * 
	 */
	private DeparturePortal beginportaal;
	/**
	 * @peerobject
	 * @invar | eindportaal!=null
	 * 
	 */
	private ArrivalPortal eindportaal;
	
	/**
	 * 
	 * @throws IllegalArgumentException | beginportaal==null
	 * @throws IllegalArgumentException | eindportaal==null
	 * 
	 * @param beginportaal
	 * @param eindportaal
	 * 
	 * @mutates_properties | beginportaal.getWormholes()
	 * @mutates_properties | eindportaal.getWormholes()
	 * @mutates_properties | getArrivalPortal()
	 * @mutates_properties | getDeparturePortal()
	 * 
	 * 
	 * @post | getDeparturePortal() == beginportaal
	 * @post | getArrivalPortal()== eindportaal
	 * @post | beginportaal.getWormholes().equals(LogicalSet.plus(old(beginportaal.getWormholes()),this))
	 * @post | eindportaal.getWormholes().equals(LogicalSet.plus(old(eindportaal.getWormholes()),this))
	 */
	public Wormhole(DeparturePortal beginportaal,ArrivalPortal eindportaal) {
		if (beginportaal ==null) {
			throw new IllegalArgumentException("beginportaal is null");
		}
		if (eindportaal ==null) {
			throw new IllegalArgumentException("eindportaal is null");
		}
		
		this.beginportaal = beginportaal;
		this.eindportaal = eindportaal;
		
		beginportaal.addWormhole(this);
		eindportaal.addWormhole(this);
		
		
	}
	/**
	 *  
	 * @post | result != null
	 * @basic
	 */
	public DeparturePortal getDeparturePortal() {
		return beginportaal;
	}
	/**
	 *  
	 * @post | result != null
	 * @basic
	 * 
	 */
	public ArrivalPortal getArrivalPortal() {
		return eindportaal;
	}
	/**
	 *
	 * @throws IllegalArgumentException | beginportaal ==null
	 * 
	 * @post | (old(getDeparturePortal()).getWormholes().equals(LogicalSet.minus(old(getDeparturePortal().getWormholes()),this))
	 * 		 | &&   beginportaal.getWormholes().equals(LogicalSet.plus(old(beginportaal.getWormholes()),this)) ) 
	 * 		 | || (old(getDeparturePortal())==beginportaal && old(getDeparturePortal().getWormholes()).equals(
	 * 		 |							getDeparturePortal().getWormholes()))
	 * 
	 * @post | old(getArrivalPortal())==getArrivalPortal()
	 * 
	 * @post | getDeparturePortal()==beginportaal
	 * 
	 * @mutates_properties | getDeparturePortal().getWormholes()
	 * @mutates_properties | beginportaal.getWormholes()
	 * @mutates_properties | getDeparturePortal()
	 * 
	 * 
	 * 
	 * 
	 * @param beginportaal
	 */
	public void setDeparturePortal(DeparturePortal beginportaal) {
		if (beginportaal == null) {
			throw new IllegalArgumentException("beginportaal is null");
		}
		getDeparturePortal().deleteWormhole(this);
		this.beginportaal = beginportaal;
		beginportaal.addWormhole(this);
	}
	/**
	 * @throws IllegalArgumentException | eindportaal ==null
	 * 
	 * @post | (old(getArrivalPortal().getWormholes()).equals(LogicalSet.plus(old(getArrivalPortal()).getWormholes(),this))
	 * 		 | && eindportaal.getWormholes().equals(LogicalSet.plus(old(eindportaal.getWormholes()),this)))
	 * 		 | || (old(getArrivalPortal())==eindportaal && old(getArrivalPortal().getWormholes()).equals(
	 * 		 |							eindportaal.getWormholes()))
	 * 
	 * @post | old(getDeparturePortal())==getDeparturePortal()
	 * 
	 * @post | getArrivalPortal()==eindportaal
	 * 
	 * @mutates_properties | getArrivalPortal().getWormholes()
	 * @mutates_properties | eindportaal.getWormholes()
	 * @mutates_properties | getArrivalPortal()
	 * 
	 * 
	 * 
	 * 
	 * @param eindportaal
	 */
	public void setArrivalPortal(ArrivalPortal eindportaal) {
		if (eindportaal == null) {
			throw new IllegalArgumentException("eindportaal is null");
		}
		
		
		getArrivalPortal().deleteWormhole(this);
		
		this.eindportaal = eindportaal;
		eindportaal.addWormhole(this);
		
		
	}

}
