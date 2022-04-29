package Coding.Stack.Design;

import java.util.Stack;

// Draw on pen and paper - write expected output and see what you need to tinker in your stack
// just draw a stack and see what value it is returning for better understanding
// similar concept like last question - Implement stack using queue
// maintain top variable - only when main stack is empty or when poping put
// https://leetcode.com/problems/implement-queue-using-stacks/
public class ImplementQueueUsingStacks {
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> helperStack = new Stack<>();
    int topValue;

    public ImplementQueueUsingStacks() {

    }

    public void push(int x) {
        if (mainStack.isEmpty()) {
            topValue = x;
        }
        mainStack.push(x);
    }

    public int pop() {
        while (mainStack.size() > 1) {
            topValue = mainStack.pop();
            helperStack.add(topValue);
        }
        int pop = mainStack.pop();
        while (helperStack.size() > 0) {
            mainStack.push(helperStack.pop());
        }
        return pop;
    }

    public int peek() {
        return topValue;
    }

    public boolean empty() {
        return mainStack.isEmpty() && helperStack.isEmpty();
    }
}
