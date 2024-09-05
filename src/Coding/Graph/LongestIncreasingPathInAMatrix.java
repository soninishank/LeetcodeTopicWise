package Coding.Graph;

// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
// Time complexity - O(M * N)
// Space complexity - O(M * N)
public class LongestIncreasingPathInAMatrix {
    // Directions to move in the 4 possible directions (up, down, left, right)
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        m = matrix.length;
        n = matrix[0].length;
        // Memoization array to store the length of the longest path starting from each cell
        int[][] memo = new int[m][n];
        int longestPath = 0;
        // Try starting DFS from each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Compute the longest path starting from (i, j) and update the global maximum
                longestPath = Math.max(longestPath, dfs(matrix, i, j, memo));
            }
        }
        return longestPath;
    }

    // DFS function to compute the longest path starting from (i, j)
    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        // If the result is already computed, return it
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int maxLength = 1; // The minimum path length is 1 (the cell itself)
        // Explore all 4 possible directions
        for (int[] dir : DIRECTIONS) {
            int x = i + dir[0];
            int y = j + dir[1];
            // Check if the next cell is within bounds and has a greater value
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                // Recursively find the longest path from the neighboring cell
                int length = 1 + dfs(matrix, x, y, memo);
                maxLength = Math.max(maxLength, length);
            }
        }
        // Store the result in memoization array
        memo[i][j] = maxLength;
        return maxLength;
    }

    public static void main(String[] args) {
        LongestIncreasingPathInAMatrix solution = new LongestIncreasingPathInAMatrix();
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };

        System.out.println(solution.longestIncreasingPath(matrix)); // Output: 4
    }
}
