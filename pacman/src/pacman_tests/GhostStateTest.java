package pacman_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pacman.GhostState;
import pacman.RegularGhostState;
import pacman.VulnerableGhostState;

class GhostStateTest {
	GhostState ghoststateV = new VulnerableGhostState();
	GhostState ghoststateR = new RegularGhostState();
	@Test
	void testGetVulnerable() {
		assert ghoststateV.getVulnerable();
		assert !ghoststateR.getVulnerable();
		
	}

	@Test
	void testGetDelay() {
		assert ghoststateV.getDelay()==1;
		assert ghoststateR.getDelay()==0;
	}

}
