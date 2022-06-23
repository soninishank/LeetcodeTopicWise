package Coding.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    List<String> result = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        if (s.length() == 0) {
            return result;
        }
        applyBacktracking(s, new StringBuilder(), result, 0);
        return result;
    }

    private void applyBacktracking(String input, StringBuilder str, List<String> result, int index) {
        if (str.length() == input.length()) {
            result.add(str.toString());
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            str.append(input.charAt(i));
            applyBacktracking(input, str, result, index);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> list = new LetterCasePermutation().letterCasePermutation("a1b2");
        System.out.println(list);
    }
}
