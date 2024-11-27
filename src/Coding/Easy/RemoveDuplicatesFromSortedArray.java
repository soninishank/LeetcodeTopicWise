package Coding.Easy;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesFromSortedArray {
    // Just a dry run
    // Doesn't panic - its very easy
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int low = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[low]) {
                continue;
            } else // swap
            {
                low++;
                int temp = nums[low];
                nums[low] = nums[i];
                nums[i] = temp;
            }
        }
        return low + 1;
    }

    public int removeDuplicatesUsingCursorIndex(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int cursorIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[cursorIndex] = nums[i];
                cursorIndex++;
            }
        }
        return cursorIndex;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}; // 1,1,2 -
        int i = new RemoveDuplicatesFromSortedArray().removeDuplicates(arr);
        System.out.println(i);
    }
}
