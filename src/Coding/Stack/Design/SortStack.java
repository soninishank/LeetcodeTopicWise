package Coding.Stack.Design;

import java.util.Stack;

public class SortStack {

    // just keep moving one to another
    private Stack<Integer> sortAStack(Stack<Integer> stack) {
        Stack<Integer> sortedStack = new Stack<>();
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            while (!sortedStack.isEmpty() && sortedStack.peek() > pop) {
                stack.push(sortedStack.pop());
            }
            sortedStack.push(pop);
        }
        return sortedStack;
    }

    public static void main(String[] args) {
        int arr[] = {34, 3, 31, 98, 92, 23};
        Stack<Integer> stack = new Stack<>();
        for (int i : arr) {
            stack.add(i);
        }
        Stack<Integer> ints = new SortStack().sortAStack(stack);
        System.out.println(ints);

    }
}
