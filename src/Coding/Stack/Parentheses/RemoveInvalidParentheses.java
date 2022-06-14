package Coding.Stack.Parentheses;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        char[] check = new char[]{'(', ')'};
        dfs(s, res, check, 0, 0);
        return res;
    }

    public static void dfs(String s, List<String> res, char[] check, int last_i, int last_j) {
        int count = 0;
        int i = last_i;
        while (i < s.length() && count >= 0) {
            if (s.charAt(i) == check[0]) {
                count++;
            } else if (s.charAt(i) == check[1]) {
                count--;
            }
            i++;
        }

        if (count >= 0) {
            // no extra ')' is detected. We now have to detect extra '(' by reversing the string.
            String reversed = new StringBuffer(s).reverse().toString();
            if (check[0] == '(') {
                dfs(reversed, res, new char[]{')', '('}, 0, 0);
            } else {
                res.add(reversed);
            }

        } else {  // extra ')' is detected, and we have to do something
            i -= 1; // 'i-1' is the index of abnormal ')' which makes count<0
            for (int j = last_j; j <= i; j++) {
                if (s.charAt(j) == check[1]) {
                    if (j == last_j || s.charAt(j - 1) != check[1]) {
                        dfs(s.substring(0, j) + s.substring(j + 1), res, check, i, j);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String s = "()())";
        List<String> strings = new RemoveInvalidParentheses().removeInvalidParentheses(s);
        System.out.println(strings);
    }
}

// ()())
// )()()