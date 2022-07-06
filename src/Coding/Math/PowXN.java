package Coding.Math;

// https://leetcode.com/problems/powx-n/
// Time complexity - O(logN)
// Space complexity - O(logN)
public class PowXN {

    // 1.if condition -> power is 0 then return 1
    // 2. if n < 0 -> then change n to positive value and x will be 1/x;
    // 3. if power % 2 == 0
    //    1.  2^10 = 4^5
    //    2.  4^5 -> power is odd  you can write like  4^2.4^2.4 -> 16^4.4
    // 1. Recursion
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            n = -n; // negative become positive
            x = 1 / x;
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

    // Handling overflow
    public double myPowOptimized(double x, int n) {
        if (n == 0) return 1;
        if (n == Integer.MIN_VALUE && x > 1) return 0;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

    // Iterative solution
    public double myPowIterative(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                ans *= x;
            }
            x *= x;
            n >>= 1;
        }
        return ans;
    }
}
