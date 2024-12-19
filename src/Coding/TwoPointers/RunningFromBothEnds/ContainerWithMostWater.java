package Coding.TwoPointers.RunningFromBothEnds;

// https://leetcode.com/problems/container-with-most-water/
// 11. Container With Most Water

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0; // To store the maximum area found
        int low = 0, high = height.length - 1;

        // Two-pointer approach
        while (low < high) {
            // Calculate the width and the smaller height
            int width = high - low;
            int smallHeight = Math.min(height[low], height[high]);

            // Update the maximum area if the current area is larger
            maxArea = Math.max(maxArea, width * smallHeight);

            // Move the pointer if the currentHeight[low] is smaller
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return maxArea;
    }

}
