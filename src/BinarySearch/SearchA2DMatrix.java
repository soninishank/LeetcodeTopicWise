package BinarySearch;

// https://leetcode.com/problems/search-a-2d-matrix/
public class SearchA2DMatrix {
    // Think of it like as a sorted sequence
    // So you have an index from 0 to total length which is (matrix.length * matrix[0].length -1)
    // low = 0 , high = 11 , middle = 5
    // now to get the value at middle  index 5 -> [5/col.length][5 % col.length]
    // [5/col.length] -> rowIndex
    // [[5%col.length] -> colIndex

    // normal binary search
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, high = matrix.length * matrix[0].length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int matrixValue = matrix[mid / matrix[0].length][mid % matrix[0].length];
            if (matrixValue == target) {
                return true;
            } else if (matrixValue < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        boolean b = new SearchA2DMatrix().searchMatrix(matrix, 3);
        System.out.println(b);
    }
}
