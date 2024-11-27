package Coding.Stack.MonotonicStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/problems/buildings-with-an-ocean-view/
// 1762. Buildings With an Ocean View
// if there is no greater element to right it means building is having an ocean view
public class BuildingWithAnOceanView {
    public int[] findBuildings(int[] heights) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) { // we are adding only when stack is empty - it means it can clearly see
                list.add(i);
            }
            stack.push(i); // we need to add every element in stack at end
        }
        int[] result = new int[list.size()];
        int index = list.size() - 1;
        for (Integer integer : list) {
            result[index] = integer;
            index--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 1};
        // 2,2,2,2 -> only index 3
        int[] buildings = new BuildingWithAnOceanView().findBuildings(arr);
        System.out.println(Arrays.toString(buildings));
    }
}
