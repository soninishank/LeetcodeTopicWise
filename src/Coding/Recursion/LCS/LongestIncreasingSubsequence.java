package Coding.Recursion.LCS;

public class LongestIncreasingSubsequence {

    private int lis(int arr[], int n) {
        return longestSubsequence(-1, 0, arr);
    }

    int longestSubsequence(int prev, int index, int[] nums) {
        if (index > nums.length - 1) {
            return 0;
        }
        int first = 0;
        if (prev == -1 || nums[prev] < nums[index]) {
            first = 1 + longestSubsequence(index, index + 1, nums); // prev becomes current
        }
        int second = longestSubsequence(prev, index + 1, nums);// prev is same
        return Math.max(first, second);
    }

    public static void main(String[] args) {
        int arr[] = {3, 10, 2, 1, 20};
        int lis = new LongestIncreasingSubsequence().lis(arr, arr.length);
        System.out.println(lis);
    }
}
