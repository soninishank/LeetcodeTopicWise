package Meta;

// https://chatgpt.com/c/6769051b-2800-8008-8938-2536dead669f
public class PowerXN {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1 / (x * myPow(x, Integer.MAX_VALUE));
            }
            x = 1 / x;
            n = -n;
        }
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            return x * myPow(x * x, n / 2);
        }
    }
}
