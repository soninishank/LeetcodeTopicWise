package Coding.Recursion;

public class SumDigits {
    private int isDigitSumPalindrome(int N) {
        // code here
        if (N <= 0) {
            return 0;
        }
        int remainder = N % 10; // 6 0
        int currentValue = N / 10; // 5 0
        if (remainder > 0 && currentValue > 0) {
            currentValue += isDigitSumPalindrome(remainder);
        } else {
            currentValue += remainder; // 6
        }
        return currentValue; // 6
    }


}
