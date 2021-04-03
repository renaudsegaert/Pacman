package pacman;

import java.util.Random;

public abstract class GhostState {
	
	
	int movedelay;

	public abstract boolean getVulnerable();

	public abstract GhostState move(Ghost ghost, Random random);
	
	public int getDelay() {
		return movedelay;
	}
	public  abstract GhostState hitBy(Ghost ghost, PacMan pacMan);
		
	
	
	

}
