public class MergeSort {
	public static void sort(Object arr[]) {
		int last = arr.length - 1;
		int mid = last / 2;
		mergeSort(arr, new Object[arr.length], 0, mid, last);
	}

	private static void mergeSort(Object arr[], Object tempArray[], int first, int mid, int last) {
		/*
		 * mid = approximate midpoint between first and last mergeSort(a, tempArray,
		 * first, mid); mergeSort(a,tempArray, mid+1, last); Merge the sorted halves a
		 * [first...mid] and a [mid + 1 ... last] using the array tempArray
		 */

		if (first < last) {
			mid = (first + last) / 2;
			int leftMid = (first + mid) / 2;
			// Left side
			mergeSort(arr, tempArray, first, leftMid, mid);
			// right side
			int rightMid = (mid + 1 + last) / 2;
			mergeSort(arr, tempArray, mid + 1, rightMid, last);
			merge(arr, tempArray, first, mid, last);
		}
	}

	private static void merge(Object arr[], Object tempArray[], int first, int mid, int last) {
		int beginHalf1 = first;
		int endHalf1 = mid;
		int beginHalf2 = mid + 1;
		int endHalf2 = last;
		int index = 0;

		while (beginHalf1 <= endHalf1 && beginHalf2 <= endHalf2) {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			int result = (((Comparable) arr[beginHalf1]).compareTo(arr[beginHalf2]));
			if (result <= 0) {
				tempArray[index] = arr[beginHalf1];
				beginHalf1++;
				index++;
			} else {
				tempArray[index] = arr[beginHalf2];
				beginHalf2++;
				index++;
			}
		}
		while(beginHalf1 <= endHalf1) {
			tempArray[index] = arr[beginHalf1];
			beginHalf1++;
			index++;
		}
		while(beginHalf2 <= endHalf2) {
			tempArray[index] = arr[beginHalf2];
			beginHalf2++;
			index++;
		}
		for(int i = 0, j = first; i<= (last-first); i++, j++) {
			arr[j] = tempArray[i];
		}
	}
}
