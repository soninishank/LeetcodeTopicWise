package Coding.Math;

import java.util.Arrays;

public class MaximumSwap {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int n = digits.length;

        // Track the index of the largest digit for each position
        int[] maxIndexArray = new int[n];
        int maxIdx = n - 1;

        // Fill the maxIndex array
        // just keep on putting the maxIndex in the maxIndexArray
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] > digits[maxIdx]) {
                maxIdx = i;
            }
            maxIndexArray[i] = maxIdx;
        }

        System.out.println(Arrays.toString(maxIndexArray));

        // Find the first position where a swap would increase the number
        for (int i = 0; i < n; i++) {
            if (digits[i] != digits[maxIndexArray[i]]) {
                // Swap the digits
                char temp = digits[i];
                digits[i] = digits[maxIndexArray[i]];
                digits[maxIndexArray[i]] = temp;
                break; // Only one swap is allowed
            }
        }
        return Integer.parseInt(new String(digits));
    }

    public static void main(String[] args) {
        int num = 2736;
        int i = new MaximumSwap().maximumSwap(num);
        System.out.println(i);

        int num1 = 43183;
        int i1 = new MaximumSwap().maximumSwap(num1);
        System.out.println(i1);
    }
}
