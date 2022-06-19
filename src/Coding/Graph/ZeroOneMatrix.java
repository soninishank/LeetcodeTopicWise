package Coding.Graph;

import java.util.Arrays;

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    calculateDistance(i, j, mat, 1, 0);
                }
            }
        }
    }

    private void calculateDistance(int row, int col, int[][] mat, int currentVal, int searchValue) {
        if (row < 0 || col < 0 || row > mat.length - 1 || col > mat[0].length - 1) {
            return;
        }
        if (mat[row][col] == 1){
            mat[row][col]
            return ;
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] ints = new ZeroOneMatrix().updateMatrix(mat);
        System.out.println(Arrays.deepToString(ints));
    }
}
