package Coding.BinarySearch;

// https://leetcode.com/problems/sqrtx/
public class SqrtX {
    // Firstly understand the question
    // 4 - sqrt(4) - 2
    // 5 - sqrt(5) - 2
    // 8 - sqrt(8) - 2
    // if you think for 8 we are taking lowest part - 1
    // mid * mid > k  it means you need to go in lower side
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int low = 2, high = x;
        while (low < high) {
            int mid = low + (high - low) / 2;
            // if its true
            if (mid > x / mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low - 1;
    }
}
