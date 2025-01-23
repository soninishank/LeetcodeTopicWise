package Meta;

// Given a sorted array and an integer K, return the index of the first element greater than K.
// If there isn't an element greater than K, return -1.
// Array	K	Output (Index of the element)
//[1 2 3 4]	1	1
//[1 1 1 2]	1	3
//[5 6 7 8]	-10	0
//[1 2 3 4]	4	-1
//[1 2 2 2 2]	1	1

//First: K is in the array
//Second: K is in the array several times
//Third: The array does not necessarily contain K
//Fourth: There isn't an element greater than K
//Fifth: In case there's multiple answers, we have to return the first index.

public class FirstElementGreaterThanK {
    public static int firstElementGreaterThanK(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Prevents overflow
            if (array[mid] > k) {
                result = mid; // Update the result with the current index
                right = mid - 1; // Move to the left half
            } else {
                left = mid + 1; // Move to the right half
            }
        }
        return result; // Return the result
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 1, 4};
        int k = 1;
        System.out.println(firstElementGreaterThanK(array, k)); // Output: 1

        int[] array1 = {5, 6, 7, 8};
        int k1 = -10;
        System.out.println(firstElementGreaterThanK(array1, k1)); // Output: 0

        int[] array12 = {1, 2, 3, 4};
        int k12 = 4;
        System.out.println(firstElementGreaterThanK(array12, k12)); // Output: -1
    }

}
