package Coding.Stack.Design;

import java.util.Stack;

// https://leetcode.com/problems/score-of-parentheses/
public class ScoreOfParentheses {
    Stack<Integer> stack = new Stack<>();

    public int scoreOfParentheses(String s) {
        int score = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(score);
                score = 0;
            } else if (s.charAt(i) == ')') {
                int currentScore = stack.pop();
                score = currentScore + Math.max(2 * score, 1);
            }
        }
        return score;
    }

    public static void main(String[] args) {
        int i = new ScoreOfParentheses().scoreOfParentheses("(()(()))");
        System.out.println(i);
    }
}