package Meta;

import java.util.Arrays;

public class SecondHighestNumber {
    public static String findSecondHighest(int[] digits) {
        // Edge case: if the input is null or has less than 2 digits
        if (digits == null || digits.length < 2) {
            return "Not enough digits to find the second highest number";
        }

        // Step 1: Sort the array in descending order
        Arrays.sort(digits);
        reverseArray(digits);

        // Step 2: Find the largest number
        String firstLargestNumber = arrayToNumber(digits);

        // Step 3: Find the second-largest number by swapping the last two digits
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] != digits[i - 1]) { // Ensure the swap gives a unique number
                swap(digits, i, i - 1);
                break;
            }
        }

        // Generate the second-largest number
        String secondLargestNumber = arrayToNumber(digits);

        // Edge case: if the second largest is the same as the largest (unlikely but for completeness)
        if (firstLargestNumber.equals(secondLargestNumber)) {
            return "Cannot find a distinct second highest number";
        }
        return secondLargestNumber;
    }

    // Helper method to reverse an array
    private static void reverseArray(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            swap(array, left, right);
            left++;
            right--;
        }
    }

    // Helper method to swap two elements in an array
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Helper method to convert an array to a number (as a String)
    private static String arrayToNumber(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int digit : array) {
            sb.append(digit);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] digits = {1, 2, 3, 4, 5}; // Example input array
        System.out.println("Second highest number: " + findSecondHighest(digits));

        int[] digits1 = {1, 1, 1, 1, 1}; // Example input array
        System.out.println("Second highest number: " + findSecondHighest(digits1));

        int[] digits12 = {5, 4, 3, 2, 1, 1}; // Example input array
        System.out.println("Second highest number: " + findSecondHighest(digits12));
    }
}
