package Coding.Math;

import java.util.ArrayList;

public class DivideTwoIntegers {

    // divisor - negative
    // dividend - negative
    // dividend && divisor  - both negative

    int Half_Int_Min = -1073741824;

    ArrayList<Integer> doubles = new ArrayList<>();
    ArrayList<Integer> powersOfTwo = new ArrayList<>();

    public int divide(int dividend, int divisor) {
        boolean onlyOneNegative = false;
        boolean bothNegative = false;
        if (dividend < 0 && divisor < 0) {
            bothNegative = true;
        } else if (dividend < 0 || divisor < 0) {
            onlyOneNegative = true;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int quotient = 0;
        while (dividend >= divisor) {

            int power = 1;
            int value = divisor;
            while (value >= Half_Int_Min && dividend >= value + value) {
                value += value;
                power += power;
            }
            quotient += power;
            dividend -= value;
        }
        if (onlyOneNegative) {
            return -1 * quotient;
        } else {
            return quotient;
        }
    }

    public static void main(String[] args) {
        int divide = new DivideTwoIntegers().divide(2147483647, 1);
        System.out.println(divide);
    }
}

