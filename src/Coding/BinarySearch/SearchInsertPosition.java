package Coding.BinarySearch;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            // if it's true
            if (nums[mid] >= target)  // 5 >= 5
            {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int i = new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 5);
        System.out.println(i);
    }
}
