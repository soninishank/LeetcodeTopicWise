package Coding.Graph.MatrixRelatedProblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/01-matrix/
public class ZeroOneMatrix {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int col = mat[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    int distance = applyBFS(mat, i, j, rows, col);
                    System.out.println(distance);
                    mat[i][j] = distance;
                }
            }
        }
        return mat;
    }

    private int applyBFS(int[][] mat, int currentRow, int currentCol, int totalRows, int totalCol) {
        Queue<int[]> queue = new LinkedList<>();
        HashSet<int[]> visited = new HashSet<>();

        queue.add(new int[]{currentRow, currentCol});
        visited.add(new int[]{currentRow, currentCol});
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] dir : directions) {
                    int newRow = dir[0] + poll[0];
                    int newCol = dir[1] + poll[1];
                    if (newRow >= 0 && newCol >= 0 && newRow <= totalRows - 1 && newCol <= totalCol - 1 && mat[newRow][newCol] == 0 && !visited.contains(new int[]{newRow, newCol})) {
                        queue.add(new int[]{newRow, newCol});
                        visited.add(new int[]{newRow, newCol});
                    } else {
                        continue;
                    }
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] ints = new ZeroOneMatrix().updateMatrix(matrix);
        System.out.println(Arrays.deepToString(ints));
    }
}


//