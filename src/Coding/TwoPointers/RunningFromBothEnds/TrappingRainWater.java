package Coding.TwoPointers.RunningFromBothEnds;

/**
 * @author Nishank Soni
 * @project Leet Code Topic Wise on 4/1/22
 */
// https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {
    public int trap(int[] height) {
        int low = 0, high = height.length - 1;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int result = 0;
        while (low <= high) {
            leftMax = Math.max(leftMax, height[low]);
            rightMax = Math.max(rightMax, height[high]);
            if (leftMax < rightMax) {
                result += Math.min(leftMax, rightMax) - height[low];
                low++;
            } else {
                result += Math.min(leftMax, rightMax) - height[high];
                high--;
            }
        }
        return result;
    }
}
