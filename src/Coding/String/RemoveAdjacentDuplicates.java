package Coding.String;

import java.util.Stack;

// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
// 1209. Remove All Adjacent Duplicates in String II
public class RemoveAdjacentDuplicates {
    Stack<Pair> stack = new Stack<>();

    public String removeDuplicates(String s, int k) {
        if (s.length() == 0) {
            return "";
        }
        if (k == 0) {
            return s;
        }
        char[] ch = s.toCharArray();
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < ch.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new Pair(ch[i], 1));
            } else if (stack.peek().val != ch[i]) {
                stack.push(new Pair(ch[i], 1));
            } else if (stack.peek().val == ch[i]) {
                if (stack.peek().count + 1 == k) {
                    stack.pop();
                } else {
                    Pair pop = stack.pop();
                    stack.push(new Pair(pop.val, pop.count + 1));
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair pop = stack.pop();
            for (int i = 0; i < pop.count; i++) {
                builder.append(pop.val);
            }
        }
        return builder.reverse().toString();
    }

    class Pair {
        Character val;
        int count;

        public Pair(Character val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;
        String s1 = new RemoveAdjacentDuplicates().removeDuplicates(s, k);
        System.out.println(s1);
    }
}

// "pbbcggttciiippooaais"
//2
