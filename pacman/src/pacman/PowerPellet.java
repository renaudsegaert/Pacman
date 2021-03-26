package pacman;

public class PowerPellet extends FoodItem{
	static int size=2;
	
	
	public PowerPellet(Square square) { 
		super(square);
		
		
	}
	public int getSize() {
		return size;
	}


}
