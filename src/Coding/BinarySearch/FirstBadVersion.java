package Coding.BinarySearch;

// https://leetcode.com/problems/first-bad-version/
// FFFF TTTT
// Lets suppose you got 2nd index on true it means you still have need to go on left side but you are not sure whaether its true or not
// store 2nd index true value & move to left side - high = mid else low = mid+1
public class FirstBadVersion {
    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int low = 1, high = n;
            while (low < high) {
                int mid = low + (high - low) / 2;
                // if its true
                if (isBadVersion(mid)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }
}
