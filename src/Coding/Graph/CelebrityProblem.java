package Coding.Graph;

import java.util.Stack;

// Draw the diagram on pen and paper
// https://www.geeksforgeeks.org/the-celebrity-problem/
// https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1#
public class CelebrityProblem {
    private int findCelebrity(int[][] graph, int n) {
        int[] inbound = new int[n];
        int[] outbound = new int[n];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1) {
                    inbound[j]++;
                    outbound[i]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (inbound[i] > 0 && outbound[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    // O(N) time complexity
    private int celebrity(int graph[][], int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            // a knows b
            if (graph[a][b] == 1) {
                stack.push(b); // possible celebrity
            } else {
                stack.push(a); // possible celebrity - a does not knows b
            }
        }
        int ans = stack.peek();
        int countZero = 0;
        // if you draw the diagram you will find the complete row will be zero which is equal to no of elements - verify row
        for (int i = 0; i < n; i++) {
            if (graph[ans][i] == 0) {
                countZero++;
            }
        }
        if (countZero != n) {
            return -1;
        }
        //  if you draw the diagram you will find the complete column will be one except common row and column which is equal to n-1 elements - verify column
        int countOne = 0;
        for (int i = 0; i < n; i++) {
            if (graph[i][ans] == 1) {
                countOne++;
            }
        }
        if (countOne != n - 1) {
            return -1;
        }
        return ans;
    }

    // celebrity does not know anyone
    // but everyone knows the celebrity

//    public int findCelebrity(int n) {
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < n; i++) {
//            stack.push(i);
//        }
//        while (stack.size() > 1) {
//            Integer pop1 = stack.pop();
//            Integer pop2 = stack.pop();
//            if (knows(pop1, pop2)) {
//                stack.push(pop2); // pop1 is not a celebrity if it knows pop2
//            } else {
//                stack.push(pop1); // pop1 doesn't know pop2 , it means pop2 is not a celebrity
//            }
//        }
//        // Either way, one person is gonna get eliminated. At the end, you have one person left that might be a cele. You confirm that by do a walk through again.
//        int c = stack.pop();
//        for (int i = 0; i < n; i++) {
//            // if both are same - dont check it
//            if (i != c) {
//                // c knows anyone - it is not a celebrity
//                if (knows(c, i)) {
//                    return -1;
//                }
//                // if anyone does not know c
//                if (!knows(i, c)) {
//                    return -1;
//                }
//            }
//        }
//        return c;
//    }


    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0}, {0, 1, 0}, {1, 1, 1}};
        int celebrity = new CelebrityProblem().findCelebrity(arr, arr.length);
        System.out.println(celebrity);
    }
}
