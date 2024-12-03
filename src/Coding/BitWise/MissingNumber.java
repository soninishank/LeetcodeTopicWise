package Coding.BitWise;

// https://leetcode.com/problems/missing-number/
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int result = 0;
        // we need to go to total length that's why it is i <= nums.length
        for (int i = 0; i <= nums.length; i++) {
            result = result ^ i;
        }
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
