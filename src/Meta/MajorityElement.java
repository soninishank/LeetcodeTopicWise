package Meta;

//Check if an element occurs greater than n/4 times in a sorted array of size n elements.
//Optional variation: Find an element that appears more than 25% of times in an array of grouped elements.
//Question Statement
//Given some array of length n, where n is a multiple of 4, check if there is any element which occurs strictly more than n/4 times.
// Example 1:
//[1, 2, 2, 2, 2, 6, 7, 8, 9, 10, 11, 12] – Yes
//[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12] – No
//
//Optional variation example:
//        [1, 1, 1, 1, -2, 5] – 1
//        [1, 2, 3, 4, 5] – None
//
//Possible solutions:
//Worst: hashmap: O(n) time with high overhead and O(n) memory
//Bad: O(n) sweep through the array, resetting the count when you see a new number, O(n) time and O(1) space
//Best: Check the elements at indices n/4, 2n/4, and 3n/4, binary searching for the first time they appear, and then seeing if the element at i + n/4 is equal to it.
public class MajorityElement {
    // Left-biased binary search for the first occurrence
    private static int searchFor(int x, int[] a) {
        int l = 0, r = a.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (a[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static boolean elementOccursQuarterOfTimeGood(int[] a) {
        int n = a.length;

        // Check candidates at n/4 intervals
        for (int candidateIndex : new int[]{n / 4, n / 2, (3 * n) / 4}) {
            int candidate = a[candidateIndex];

            // Find the first occurrence of the candidate
            int first = searchFor(candidate, a);

            // Find the first occurrence of the next unique element
            int firstNext = searchFor(candidate + 1, a);

            System.out.println(first + "   " + firstNext);

            // Calculate count
            int count = firstNext - first;
            if (count > n / 4) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 2, 2, 6, 7, 8, 9, 10, 11, 12};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        System.out.println(elementOccursQuarterOfTimeGood(arr1)); // true
        System.out.println(elementOccursQuarterOfTimeGood(arr2)); // false

        int[] arr3 = {1, 1, 1, 1, -2, 5};
        System.out.println(elementOccursQuarterOfTimeGood(arr3));

    }
}
