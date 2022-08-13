package Coding.Recursion;

public class Triangle {
    public int minimumTotal(int[][] triangle) {
        return helper(triangle, 0, 0);
    }

    private int helper(int[][] triangle, int row, int col) {
        if (row == triangle.length) {
            return 0;
        }
        int val1 = helper(triangle, row + 1, col); // 1 0
        int val2 = helper(triangle, row + 1, col + 1); // 1  1
        int current = triangle[row][col];
        int result = current + Math.min(val1, val2);
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        int i = new Triangle().minimumTotal(arr);
        System.out.println(i);
    }
}
// 2
// 3 4
// 6 5 7
// 4 1 8 3

