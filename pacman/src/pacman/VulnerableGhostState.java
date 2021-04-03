package pacman;

import java.util.Random;

public class VulnerableGhostState extends GhostState{
	int nbmoves=0;
	
	public VulnerableGhostState() {
		
		movedelay = 1;
		
		
	}

	@Override
	public GhostState move(Ghost ghost, Random random) {
		
		
		if (getDelay()==1){
			
			this.movedelay =0;
			return this;
			
		}
		else {
			ghost.reallyMove(random);
			this.movedelay = 1;
			this.nbmoves+=1;
			
			if (nbmoves==6) {
				return new RegularGhostState();
			}
			else {
				return this;
			}			
		}
	}

	@Override
	public GhostState hitBy(Ghost ghost, PacMan pacMan) {
		ghost.setOGSquare();
		return new RegularGhostState();
	}

	@Override
	public boolean getVulnerable() {
		
		return true;
	}

	
	

}
