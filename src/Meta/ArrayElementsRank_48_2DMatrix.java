package Meta;

import java.util.*;

// https://leetcode.com/problems/rank-transform-of-a-matrix/
public class ArrayElementsRank_48_2DMatrix {

    public int[][] matrixRankTransform(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Step 1: Create a list of elements with their coordinates and sort by value
        List<int[]> elements = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                elements.add(new int[]{matrix[i][j], i, j});
            }
        }
        elements.sort(Comparator.comparingInt(a -> a[0]));

        // Step 2: Initialize max rank trackers for rows and columns
        int[] rowMax = new int[rows];
        int[] colMax = new int[cols];
        int[][] result = new int[rows][cols];

        // Step 3: Assign ranks while processing elements in sorted order
        for (int i = 0; i < elements.size(); ) {
            int value = elements.get(i)[0];
            List<int[]> group = new ArrayList<>();

            // Group elements with the same value
            while (i < elements.size() && elements.get(i)[0] == value) {
                group.add(elements.get(i));
                i++;
            }

            // Use a temporary rank map to avoid premature updates
            Map<Integer, Integer> tempRowMax = new HashMap<>();
            Map<Integer, Integer> tempColMax = new HashMap<>();

            // Compute ranks for the group
            for (int[] elem : group) {
                int row = elem[1], col = elem[2];
                int rank = Math.max(rowMax[row], colMax[col]) + 1;
                result[row][col] = rank;

                // Store the temporary updates
                tempRowMax.put(row, Math.max(tempRowMax.getOrDefault(row, 0), rank));
                tempColMax.put(col, Math.max(tempColMax.getOrDefault(col, 0), rank));
            }

            // Apply temporary updates to rowMax and colMax
            for (Map.Entry<Integer, Integer> entry : tempRowMax.entrySet()) {
                rowMax[entry.getKey()] = entry.getValue();
            }
            for (Map.Entry<Integer, Integer> entry : tempColMax.entrySet()) {
                colMax[entry.getKey()] = entry.getValue();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayElementsRank_48_2DMatrix mrt = new ArrayElementsRank_48_2DMatrix();
        int[][] matrix1 = {{10, 20, 30}, {40, 50, 60}};
        int[][] matrix2 = {{10, 20, 60}, {30, 50, 40}};

        System.out.println(Arrays.deepToString(mrt.matrixRankTransform(matrix1))); // [[1, 2, 3], [2, 3, 4]]
        System.out.println(Arrays.deepToString(mrt.matrixRankTransform(matrix2))); // [[1, 2, 4], [2, 4, 3]]
    }
}
