package Coding.Stack.Design;

// The list works like LIFO
// https://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/
// https://leetcode.com/problems/min-stack/
public class MinStack {
    MinNodeData head;

    private MinStack() {
    }

    private void push(int val) {
        if (head == null) { // when head is null then minValue and current value will be same  and also nodePtr is null
            head = new MinNodeData(val, val, null);
        } else {
            head = new MinNodeData(val, Math.min(val, head.minValue), head); // passing reference of head pointer
        }
    }

    private void pop() {
        head = head.next;
    }

    private int top() {
        return head.value;
    }

    private int getMin() {
        return head.minValue;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2
    }

    class MinNodeData {
        int value;
        int minValue;
        MinNodeData next;

        private MinNodeData(int value, int minValue, MinNodeData nodePtr) {
            this.value = value;
            this.minValue = minValue;
            this.next = nodePtr;
        }
    }
}