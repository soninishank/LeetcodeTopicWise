package Coding.Array;

import java.util.Arrays;

// https://leetcode.com/problems/sort-colors/
public class SortColors {
    public void sortColors(int[] nums) {
        int low = 0, high = nums.length - 1;
        int currentIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[currentIndex] == 0) {
                int temp = nums[low];
                nums[low] = nums[currentIndex];
                nums[currentIndex] = temp;
                low++;
                currentIndex++;
            } else if (nums[currentIndex] == 2) {
                int temp = nums[high];
                nums[high] = nums[currentIndex];
                nums[currentIndex] = temp;
                high--;
                // currentIndex++;
                // we don't need to move this because when high becomes less than currentIndex we are
                // swapping the wrong values , high is like a boundary for 2nd pointer
            } else if (nums[currentIndex] == 1) {
                currentIndex++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        new SortColors().sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
