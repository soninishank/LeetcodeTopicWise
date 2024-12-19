package Coding.Amazon.ProblemSolving;

import Coding.Math.IntegerToRoman;

import java.util.HashMap;

public class A_1_IntegerToRomanNumerals {
    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "I");
        hashMap.put(4, "IV");
        hashMap.put(5, "V");
        hashMap.put(9, "IX");
        hashMap.put(10, "X");
        hashMap.put(40, "XL");
        hashMap.put(50, "L");
        hashMap.put(90, "XC");
        hashMap.put(100, "C");
        hashMap.put(400, "CD");
        hashMap.put(500, "D");
        hashMap.put(900, "CM");
        hashMap.put(1000, "M");
        int min = Integer.MAX_VALUE;
        int getKey = -1;
        while (num != 0) {
            for (int key : hashMap.keySet()) {
                if (key <= num) {
                    int i = num - key;
                    if (i < min) {
                        min = Math.min(min, i);
                        getKey = key;
                    }
                }
            }
            num -= getKey;
            stringBuilder.append(hashMap.get(getKey));
        }
        return stringBuilder.toString();
    }

    //iterate until the number becomes zero, NO NEED to go until the last element in roman array
    private String intToRomanUsingArray(int num) {
        if (num < 1 || num > 3999) return "";
        StringBuilder result = new StringBuilder();
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int i = 0;
        while (num > 0) {
            while (num >= values[i]) {
                num -= values[i];
                result.append(roman[i]);
            }
            i++;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = new IntegerToRoman().intToRoman(1994);
        System.out.println(s);
    }
}
