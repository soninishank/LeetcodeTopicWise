package Coding.Matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZerosDiagonal {


    public static void main(String[] args) {
        int[][] arr = {{0, 1, 2, 4}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        new SetMatrixZerosDiagonal().setZeroes(arr);
    }

    private void setZeroes(int[][] arr) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        Set<Integer> diagSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                    diagSet.add(i + j);
                    diagSet.add(i - j);
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (rowSet.contains(i) || colSet.contains(j) || diagSet.contains(i - j) || diagSet.contains(i + j)) {
                    arr[i][j] = 0;
                }
            }
        }

        System.out.println(Arrays.deepToString(arr));
    }
}
