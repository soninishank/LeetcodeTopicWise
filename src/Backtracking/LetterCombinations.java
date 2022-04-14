package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinations {
    private List<String> resultList = new ArrayList<>();
    private HashMap<Character, String> hashMap = new HashMap<>();


    public List<String> letterCombinations(String digits) {
        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");
        doBacktrack(digits.toCharArray(), 0, new StringBuilder());
        return resultList;
    }

    private void doBacktrack(char[] digits, int index, StringBuilder stringBuilder) {
        if (stringBuilder.length() == digits.length) {
            resultList.add(stringBuilder.toString());
            return;
        }
        if (index > digits.length - 1) {
            return;
        }
        String s = hashMap.get(digits[index]);
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i)); // choose
            doBacktrack(digits, index + 1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1); // unchoose
        }
    }

    public static void main(String[] args) {
        List<String> strings = new LetterCombinations().letterCombinations("23");
        System.out.println(strings);
    }
}
