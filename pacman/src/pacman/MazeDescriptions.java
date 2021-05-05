package pacman;

import java.util.Arrays;
import java.util.Random;

import pacman.wormholes.ArrivalPortal;
import pacman.wormholes.DeparturePortal;

public class MazeDescriptions {
	
	private MazeDescriptions() { throw new AssertionError("This class is not intended to be instantiated"); }
	
	public static Maze createMazeFromDescription(Random random, String description) {
		String[] lines = description.trim().split("\n");
		
		int height = lines.length;
		int width = lines[0].length();
		
		boolean[] passable = new boolean[height * width];
		for (int i = 0; i < passable.length; i++)
			passable[i] = true;
		
		int nbFooditems = 0;
		FoodItem[] fooditems = new FoodItem[width * height];
		//nieuwe code
		int nbbeginportalen = 0;
		DeparturePortal[] beginportalen = new DeparturePortal[width*height];
		
		int nbeindportalen = 0;
		ArrivalPortal[] eindportalen = new ArrivalPortal[width * height];
		
		//hierboven is nieuw
		int nbGhosts = 0;
		Ghost[] ghosts = new Ghost[width * height];
		
		for (int row = 0; row < lines.length; row++) {
			String line = lines[row];
			for (int column = 0; column < line.length(); column++) {
				char c = line.charAt(column);
				if (c == '#')
					passable[row * width + column] = false;
			}
		}
		MazeMap map = new MazeMap(width, height, passable);
		
		PacMan pacMan = null;
		for (int row = 0; row < lines.length; row++) {
			String line = lines[row];
			for (int column = 0; column < line.length(); column++) {
				char c = line.charAt(column);
				switch (c) {
				case ' ' -> {}
				case '#' -> {}
				case '.' -> fooditems[nbFooditems++] = new Dot(Square.of(map, row, column));
				case 'p' -> fooditems[nbFooditems++]= new PowerPellet(Square.of(map, row, column));
				//hieronder
				case 'D' -> beginportalen[nbbeginportalen++] = new DeparturePortal(Square.of(map,row,column));
				case 'A' -> eindportalen[nbeindportalen++] = new ArrivalPortal(Square.of(map,row,column));
				//hierboven
				case 'G' -> ghosts[nbGhosts++] = new Ghost(Square.of(map, row, column), Direction.values()[random.nextInt(Direction.values().length)]);
				case 'P' -> {
					if (pacMan != null)
						throw new IllegalArgumentException("Maze description contains multiple P characters");
					pacMan = new PacMan(3, Square.of(map, row, column));
				}
				default -> throw new IllegalArgumentException("Invalid character in maze description: " + c);
				}
			}
		}
		
		if (pacMan == null)
			throw new IllegalArgumentException("Maze description does not contain a P character");
		
		return new Maze(random, map, pacMan, Arrays.copyOf(ghosts, nbGhosts), Arrays.copyOf(fooditems, nbFooditems), Arrays.copyOf(beginportalen, nbbeginportalen),Arrays.copyOf(eindportalen, nbeindportalen));
		
	}

}
