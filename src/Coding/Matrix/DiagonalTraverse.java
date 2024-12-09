package Coding.Matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/diagonal-traverse/
public class DiagonalTraverse {
    HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

    // using hashmap
    public int[] findDiagonalOrderUsingHashmap(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (!hashMap.containsKey(i + j)) {
                    hashMap.put(i + j, new ArrayList<>());
                }
                hashMap.get(i + j).add(mat[i][j]);
            }
        }
        boolean flag = true;
        int[] result = new int[mat.length * mat[0].length];
        int index = 0;
        for (int key : hashMap.keySet()) {
            List<Integer> list = hashMap.get(key);
            if (flag) {
                for (int i = list.size() - 1; i >= 0; i--) {
                    result[index] = list.get(i);
                    index++;
                }
            } else {
                for (int num : list) {
                    result[index] = num;
                    index++;
                }
            }
            flag = !flag;
        }
        return result;
    }

    // using simulation
    // Analyze diagram
    // 1. when row = first, last -> change direction
    // 2. When col = first, last -> change a direction
    // 3. When row = first, last, col++
    // 4. When col = first,last, row++
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[0];
        }
        int rowLength = mat.length;
        int colLength = mat[0].length;
        int[] result = new int[rowLength * colLength];
        int row = 0, col = 0, direction = 1;

        for (int i = 0; i < result.length; i++) {
            result[i] = mat[row][col];
            if (direction == 1) { // Moving upward
                if (col == colLength - 1) { // Hit the last column
                    row++;
                    direction = -1;
                } else if (row == 0) { // Hit the first row
                    col++;
                    direction = -1;
                } else { // Move diagonally up
                    row--;
                    col++;
                }
            } else { // Moving downward
                if (row == rowLength - 1) { // Hit the last row
                    col++;
                    direction = 1;
                } else if (col == 0) { // Hit the first column
                    row++;
                    direction = 1;
                } else { // Move diagonally down
                    row++;
                    col--;
                }
            }
        }
        return result;
    }
}
