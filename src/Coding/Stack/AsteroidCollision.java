package Coding.Stack;

import java.util.Stack;

// https://leetcode.com/problems/asteroid-collision/
public class AsteroidCollision {
    // collision will only occur if
    // +ve  --->    <--- -ve
    // stack.top() > 0
    // && asteroids[i] < 0
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            // when collision happens
            while (!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0) {
                int sum = asteroids[i] + stack.peek();

                if (sum < 0) {
                    stack.pop(); // it means i want to remove the exisiting element
                } else if (sum > 0) {
                    asteroids[i] = 0; // this is used for braking the while loop last condition
                } else if (sum == 0) {
                    stack.pop();
                    asteroids[i] = 0; // it will help to break the loop
                }
            }
            // else push everything in stack except it is zero
            if (asteroids[i] != 0) {
                stack.push(asteroids[i]);
            }
        }

        int length = stack.size();
        int[] result = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
