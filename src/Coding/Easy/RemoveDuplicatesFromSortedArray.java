package Coding.Easy;

public class RemoveDuplicatesFromSortedArray {
    // Just dry run
    // Don't panic - its very easy
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

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}; // 1,1,2 -
        int i = new RemoveDuplicatesFromSortedArray().removeDuplicates(arr);
        System.out.println(i);
    }
}
