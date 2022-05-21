package Coding.Stack;

import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/problems/simplify-path/
// . -> same directory
// .. -> previous directory
public class SimplifyPath {
    Stack<String> stack = new Stack<>();

    public String simplifyPath(String path) {
        String[] str = path.split("/"); // /home/ -> ["","home"]
        System.out.println(Arrays.deepToString(str));
        for (String c : str) {
            if (c.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (c.equals(".") || c.equals("")) {
                continue;
            } else {
                stack.push(c);
            }
        }
        StringBuilder strBuilder = new StringBuilder();
        // with for each - you will get the ordering in FIFO manner
        for (String a : stack) {
            strBuilder.append("/"); // folder structure starts from /
            strBuilder.append(a);
        }
        if (strBuilder.length() > 0) {
            return strBuilder.toString();
        } else {
            return "/";
        }
    }

    public static void main(String[] args) {
        String s = new SimplifyPath().simplifyPath("/home//foo/");
        System.out.println(s);
    }
}
