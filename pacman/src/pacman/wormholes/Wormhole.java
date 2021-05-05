package pacman.wormholes;

import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author renau
 * 
 */
public class Wormhole {
	private DeparturePortal beginportaal;
	private ArrivalPortal eindportaal;
	
	
	public Wormhole(DeparturePortal beginportaal,ArrivalPortal eindportaal) {
		
		
		this.beginportaal = beginportaal;
		this.eindportaal = eindportaal;
		
		beginportaal.addWormhole(this);
		eindportaal.addWormhole(this);
		
		
	}
	
	public DeparturePortal getDeparturePortal() {
		return beginportaal.clone();
	}
	
	public ArrivalPortal getArrivalPortal() {
		return eindportaal.clone();
	}
	
	public void setDeparturePortal(DeparturePortal beginportaal) {
		getDeparturePortal().deleteWormhole(this);
		this.beginportaal = beginportaal.clone();
		getDeparturePortal().addWormhole(this);
	}
	
	public void setArrivalPortal(ArrivalPortal eindportaal) {
		
		getArrivalPortal().deleteWormhole(this);
		this.eindportaal = eindportaal.clone();
		getArrivalPortal().addWormhole(this);
		
	}

}
