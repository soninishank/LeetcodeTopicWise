package Meta;

// You are given an ascending infinite sequence of integers A and an integer X. Is it possible to decide if
//X is in the A? If yes, how can you find the index of X in A? Return -1 if X is not in A.
//Note: You can think of this question as in C/C++ you are given an integer pointer, and you do not
// know the length of the array: int search(int X, int* A).

public class SearchInInfiniteSequence {
    // Function to find the index of X in an infinite ascending array A
    public static int search(int X, int[] A) {
        // Step 1: Handle the case where the array is empty or null
        if (A == null || A.length == 0) {
            return -1;
        }

        // Step 2: Use exponential search to find the range where X could be located
        int index = 1;
        while (index < A.length && A[index] < X) {
            index *= 2; // Exponentially double the index
        }

        // Step 3: Perform binary search in the probable window
        return binarySearch(A, X, index / 2, Math.min(index, A.length - 1));
    }

    // Helper function for binary search
    private static int binarySearch(int[] A, int X, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (A[mid] == X) {
                return mid; // Return the index if X is found
            } else if (A[mid] < X) {
                low = mid + 1; // Move to the right subarray
            } else {
                high = mid - 1; // Move to the left subarray
            }
        }

        return -1; // X is not found
    }

    public static void main(String[] args) {
        // Example array (assumed to be infinite for the problem's context)
        int[] A = {1, 2, 3, 5, 6, 7, 9, 11, 13, 15}; // Example array

        // Test cases
        int X1 = 5;
        int X2 = 4;

        System.out.println("Index of " + X1 + ": " + search(X1, A)); // Output: 3
        System.out.println("Index of " + X2 + ": " + search(X2, A)); // Output: -1
    }
}
