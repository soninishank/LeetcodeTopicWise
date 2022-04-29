package Coding.TwoPointers.RunningFromBothEnds;

/**
 * @author Nishank Soni
 * @project Leet Code Topic Wise on 4/1/22
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int index = result.length - 1;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            if (Math.abs(nums[low]) < Math.abs(nums[high])) {
                result[index] = nums[high] * nums[high];
                high--;
            } else {
                result[index] = nums[low] * nums[low];
                low++;
            }
            index--;
        }
        return result;
    }
}

// -4,-1,0,3,10
// 4,1,0,3,10
