package Coding.Stack;

import java.util.Stack;

// https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
// Minimum Number of Swaps to Make the String Balanced
public class MinNoOfSwapsStringBalanced {
    Stack<Character> stack = new Stack<>();

    public int minSwaps(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if (!stack.isEmpty()) {
                stack.pop();
            } else {
                count++;
            }
        }
        count = (count + 1) / 2;
        return count;
    }

    public static void main(String[] args) {
        String str = "]]]][[[[";
        int i = new MinNoOfSwapsStringBalanced().minSwaps(str);
        System.out.println(i);
    }
}
