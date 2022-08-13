package Coding.Recursion;

public class PaintHouse {
    public int minCost(int[][] costs) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < costs[0].length; i++) {
            int firstRow = costs[0][i];
            int nextRowRes = applyRecursion(costs, 1, i);
            result = Math.min(result, firstRow + nextRowRes);
        }
        return result;
    }

    int applyRecursion(int[][] costs, int rowNo, int colNo) {
        if (rowNo > costs.length - 1) {
            return 0;
        }
        if (colNo > costs[rowNo].length - 1) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < costs[rowNo].length; i++) {
            if (i == colNo) {
                continue;
            } else {
                result = Math.min(result, costs[rowNo][i] + applyRecursion(costs, rowNo + 1, i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        int i = new PaintHouse().minCost(arr);
        System.out.println(i);
    }
}
