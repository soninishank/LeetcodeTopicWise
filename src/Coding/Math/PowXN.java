package Coding.Math;

// https://leetcode.com/problems/powx-n/
public class PowXN {

    // 1.if condition -> power is 0 then return 1
    // 2. if n < 0 -> then change n to positive value and x will be 1/x;
    // 3. if power % 2 == 0
    //    1.  2^10 = 4^5
    //    2.  4^5 -> power is odd  you can write like  4^2.4^2.4 -> 16^4.4


    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            n = -n;
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
}
