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


    List<String> result = new ArrayList<>();
    private void backtrackUsingStringBuilder(int n, int open, int close, StringBuilder sb) {
        // Base case: When the length of the string is 2 * n, add to result
        if (sb.length() == n * 2) {
            result.add(sb.toString()); // Convert StringBuilder to String
            return; // Stop further recursion
        }

        // If the number of open parentheses is less than n, add an open parenthesis
        if (open < n) {
            sb.append('('); // Append '('
            backtrackUsingStringBuilder(n, open + 1, close, sb);
            sb.deleteCharAt(sb.length() - 1); // Backtrack
        }

        // If the number of close parentheses is less than the number of open ones, add a closing parenthesis
        if (close < open) {
            sb.append(')'); // Append ')'
            backtrackUsingStringBuilder(n, open, close + 1, sb);
            sb.deleteCharAt(sb.length() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> list = new GenerateParentheses().generateParenthesis(n);
        System.out.println(list);
    }
}
