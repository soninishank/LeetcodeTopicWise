package Coding.Amazon.DSA;

// https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
// We just need to find total insertions required
public class _5_MinimumInsertionsToBalanceAParenthesesString {
    public int minInsertions(String s) {
        int insertions = 0, i = 0, leftBracket = 0;
        while (i < s.length()) {
            char current = s.charAt(i);

            if (current == '(') {
                // Case 1: We found an opening bracket
                leftBracket++;
                i++;
            } else {
                // Current character is ')'
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    // We found two consecutive ')'
                    if (leftBracket > 0) {
                        // We have a matching '('
                        leftBracket--;
                    } else {
                        // No matching '(', need to add one
                        insertions++;
                    }
                    i += 2; // Skip both ')'
                } else {
                    // We only found single ')'
                    insertions++; // Need to insert another ')'
                    if (leftBracket > 0) {
                        leftBracket--;
                    } else {
                        insertions++; // Also need to insert '('
                    }
                    i++;
                }
            }
        }
        // For remaining '(' brackets, we need two ')' each
        insertions += leftBracket * 2;
        return insertions;
    }

    public static void main(String[] args) {
        String s = ")(";
        int i = new _5_MinimumInsertionsToBalanceAParenthesesString().minInsertions(s);
        System.out.println(i);
    }
}
