package RecursionAssignment;


public class Islands {
	public static void main(String args[]) {
		int map[][] = new int[5][5];
		
		int maxValue = 100;
		int dropChance = 25;
		randomIslands(map, maxValue, dropChance);
		printIslands(map);
		System.out.println("There is an island with a value of " + maxValueIsland(map));
	}
	
	/**********Student Code Here**************************/
	
	public static int maxValueIsland(int map[][]) {
		int maxValue = 0;
		boolean visited[][] = new boolean[map.length][map[0].length];
		// map[row][column]
		for(int row = 0; row < map.length; row++) {
			for(int column = 0; column < map.length; column++) {
				maxValue = Math.max(maxValue, getNeighbors(map, row, column, visited));
			}
		}
		return maxValue;
	}
	private static int getNeighbors(int map[][], int row, int column, boolean visited[][]) {
		
		if(row < 0 || row > map.length -1 ) {
			//row is out of bounds
			return 0;
		}
		
		if(column < 0 || column > map[0].length-1) {
			return 0;
		}
		if(map[row][column] > 0 && !visited[row][column]) {
			visited[row][column] = true;
			return map[row][column] +
			//top
			+ getNeighbors(map, row -1, column, visited)
			//right
			+ getNeighbors(map, row, column +1, visited)
			//bottom
			+ getNeighbors(map, row +1, column, visited)
			//left
			+ getNeighbors(map, row, column -1, visited);
		}
		visited[row][column] = true;
		return 0;
	}
	/******************************************************************/
	
	public static void randomIslands(int map[][], int maxPossibleValue, int chance) {
		if(maxPossibleValue <= 0) {
			throw new IllegalArgumentException("The max possible value must be a positive integer.");
		}
		if(chance > 100 || chance < 0) {
			throw new IllegalArgumentException("The chance of money drop must be between 0 <= p <= 100");
		}
		for(int r = 0; r < map.length; r++) {
			for(int c = 0; c < map[r].length; c++) {
				int possible = (int) (Math.random() * 100) + 1;
				if(possible <= chance) {
					map[r][c] = (int)(Math.random() * maxPossibleValue) + 1;
				}
			}
		}
	}
	
	public static void printIslands(int island[][]) {
		int maxDigits = getMaxDigits(island);
		for(int r = 0; r < island.length; r++) {
			for(int c = 0; c < island[r].length; c++) {
				int value = island[r][c];
				String s = "%"+maxDigits+"d";
				if(value != 0) {
					System.out.print(" |");
					System.out.printf(s, value);
					System.out.print("| ");
				} else {
					System.out.print("  ");
					System.out.printf("%"+maxDigits+"s", "-");
					System.out.print("  ");
				}
			}
			System.out.println(" ");
		}
	}

	private static int getMaxDigits(int[][] arr) {
		int maxDigitSize = 0;
		for(int r = 0; r < arr.length; r++) {
			for(int c = 0; c < arr[r].length; c++) {
				int value = arr[r][c];
				int digits = 0;
				while(value != 0) {
					digits += 1;
					value /= 10;
				}
				if(digits > maxDigitSize) {
					maxDigitSize = digits;
				}
			}
		}
		return maxDigitSize;
	}
}
