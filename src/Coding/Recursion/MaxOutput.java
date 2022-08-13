package Coding.Recursion;

public class MaxOutput {

    private int getMaxNo(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        return applyRecursion(arr, 0);
    }

    private int applyRecursion(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index];
        }
        int first = arr[index] + applyRecursion(arr, index + 1);
        int second = arr[index] * applyRecursion(arr, index + 1);
        return Math.max(first, second);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4};
        int maxNo = new MaxOutput().getMaxNo(arr);
        System.out.println(maxNo);
    }
}

// 1 + 2 * 4