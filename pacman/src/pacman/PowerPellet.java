package pacman;

public class PowerPellet extends FoodItem{
	
	static int relativesize= 2;
	
	
	public PowerPellet(Square square) { 
		super(square);
		
		
	}
	public int getSize() {
		return relativesize;
	}
	@Override
	public boolean isPowerPellet() {
		
		return true;
	}


}
