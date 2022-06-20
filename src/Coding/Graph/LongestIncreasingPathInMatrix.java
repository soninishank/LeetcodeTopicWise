package Coding.Graph;

// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
public class LongestIncreasingPathInMatrix {
    int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        int totalRow = matrix.length;
        int totalCol = matrix[0].length;
        int[][] cache = new int[totalRow][totalCol];
        int result = 1;
        for (int i = 0; i < totalRow; i++) {
            for (int j = 0; j < totalCol; j++) {
                int currentMax = applyDFS(i, j, matrix, cache);
                result = Math.max(result, currentMax);
            }
        }
        return result;
    }

    private int applyDFS(int row, int col, int[][] matrix, int[][] cache) {
        if (row < 0 || col < 0 || row > matrix.length - 1 || col > matrix[0].length - 1) {
            return 0;
        }
        if (cache[row][col] > 0) {
            return cache[row][col];
        }
        int currentLength = 1;
        for (int[] dir : direction) {
            int newX = row + dir[0];
            int newY = col + dir[1];
            if (newX < 0 || newY < 0 || newX > matrix.length - 1 || newY > matrix[0].length - 1) {
                continue;
            }
            if (matrix[newX][newY] > matrix[row][col]) {
                currentLength = Math.max(currentLength, 1 + applyDFS(newX, newY, matrix, cache));
            }
        }
        cache[row][col] = currentLength;
        return currentLength;
    }

    public static void main(String[] args) {
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        int i = new LongestIncreasingPathInMatrix().longestIncreasingPath(matrix);
        System.out.println(i);
    }
}
