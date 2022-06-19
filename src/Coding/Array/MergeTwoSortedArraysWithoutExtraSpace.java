package Coding.Array;

public class MergeTwoSortedArraysWithoutExtraSpace {

    void merge(int[] X, int[] Y) {
        int m = X.length;
        int n = Y.length;
        for (int i = 0; i < m; i++) {
            if (X[i] > Y[0]) {
                // swap
                int temp = X[i];
                X[i] = Y[0];
                Y[0] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int X[] = {1, 4, 7, 8, 10};
        int Y[] = {2, 3, 9};
        new MergeTwoSortedArraysWithoutExtraSpace().merge(X, Y);
    }
}
