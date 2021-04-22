package pacman;

public class PowerPellet extends FoodItem{
	
	static int relativesize= 2;
	
	
	public PowerPellet(Square square) { 
		super(square);
		
		
	}
	/**
	 *  
	 *  @inspects| this
	 *  @post| result ==2
	 *  
	 *  
	 */
	public int getSize() {
		return relativesize;
	}
	@Override
	public boolean isPowerPellet() {
		
		return true;
	}
	@Override
	public void eatenbypacman(Maze maze) {
		Ghost[] geesten = maze.getGhosts();
		for (Ghost g  :  geesten) {
			g.pacManAtePowerPellet();
		}
		maze.setGhosts(geesten);
		
	}


}
