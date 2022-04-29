package Coding.Math;

public class SqrtX {
    // First way but it will get failed for input : 2147395599
    public int mySqrtWithoutOptimization(int x) {
        if (x < 2) {
            return x;
        }
        int low = 2, high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid * mid > x) {
                high = mid - 1;
            } else if (mid * mid < x) {
                low = mid + 1;
            } else if (mid * mid == x) {
                return mid;
            }
        }
        return high;
    }

    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int low = 2, high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid > x / mid) {
                high = mid - 1;
            } else if (mid < x / mid) {
                low = mid + 1;
            } else if (mid == x / mid) {
                return mid;
            }
        }
        return high; // dry run with the input - 8
    }
}
