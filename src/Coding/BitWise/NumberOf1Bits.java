package Coding.BitWise;

// https://leetcode.com/problems/number-of-1-bits/
public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int noOfOnes = 0;
        while (n != 0) {
            noOfOnes = noOfOnes + (n & 1);
            n = n >>> 1;
        }
        return noOfOnes;
    }

    public static void main(String[] args) {

    }
}
