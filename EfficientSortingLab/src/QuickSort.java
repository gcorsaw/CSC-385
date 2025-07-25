public class QuickSort {

    private static final int MIN_SIZE = 4;

    public static void sort(Object arr[]) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(Object arr[], int first, int last) {
        if (last - first < MIN_SIZE) {
            // Once we are below the minimum size it doesn't make sense to do a
            // quickSort anymore.
            insertionSort(arr, first, last);
        } else {
            // Get the pivot location once the partitioning is done and use it
            // for the recursive quickSort calls.
            int pivotIndex = partition(arr, first, last);
            quickSort(arr, first, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, last);
        }
    }

    private static void sortFirstMiddleLast(Object arr[], int first, int mid, int last) {
        if (((Comparable) arr[first]).compareTo(arr[mid]) > 0) {
            swap(arr, first, mid);
        }
        if (((Comparable) arr[mid]).compareTo(arr[last]) > 0) {
            swap(arr, mid, last);
        }
        if (((Comparable) arr[first]).compareTo(arr[mid]) > 0) {
            swap(arr, first, mid);
        }
    }

    private static int partition(Object arr[], int first, int last){
        // Pick an arbitrary location for the pivot and then rearrange the data
        // in the array to align with the chosen pivot value. Return the new
        // location of the pivot value so that the next recursive call knows where
        // to continue to subdivide the array for the recursive sort.
        
        int mid = first + ((last - first) / 2);
        sortFirstMiddleLast(arr, first, mid, last);
        //because of the call to sortFirstMiddleLast we know that the first and last
        // elements are in the correct partitions.
        
        // Move the mid point value next to the end value so it stays out of the way
        swap(arr, mid, last - 1);
        // Repoint the pivotIndex so it reflects the new pivot index location
        int pivotIndex = last - 1;
        // Get the value for the pivot so we can perform comparisons
        Object pivotValue = arr[pivotIndex];

        // We can skip the first value because we know it's in the right spot
        int indexFromLeft = first + 1;
        // We can skip two values on the right because one of them is in the
        // correct location and the other is the pivot value.
        int indexFromRight = last - 2;
        boolean done = false;
        while(!done) {
            while (((Comparable)arr[indexFromLeft]).compareTo(pivotValue) < 0) {
                // Until we find a value on the left that shouldn't be there keep going.
                indexFromLeft++;
            }
            while (((Comparable)arr[indexFromRight]).compareTo(pivotValue) > 0) {
                // Until we find a value on the right that shouldn't be there keep going.
                indexFromRight--;
            }
            if (indexFromLeft < indexFromRight) {
                // Once we make it past the while loops AND if we don't have
                // matching indexes we should swap values.
                swap(arr, indexFromLeft, indexFromRight);
                // We can move both indexes closer to the middle after swapping
                indexFromLeft++;
                indexFromRight--;
            } else {
                // The indexes match so we're all done
                done = true;
            }
        }
        // Now that we're done use the indexFromLeft as the new middle point
        // by swapping the pivot index value back to the new pivot point.
        swap(arr, pivotIndex, indexFromLeft);
        pivotIndex = indexFromLeft;
        return pivotIndex;
    }

    private static void swap(Object arr[], int idx1, int idx2) {
        Object temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    private static void insertionSort(Object arr[], int first, int last) {
        for(int i = first; i < last; i++) {
            for(int j = i + 1; j > first; j--) {
                int res = ((Comparable) arr[j]).compareTo(arr[j-1]);
                if(res < 0) {
                    swap(arr, j, j-1);
                } else {
                    break;
                }
            }
        }
    }
}
