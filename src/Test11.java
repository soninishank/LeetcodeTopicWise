public class Test11 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        return applyRecursion(coins, amount);
    }

    int applyRecursion(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int val = applyRecursion(coins, amount - coins[i]);
            if (val != -1) {
                max = 1 + Math.min(val, max);
            }
        }
        return max;
    }

    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        return applyDP(n, k, target, dp);
    }

    private int applyDP(int n, int k, int target, int[][] dp) {
        if (n == 0 && target == 0) {
            return 1;
        }
        if (n == 0 && target > 0) {
            return 0;
        }
        if (target < 0) {
            return 0;
        }
        if (dp[n][target] != 0) {
            return dp[n][target];
        }
        int result = 0;
        for (int i = 1; i <= k; i++) {
            result = (result + applyDP(n - 1, k, target - i,dp)) % (10 ^ 9 + 7);
            dp[n][target] = result;
        }
        return dp[n][target];
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2};
//        int n = 11;
//        int i = new Test11().applyRecursion(arr, n);
//        System.out.println(i);
        int i = new Test11().numRollsToTarget(1, 6, 3);
        System.out.println(i);

    }
}
