package Stack.MonotonicStack;

// https://leetcode.com/problems/maximal-rectangle/
// TODO
public class MaximalRectangle {

    private int maximalRectangle(char[][] matrix) {
        int maxRectangle = Integer.MIN_VALUE;
        int[] result = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int value = Character.getNumericValue(matrix[i][j]);
                if (value == 0) { // if the current value is zero it means you can't create  - find the largest rectangle containing only 1's
                    result[j] = 0;
                } else {
                    result[j] += value; // else above values
                }
            }
            maxRectangle = Math.max(maxRectangle, new LargestRectangleInHistogram().largestRectangleArea(result));
        }
        return maxRectangle;
    }

    public static void main(String[] args) {
        char[][] ch = {{'1', '0'}, {'0', '1'}};
        int i = new MaximalRectangle().maximalRectangle(ch);
        System.out.println(i);
    }
}
