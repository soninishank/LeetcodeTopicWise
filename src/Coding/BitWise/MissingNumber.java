package Coding.BitWise;

// https://leetcode.com/problems/missing-number/
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp = temp ^ nums[i];
        }
        temp ^= nums.length;
        for (int i = 0; i < nums.length; i++) {
            temp = temp ^ i;
        }
        return temp;
    }
}
