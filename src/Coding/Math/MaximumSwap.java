package Coding.Math;

import java.util.Arrays;

public class MaximumSwap {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray(); // [2,7,3,6]
        int n = digits.length; // 4

        // Create an array to keep track of the maximum index from right to left
        // maxIndex is used to Track the Largest Digit to the Right:
        int[] maxIndex = new int[n]; // [0,0,0,0]
        maxIndex[n - 1] = n - 1; // this is an assumption - // [0,0,0,3]

        // Fill the maxIndex array - means the array contains maxIndex from
        // current point in a left to right
        for (int i = n - 2; i >= 0; i--) { // start from i = 2
            if (digits[i] > digits[maxIndex[i + 1]]) { // 3 > 6 - no
                maxIndex[i] = i;
            } else {
                maxIndex[i] = maxIndex[i + 1]; // [0,0,3,3]
            }
        }
        System.out.println(Arrays.toString(maxIndex)); // [1,1,3,3]
        // Find the first position where a swap would increase the number
        for (int i = 0; i < n; i++) {
            // whoever we find the bigger, we swap and break
            if (digits[i] != digits[maxIndex[i]]) {
                // Swap the digits[i] with the maximum digit found later
                char temp = digits[i];
                digits[i] = digits[maxIndex[i]];
                digits[maxIndex[i]] = temp;
                break; // Only one swap allowed, so break here
            }
        }
        // Convert the character array back to an integer and return
        return Integer.parseInt(new String(digits));
    }

    public static void main(String[] args) {
        int num = 2736;
        int i = new MaximumSwap().maximumSwap(num);
        System.out.println(i);
    }
}
