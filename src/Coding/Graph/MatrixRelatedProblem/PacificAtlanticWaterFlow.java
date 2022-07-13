package Coding.Graph.MatrixRelatedProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        boolean[][] pacific = new boolean[rowLength][colLength];
        boolean[][] atlantic = new boolean[rowLength][colLength];

        for (int j = 0; j < colLength; j++) {
            dfs(0, j, pacific, matrix, Integer.MIN_VALUE); // row is 0 amd col = 0
            dfs(rowLength - 1, j, atlantic, matrix, Integer.MIN_VALUE); // last row & first col
        }
        System.out.println(Arrays.deepToString(pacific));
        System.out.println();
        System.out.println(Arrays.deepToString(atlantic));

        for (int i = 0; i < rowLength; i++) {
            dfs(i, 0, pacific, matrix, Integer.MIN_VALUE);
            dfs(i, colLength - 1, atlantic, matrix, Integer.MIN_VALUE);
        }
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> indexes = new ArrayList<>();
                    indexes.add(i);
                    indexes.add(j);
                    ans.add(indexes);
                }
            }
        }
        return ans;
    }


    private void dfs(int i, int j, boolean[][] canReach, int[][] matrix, int prevHeight) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || canReach[i][j] || matrix[i][j] < prevHeight) {
            return;
        }
        canReach[i][j] = true;
        dfs(i + 1, j, canReach, matrix, matrix[i][j]);
        dfs(i - 1, j, canReach, matrix, matrix[i][j]);
        dfs(i, j - 1, canReach, matrix, matrix[i][j]);
        dfs(i, j + 1, canReach, matrix, matrix[i][j]);
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        List<List<Integer>> lists = new PacificAtlanticWaterFlow().pacificAtlantic(arr);
        System.out.println(lists);
    }
}
