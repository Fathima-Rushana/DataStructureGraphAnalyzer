import java.util.Arrays;

/**
 * Searching component: linear search and binary search.
 * Both methods count the number of comparisons (steps) and measure time
 * so the two algorithms can be compared.
 */
public class Searching {

    /** Holds the outcome of one search. */
    public static class SearchResult {
        public final String algorithm;
        public final int index;
        public final long steps;
        public final long nanos;

        SearchResult(String algorithm, int index, long steps, long nanos) {
            this.algorithm = algorithm;
            this.index = index;
            this.steps = steps;
            this.nanos = nanos;
        }
    }

    /** Linear search: checks every element one by one. Time complexity O(n). */
    public static SearchResult linear(int[] arr, int key) {
        long start = System.nanoTime();
        long steps = 0;
        int found = -1;
        for (int i = 0; i < arr.length; i++) {
            steps++;
            if (arr[i] == key) {
                found = i;
                break;
            }
        }
        return new SearchResult("Linear Search", found, steps, System.nanoTime() - start);
    }

    /** Binary search: the array MUST be sorted. Time complexity O(log n). */
    public static SearchResult binary(int[] sortedArr, int key) {
        long start = System.nanoTime();
        long steps = 0;
        int low = 0;
        int high = sortedArr.length - 1;
        int found = -1;
        while (low <= high) {
            steps++;
            int mid = low + (high - low) / 2;
            if (sortedArr[mid] == key) {
                found = mid;
                break;
            } else if (sortedArr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new SearchResult("Binary Search", found, steps, System.nanoTime() - start);
    }

    /** Returns a sorted copy of the array (the original is not changed). */
    public static int[] sortedCopy(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        return copy;
    }
}
