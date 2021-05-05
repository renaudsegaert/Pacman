package pacman;

import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import pacman.wormholes.ArrivalPortal;
import pacman.wormholes.DeparturePortal;
import pacman.wormholes.Wormhole;

public class Maze {
	
	private Random random;
	private MazeMap map;
	private PacMan pacMan;
	private Ghost[] ghosts;
	private FoodItem[] fooditems;
	//begin toegevoegde code
	private DeparturePortal[] beginportalen;
	private ArrivalPortal[] eindportalen;
	private Wormhole[] wormhollen = new Wormhole[0];
	
	public DeparturePortal[] getDeparturePortals() {return beginportalen.clone();}
	public ArrivalPortal[] getArrivalPortals() {return eindportalen.clone();}
	public Wormhole[] getWormholes() {return wormhollen.clone();}
	
	
	
	
	// einde code
	
	public MazeMap getMap() { return map; }
	
	public PacMan getPacMan() { return pacMan; }
	
	public Ghost[] getGhosts() { return ghosts.clone(); }
	
	public FoodItem[] getFoodItems() { return fooditems.clone(); }
	
	public Maze(Random random, MazeMap map, PacMan pacMan, Ghost[] ghosts, FoodItem[] fooditems, DeparturePortal[] beginportalen,ArrivalPortal[] eindportalen) {
		this.random = random;
		this.map = map;
		this.pacMan = pacMan;
		this.ghosts = ghosts.clone();
		this.fooditems = fooditems.clone();
		// code eronder
		this.beginportalen= beginportalen.clone();
		this.eindportalen = eindportalen.clone();
		//code erbove
	}
	//functie hieronder toegevoegd
	public void addWormhole(Wormhole wormhol) {
		 
		 if (Arrays.asList(getDeparturePortals()).contains(wormhol.getDeparturePortal()) && Arrays.asList(getArrivalPortals()).contains(wormhol.getArrivalPortal())) {
			 int aantalwormhollen = getWormholes().length;
			 Wormhole[] nieuwwormhollen = new Wormhole[aantalwormhollen+1];
			 for (int i =0; i<aantalwormhollen;i++) {
				 nieuwwormhollen[i] = getWormholes()[i];
			 }
			 
			 nieuwwormhollen[aantalwormhollen] = wormhol;
			 this.wormhollen = nieuwwormhollen;
		}
		 
		 else if (Arrays.asList(getDeparturePortals()).contains(wormhol.getDeparturePortal()) && !Arrays.asList(getArrivalPortals()).contains(wormhol.getArrivalPortal()) ) {
			 throw new IllegalArgumentException("het eindportaal van het wormhol dat je hebt gegeven zit niet in de maze!!!");
			 
		 }
		 else if (!Arrays.asList(getDeparturePortals()).contains(wormhol.getDeparturePortal()) && Arrays.asList(getArrivalPortals()).contains(wormhol.getArrivalPortal()) ){
			 throw new IllegalArgumentException("het beginportaal van het wormhol dat je hebt gegeven zit niet in de maze!!!");
		 }
		 else {
			 throw new IllegalArgumentException("zowel het beginportaal van het wormhol als het eindportaal van het wormhol dat je hebt gegeven zit niet in de maze!!!");
		 }
		 
		 	
	}
	//functie hierbove toegevoegd
	public void setGhosts(Ghost[] geesten) {ghosts = geesten.clone();}
	
	
	public boolean isCompleted() {
		return fooditems.length == 0;
	}
	
	private void checkPacManDamage() {
		for (Ghost ghost : ghosts)
			if (ghost.getSquare().equals(pacMan.getSquare()))
				ghost.hitBy(pacMan);
	}
	
	public void moveGhosts() {
		for (Ghost ghost : ghosts)
			ghost.move(random);
		checkPacManDamage();
	}
	
	private void removeFoodItemAtIndex(int index) {
		FoodItem[] newFoodItems = new FoodItem[fooditems.length - 1];
		System.arraycopy(fooditems, 0, newFoodItems, 0, index);
		System.arraycopy(fooditems, index + 1, newFoodItems, index, newFoodItems.length - index);
		fooditems = newFoodItems;
	}
	/*
	 * beide getters hier toegevoegd
	 */
	private FoodItem getFoodItemAtIndex(int index) {
		return fooditems[index];
	}
	
	private FoodItem getFoodItemAtSquare(Square square) {
		for (int i =0; i< fooditems.length;i++) {
			if (fooditems[i].getSquare().equals(square)){
				return getFoodItemAtIndex(i);
			}
		}
		return null;
	}
	
	private void removeFoodItemAtSquare(Square square) {
		for (int i = 0; i < fooditems.length; i++) {
			if (fooditems[i].getSquare().equals(square)) {
				removeFoodItemAtIndex(i);
				return;
			}
		}
	}

	public void movePacMan(Direction direction) {
		
		Square newSquare = pacMan.getSquare().getNeighbor(direction);
		if (newSquare.isPassable()) {
			pacMan.setSquare(newSquare);
			for (int i = 0; i < getFoodItems().length; i++) {
				if (fooditems[i].getSquare().equals(newSquare)){
					fooditems[i].eatenbypacman(this);
				}
			}
			removeFoodItemAtSquare(newSquare);
			
			checkPacManDamage();
			//nieuwe code
			ArrayList<Wormhole> mogelijkekanshebbers= new ArrayList<Wormhole>();
			
			for (int i = 0; i < getWormholes().length; i++) {
				if (getWormholes()[i].getDeparturePortal().getSquare().equals(newSquare)){
					mogelijkekanshebbers.add(getWormholes()[i]);
					
				}
				
			}
			if (mogelijkekanshebbers.size()>=1) {
				pacMan.setSquare(mogelijkekanshebbers.get(random.nextInt(mogelijkekanshebbers.size())).getArrivalPortal().getSquare());
				checkPacManDamage();
			}
			
			
		}
	}
	
}
