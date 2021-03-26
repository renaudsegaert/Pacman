package pacman;

public abstract class FoodItem {
	private Square vierkant;
	
	
	public FoodItem(Square vierkantt) {
		this.vierkant = vierkantt;
	}
	
	abstract int getSize();
	
	
	public Square getSquare() {
		return this.vierkant;
				}
		
	

}
