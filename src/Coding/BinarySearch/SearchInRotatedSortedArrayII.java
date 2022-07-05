package Coding.BinarySearch;

// Just add this to handle the duplicates
// while (low < high && nums[low] == nums[low + 1]) {
//                low++;
//            }
//            while (low < high && nums[high] == nums[high - 1]) {
//                high--;
//            }
// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
// Time complexity is O(N) because of duplicates , if you don't have duplicates it will be O(logN)
// Space complexity is O(1)
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            while (low < high && nums[low] == nums[low + 1]) {
                low++;
            }
            while (low < high && nums[high] == nums[high - 1]) {
                high--;
            }
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            } // means target is between low and mid
            // than make high = mid-1 else low = mid+1;
            else if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target <= nums[high] && target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
