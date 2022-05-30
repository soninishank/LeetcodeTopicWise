package Coding.Stack.Design;

import java.util.Stack;

public class MaxStack {

    Stack<Integer> stack;
    Stack<Integer> maxStack;

    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        if (maxStack.isEmpty()) {
            maxStack.push(x);
        } else {
            if (maxStack.peek() > x) {
                maxStack.push(maxStack.peek());
            }
        }
        stack.push(x);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        Integer popMax = maxStack.peek();
        Stack<Integer> temp = new Stack<>();
        while (stack.peek() != popMax) {
            temp.push(pop());
        }
        // again pop - after the match
        pop();
        while (!temp.isEmpty()) {
            push(temp.pop());
        }
        return popMax;
    }
}

// maxStack - { 3,3,3}
// stack - {}
