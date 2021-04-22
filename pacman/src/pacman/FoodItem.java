package pacman;

public abstract class FoodItem {
	private Square vierkant;
	
	
	
	public FoodItem(Square vierkantt) {
		this.vierkant = vierkantt;
	}
	abstract public void eatenbypacman(Maze maze);
	/**
	 * gives the size of the fooditem relative to the fooditem dot.
	 * @inspects|this
	 * 
	 * 
	 * @post| result==1 || result ==2
	 */
	abstract public int getSize();
	
	
	abstract public boolean isPowerPellet();
	
	public Square getSquare() {
		return this.vierkant;
		}
		
	

}
