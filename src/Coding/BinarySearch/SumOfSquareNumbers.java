package Coding.BinarySearch;

// https://leetcode.com/problems/sum-of-square-numbers/
public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        long low = 0;
        long high = (long) Math.sqrt(c); // The maximum value for b is sqrt(c)

        while (low <= high) {
            long sumOfSquares = low * low + high * high;

            if (sumOfSquares == c) {
                return true; // Found integers a and b such that a^2 + b^2 = c
            } else if (sumOfSquares < c) {
                low++; // Increase low to make the sum larger
            } else {
                high--; // Decrease high to make the sum smaller
            }
        }

        return false; // No such pair found
    }
}
