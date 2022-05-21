package Coding.Stack.Math;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


// same solution
// https://leetcode.com/problems/basic-calculator-iii/
// https://leetcode.com/problems/basic-calculator/
public class BasicCalculatorIII {

    Queue<Character> queue = new LinkedList<>();
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        for (Character character : s.toCharArray()) {
            queue.add(character);
        }
        return calculateOperation(queue);
    }

    private int calculateOperation(Queue<Character> queue) {
        if (queue.isEmpty()) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        char prevOperation = '+';
        int num = 0;
        while (!queue.isEmpty()) {
            Character currentPollEle = queue.poll();
            if (Character.isDigit(currentPollEle)) {
                num = 10 * num + currentPollEle - '0';
            } else if ("+-*/".indexOf(currentPollEle) >= 0) {
                evalOperation(stack, prevOperation, num); // dump the data
                prevOperation = currentPollEle;
                num = 0;
            } else if (currentPollEle.equals('(')) {
                num = calculateOperation(queue); // recursion - storing again in num
            } else if (currentPollEle.equals(')')) {
                break;
            }
        }
        evalOperation(stack, prevOperation, num);
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    private void evalOperation(Stack<Integer> stack, char prevOperation, int num) {
        if (prevOperation == '+') {
            stack.push(num);
            return;
        } else if (prevOperation == '-') {
            stack.push(-num);
            return;
        } else if (prevOperation == '*') {
            stack.push(stack.pop() * num);
        } else if (prevOperation == '/') {
            stack.push(stack.pop() / num);
            return;
        }
    }

    public static void main(String[] args) {
        String s = "2*(5+5*2)/3+(6/2+8)";
        int calculate = new BasicCalculatorIII().calculate(s);
        System.out.println(calculate);
    }
}
