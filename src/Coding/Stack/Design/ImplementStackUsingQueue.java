package Coding.Stack.Design;

import java.util.LinkedList;
import java.util.Queue;

// Draw on pen and paper
// helperQueue is used only at the time of pop
// we will maintain topValue variable - always the newly inserted element is top element and when poping out
// from main queue last element is top element
// https://leetcode.com/problems/implement-stack-using-queues/
public class ImplementStackUsingQueue {
    Queue<Integer> mainQueue = new LinkedList<>();
    Queue<Integer> helperQueue = new LinkedList<>();

    int topValue;

    public ImplementStackUsingQueue() {

    }

    public void push(int x) {
        topValue = x;
        mainQueue.add(x);
    }

    public int pop() {
        while (mainQueue.size() > 1) {
            topValue = mainQueue.poll();
            helperQueue.add(topValue);
        }
        int value = mainQueue.poll();
        while (helperQueue.size() > 0) {
            mainQueue.add(helperQueue.poll());
        }
        return value;
    }

    public int top() {
        return topValue;
    }

    public boolean empty() {
        return mainQueue.isEmpty() && helperQueue.isEmpty();
    }


}
