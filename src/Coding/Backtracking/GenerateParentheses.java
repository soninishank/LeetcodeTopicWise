package Coding.Backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/
public class GenerateParentheses {
    List<String> resultList = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return resultList;
        }
        generateParenthesisUsingBackTracking(n, 0, 0, "");
        return resultList;
    }

    private void generateParenthesisUsingBackTracking(int n, int open, int close, String str) {
        if (open > n) {
            return;
        }
        if (str.length() == n * 2) {
            resultList.add(str);
        }
        if (open < n) {
            generateParenthesisUsingBackTracking(n, open + 1, close, str + "(");
        }
        if (close < open) {
            generateParenthesisUsingBackTracking(n, open, close + 1, str + ")");
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> list = new GenerateParentheses().generateParenthesis(n);
        System.out.println(list);
    }
}
