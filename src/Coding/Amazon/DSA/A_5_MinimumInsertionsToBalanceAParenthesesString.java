package Coding.Amazon.DSA;

// https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
// We just need to find total insertions required
public class A_5_MinimumInsertionsToBalanceAParenthesesString {
    public int minInsertions(String s) {
        int insertions = 0; // Count of insertions needed
        int balance = 0; // Keeps track of unmatched '('

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                // If we encounter '(', we expect 2 ')' later
                balance += 2;

                // If balance is odd, we need one more ')'
                if (balance % 2 != 0) {
                    insertions++;
                    balance--; // Adjust balance
                }
            } else { // c == ')'
                // Decrease the balance as we found a ')'
                balance--;

                // If balance goes negative, we need to insert '('
                if (balance < 0) {
                    insertions++;
                    balance = 1; // Reset balance to expect one more ')'
                }
            }
        }
        // After traversing, add the remaining unmatched ')' to insertions
        insertions += balance;
        return insertions;
    }

    public static void main(String[] args) {
        String s = ")(";
        int i = new A_5_MinimumInsertionsToBalanceAParenthesesString().minInsertions(s);
        System.out.println(i);
    }
}
