package Coding.BinarySearch;

// https://leetcode.com/problems/find-peak-element/
// https://leetcode.com/problems/find-peak-element/discuss/1290642/intuition-behind-conditions-complete-explanation-diagram-binary-search
// https://www.youtube.com/watch?v=a7D77DdhlFc
// https://leetcode.com/problems/peak-index-in-a-mountain-array/
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0; // single element
        }
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }

    public int peakIndexInMountainArray(int[] arr) {
        int low = 0, high = arr.length - 1;
        // loop will break when low == high so you can return anything low or high
        while (low < high) {
            int mid = low + (high - low) / 2;
            // It means there is a bigger element present in right
            // Also arr[mid+1] will not throw any exception because
            // low < high
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            }
            // Otherwise, if nums[mid] >= nums[mid + 1], it means the peak is either at mid or
            // to the left of mid. So, we update high = mid to search the left half of the array.
            else {
                high = mid;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int peakElement = new FindPeakElement().findPeakElement(nums);
        System.out.println(peakElement);
    }
}


