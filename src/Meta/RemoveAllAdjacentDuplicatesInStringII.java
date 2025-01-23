package Meta;

import java.util.Stack;

// https://leetcode.com/discuss/interview-question/380650/Bloomberg-or-Phone-Screen-or-Candy-Crush-1D
// 1D Candy crush
// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
public class RemoveAllAdjacentDuplicatesInStringII {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            // existing one
            if (!stack.isEmpty() && stack.peek()[0] == ch) {
                stack.peek()[1]++;
            } else {
                stack.push(new int[]{ch, 1});
            }
            if (stack.peek()[1] == k) {
                stack.pop();
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            int[] topArr = stack.pop();
            // we need to build the string
            // the times it is repeating
            while (topArr[1] > 0) {
                builder.append((char) topArr[0]);
                topArr[1]--;
            }
        }
        return builder.reverse().toString();
    }
}
