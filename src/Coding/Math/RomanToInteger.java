package Coding.Math;

import java.util.HashMap;

// https://leetcode.com/problems/roman-to-integer/
public class RomanToInteger {

    public int romanToInt(String s) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("I", 1);
        hashMap.put("IV", 4);
        hashMap.put("V", 5);
        hashMap.put("IX", 9);
        hashMap.put("X", 10);
        hashMap.put("XL", 40);
        hashMap.put("L", 50);
        hashMap.put("XC", 90);
        hashMap.put("C", 100);
        hashMap.put("CD", 400);
        hashMap.put("D", 500);
        hashMap.put("CM", 900);
        hashMap.put("M", 1000);
        int sum = 0;
        for (int i = 0; i < s.length(); ) {
            if (i < s.length() - 1) {
                String doubleString = s.substring(i, i + 2);
                if (hashMap.containsKey(doubleString)) {
                    sum += hashMap.get(doubleString);
                    i = i + 2;
                    continue;
                }
            } // otherwise it's a single string
            String singleString = s.substring(i, i + 1);
            sum += hashMap.get(singleString);
            i = i + 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        int i = new RomanToInteger().romanToInt(s);
        System.out.println(i);
    }
}
