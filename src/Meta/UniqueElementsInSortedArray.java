package Meta;

// https://leetcode.com/discuss/interview-question/629432/Facebook-or-Phone-or-Unique-elements-in-a-sorted-array-and-Clone-Graph
public class UniqueElementsInSortedArray {
    // BruteforceWay
    public static int countUniqueElementsUsingBruteforce(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0; // If an array is empty, return 0
        }
        int count = 1; // The First element is always unique
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                count++; // Increment count when a unique element is found
            }
        }
        return count;
    }

    // Using Binary Search : O(klogN) where K is the number of unique elements and N is the size of the array.
    //Space Complexity:O(1), as no extra space is used.
    public int countUniqueElements(int[] arr) {
        int n = arr.length;
        int count = 0; // Counter for unique elements
        int i = 0;     // Current index in the array
        while (i < n) {
            count++; // Count the current unique element
            i = findNextUniqueIndex(arr, i); // Find the index of the next unique element -  this will be the index of newer element
        }
        return count;
    }

    // Helper function to find the index of the next unique element
    private int findNextUniqueIndex(int[] arr, int currentIndex) {
        int n = arr.length;
        int currentValue = arr[currentIndex];
        int low = currentIndex + 1, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // If matched
            if (arr[mid] == currentValue) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // `low` now points to the first index greater than `currentValue`
        return low;
    }

    public static void main(String[] args) {
        int[] input = {1, 1, 1, 1, 2, 2, 2, 2, 5, 5, 5, 7, 7, 8, 8, 10, 11};
        System.out.println("Unique count: " + new UniqueElementsInSortedArray().countUniqueElements(input)); // Output: 6
    }
}
