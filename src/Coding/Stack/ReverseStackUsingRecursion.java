package Coding.Stack;

import java.util.Stack;

// https://www.techiedelight.com/reverse-stack-using-recursion/
public class ReverseStackUsingRecursion {

    void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        // Pop all items from the stack and hold them in the call stack
        Integer pop = stack.pop();
        reverse(stack);
        // After the recursion unfolds, insert each item in the call stack at the bottom of the stack
        insertNow(pop, stack);
        return;
    }

    private static void insertNow(Integer item, Stack<Integer> stack) {
        if (stack.isEmpty()) {
            stack.push(item);
            return;
        }
        Integer top = stack.pop();
        insertNow(item, stack);
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack);

        new ReverseStackUsingRecursion().reverse(stack);

        System.out.println(stack);
    }
}
