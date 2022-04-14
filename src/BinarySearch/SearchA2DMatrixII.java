package BinarySearch;

// https://leetcode.com/problems/search-a-2d-matrix-ii/
// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.
public class SearchA2DMatrixII {
    // start from top right corner means last col and first row
    // boundary condition will be last col with traverse till col is zero and first row will traverse till
    // last row
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, high = matrix[0].length - 1;
        while (low < matrix.length && high >= 0) {
            if (matrix[low][high] == target) {
                return true;
            } else if (matrix[low][high] > target) {
                high--; // reducing column
            } else {
                low++; // increasing row
            }
        }
        return false;
    }
}
