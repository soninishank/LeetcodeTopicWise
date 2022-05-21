package Coding.String;

import java.util.Stack;

// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
public class RemoveAdjacentDuplicates {
    Stack<Pair> stack = new Stack<>();

    public String removeDuplicates(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new Pair(chars[i], 1));
            } else if (stack.peek().name == chars[i]) {
                Pair pop = stack.pop();
                pop.count += 1;
                if (pop.count == k) {
                    continue;
                }
                stack.push(pop);
            } else {
                stack.push(new Pair(chars[i], 1));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair pop = stack.pop();
            int count = pop.count;
            char name = pop.name;
            while (count > 0) {
                stringBuilder.append(name);
                count--;
            }
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;
        String s1 = new RemoveAdjacentDuplicates().removeDuplicates(s, k);
        System.out.println(s1);
    }

    class Pair {
        char name;
        int count;

        public Pair(char name, int count) {
            this.name = name;
            this.count = count;
        }
    }
}

// "pbbcggttciiippooaais"
//2
