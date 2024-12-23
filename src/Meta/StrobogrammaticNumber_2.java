package Meta;

import java.util.*;

// https://leetcode.com/problems/strobogrammatic-number/
public class StrobogrammaticNumber_2 {
    public static boolean isStrobogrammatic(String num) {
        // Map to store valid strobogrammatic digit mappings
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');

        int left = 0;
        int right = num.length() - 1;

        while (left <= right) {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);

            // Check if the characters are strobogrammatic
            if (!map.containsKey(leftChar)) {
                if (map.get(leftChar) != rightChar) {
                    return false;
                }
            } else {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static List<String> findStrobogrammatic(int k) {
        return helper(k, k);
    }

    private static List<String> helper(int n, int k) {
        if (n == 0) return new ArrayList<>(Arrays.asList(""));
        if (n == 1)
            return new ArrayList<>(Arrays.asList("0", "1", "8"));

        List<String> list = helper(n - 2, k);
        List<String> result = new ArrayList<>();

        for (String s : list) {
            if (n != k) {
                result.add("0" + s + "0"); // Avoid leading zeros
            }
            result.add("1" + s + "1");
            result.add("6" + s + "9");
            result.add("8" + s + "8");
            result.add("9" + s + "6");
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> strobogrammatic = new StrobogrammaticNumber_2().findStrobogrammatic(3);
        System.out.println(strobogrammatic);
    }
}
