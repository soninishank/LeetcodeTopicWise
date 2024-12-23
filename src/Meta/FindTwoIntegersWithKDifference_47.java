package Meta;

public class FindTwoIntegersWithKDifference_47 {
    public static boolean findPairWithDifference(int[] arr, int k) {
        int low = 0, high = 1;
        int n = arr.length;

        while (low < n && high < n) {
            int diff = arr[high] - arr[low];

            if (low != high && diff == k) {
                return true;
            } else if (diff < k) {
                high++; // Increase the difference
            } else {
                low++; // Decrease the difference
            }
        }
        return false; // No such pair found
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 9, 10};
        int k1 = 3;
        System.out.println(findPairWithDifference(arr1, k1)); // Output: false

        int[] arr2 = {1, 2, 3, 5, 8};
        int k2 = 3;
        System.out.println(findPairWithDifference(arr2, k2)); // Output: true
    }
}
