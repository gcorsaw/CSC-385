import java.util.Arrays;

public class QuickSortTest {	
	private static void randomIntArray(Integer arr[], int min, int max) {
		int mn = Math.min(min, max);
		int mx = Math.max(min, max) + 1;
		for(int i = 0; i < arr.length; i++) {
			int value = (int)(Math.random() * (mx - mn)) + mn;
			arr[i] = Integer.valueOf(value);
		}
	}
	
	private static void randomStringArray(String arr[], int min, int max) {
		if(min < 0) {
			throw new IllegalArgumentException("Min for randomStringArray must be >= 0");
		}
		int mn = Math.min(min, max);
		int mx = Math.max(min, max) + 1;
		
		char alphabet[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		
		for(int i = 0; i < arr.length; i++) {
			String s = "";
			int rLen = (int)(Math.random() * (mx - mn)) + mn;
			for(int j = 0; j < rLen; j++) {
				int rCharIdx = (int)(Math.random() * alphabet.length);
				s += alphabet[rCharIdx];
			}
			arr[i] = s;
		}
	}
	
	private static boolean isSorted(Object arr[]) {
		for(int i = 0; i < arr.length - 1; i++) {
			if(((Comparable) arr[i]).compareTo(arr[i+1]) > 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String args[]) {
		Integer iArr[] = new Integer[1000];
		randomIntArray(iArr, -100, 100);
		System.out.print("Unsorted [");
		for(int i=0; i<iArr.length; i++) {
			System.out.print(iArr[i]);
			if(i < iArr.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
		QuickSort.sort(iArr);
		System.out.print("Sorted [");
		for(int i=0; i<iArr.length; i++) {
			System.out.print(iArr[i]);
			if(i < iArr.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	
		System.out.println("QUICK SORT INTEGER ARRAY IS SORTED? " + (isSorted(iArr) ? "YES" : "NO"));
		
		String sArr[] = new String[1000];
		randomStringArray(sArr, 10, 20);
		QuickSort.sort(sArr);
		System.out.println("String Array [" + String.join(",", sArr.toString()) + "]");

		System.out.println("QUICK SORT STRING ARRAY IS SORTED? " + (isSorted(iArr) ? "YES" : "NO"));
	}
}
