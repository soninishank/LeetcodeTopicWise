package Meta;

import java.util.Arrays;

// Move even numbers to the left of array in place
// 1. Could numbers be duplicated - may be
// 2. Should numbers be sorted ? - Not necessary
// 3. Are negative numbers included? - Could be
// Does it handle negative numbers - Yes
public class MoveEvenNumbersToLeftOfArray {

    public void moveEvens(int[] data) {
        if (data == null || data.length <= 1) {
            return; // Nothing to do for null or single-element arrays
        }

        int left = 0;
        int right = data.length - 1;

        while (left < right) {
            // Move 'left' forward if it points to an even number
            while (left < right && data[left] % 2 == 0) {
                left++;
            }

            // Move 'right' backward if it points to an odd number
            while (left < right && data[right] % 2 != 0) {
                right--;
            }

            // Swap if 'left' is pointing to an odd number and 'right' to an even number
            if (left < right) {
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {6, 2, 3, 5, 10, 7, 5, 4, 8}; // Example input
        new MoveEvenNumbersToLeftOfArray().moveEvens(data);
        System.out.println(Arrays.toString(data));

        int[] data1 = {-4, -3, 2, -1, 6, -5};
        new MoveEvenNumbersToLeftOfArray().moveEvens(data1);
        System.out.println(Arrays.toString(data1));
    }

}
