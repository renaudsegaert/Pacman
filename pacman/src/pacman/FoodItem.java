package pacman;

public abstract class FoodItem {
	private Square vierkant;
	
	
	
	public FoodItem(Square vierkantt) {
		this.vierkant = vierkantt;
	}
	
	abstract public int getSize();
	abstract public boolean isPowerPellet();
	
	public Square getSquare() {
		return this.vierkant;
		}
		
	

}
