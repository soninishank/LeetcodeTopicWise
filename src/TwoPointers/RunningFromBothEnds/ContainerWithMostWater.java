package TwoPointers.RunningFromBothEnds;

/**
 * @author Nishank Soni
 * @project Leet Code Topic Wise on 4/1/22
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int result = 0;
        int low = 0, high = height.length - 1;
        while (low < high) {
            int width = high - low;
            int smallHeight = Math.min(height[low], height[high]);
            result = Math.max(result, width * smallHeight);
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return result;
    }
}
