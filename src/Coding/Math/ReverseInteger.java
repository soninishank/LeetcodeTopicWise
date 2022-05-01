package Coding.Math;

// While I understand the way of thinking of the author and most of the comments here, I do believe (and tested as well)
// that it is not required to check that. Think about it: try to create a test case that actually fulfil this statement:
// "rev == Integer.MAX_VALUE / 10 && pop > 7". For that to happen, let us imagine pop is 8,
// and rev will have to be 214748364. Working this backwards, this means x (the input to this problem) is
// something like 8463847412. This is not even possible because x, by nature, has an upper bound 2147483647.
// Clearly 8463847412 > 2147483647. Essentially this means it is impossible to craft such extreme test cases.
// (This remains true even if pop was imagined to be 9. Same applies to the negative case.)
public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int temp = x % 10;
            if (result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10) {
                return 0;
            }
            result = result * 10 + temp; // this will overflow so we can check before only
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        int reverse = new ReverseInteger().reverse(-2147483648);
        System.out.println(reverse);
    }
}
