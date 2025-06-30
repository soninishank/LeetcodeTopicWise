package Coding.Recursion;

import java.util.Arrays;

public class ClimbingStairs {
    public int climbStairsRecursion(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        int one_step = climbStairsRecursion(n - 1);
        int two_step = climbStairsRecursion(n - 2);
        return one_step + two_step;
    }

    public int climbStairs(int n) {
        if (n < 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return climbStairsMem(n, dp);
    }

    private int climbStairsMem(int n, int[] dp) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int one_step = climbStairsMem(n - 1, dp);
        int two_step = climbStairsMem(n - 2, dp);
        return dp[n] = one_step + two_step;
    }


    public int climbStairsBottomUp(int n) {
        if (n <= 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int i = new ClimbingStairs().climbStairs(3);
        System.out.println(i);
    }
}
