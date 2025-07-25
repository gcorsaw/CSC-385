package recursionLab2;

public class RecursionLab {
	public static void main(String args[]) {
		System.out.println(reverseString("Hello world."));
		System.out.println(sumDigits(3919));
		System.out.println(sumPositives(new int[] {9, 0, -3, 5, 7, -6}, 0));
		System.out.println(solvable1DMaze(new int[] {0, 1, 1, 0, 0, 1, 0}, 0, 2));
		System.out.println(targetSum(new int[] {-51, -99, 88, -89, 34, 63, -100, 77, 43, 12}, 0, 0, 33));
	}

	private static String reverseString(String s) {
	    if(s.length() <= 1) {
	    	return s;
	    }
	    else{
	    	String lastCharacter = s.substring(s.length()-1, s.length());
	    	String nextCharacters = s.substring(0, s.length()-1);
	    	return lastCharacter + reverseString(nextCharacters); 
	    }    
	}
	
	private static int sumDigits(int num) {
	   if(num < 10) {
		   return num;
	   }else {
		   return num%10 + sumDigits(num/10);
	   }
	}
	
	private static int sumPositives(int arr[], int idx) {
	   if(idx >= arr.length) {
		   return 0;
	   }
	   if(arr[idx] >= 0) {
		   // The array holds a positive number at this index
		   return arr[idx] + sumPositives(arr, idx + 1) ;
	   }else {
		   // The array holds a negative number at this index
		   return 0 + sumPositives(arr, idx + 1);
	   }
	}
	
	private static boolean solvable1DMaze(int maze[], int idx, int jump) {
	    if(idx >= maze.length) {
	    	return true;
	    }
	    if(idx < 0) {
	    	return false;
	    }
	    
	    if(maze[idx] == 1 ) {
	    	return false;
	    }
	    
	    maze[idx] = 1;
		return solvable1DMaze(maze, idx + 1, jump) 
				|| solvable1DMaze(maze, idx - 1, jump) 
				|| solvable1DMaze(maze, idx + jump, jump);
	}
	
	private static boolean targetSum(int arr[], int idx, int sum, int target) {
		if(idx >= arr.length) {
			return sum == target;
		}
		return targetSum(arr, idx + 1, sum + arr[idx], target) ||
			   targetSum(arr, idx + 1, sum, target);
	}
}