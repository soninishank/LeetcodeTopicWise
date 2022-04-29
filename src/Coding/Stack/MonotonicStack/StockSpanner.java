package Coding.Stack.MonotonicStack;

import java.util.Stack;

// https://leetcode.com/problems/online-stock-span/
// TODO - important
public class StockSpanner {

    Stack<StackIndex> stack;
    int index;

    public StockSpanner() {
        stack = new Stack<>();
        index = 0;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // return 1
        System.out.println(stockSpanner.next(80));  // return 1
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(70));  // return 2
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(75));  // return 4, because the last 4 prices
        System.out.println(stockSpanner.next(85));
    }

    public int next(int price) {
        while (!stack.isEmpty() && stack.peek().currentValue <= price) {
            stack.pop();
        }
        int value;
        if (stack.isEmpty()) {
            value = index + 1;
        } else {
            value = index - stack.peek().index;
        }
        stack.push(new StackIndex(price, index));
        index++;
        return value;
    }
}

