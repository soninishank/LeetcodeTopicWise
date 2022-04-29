package Coding.Tree.BinarySearchTree.Medium;

// https://leetcode.com/problems/unique-binary-search-trees/
// TODO : Important
public class UniqueBST {
    public int numTreesRecursive(int n) {
        int result = 0;
        if (n == 0 || n == 1) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            result += numTreesRecursive(i) * numTreesRecursive(n - i - 1);
        }
        return result;
    }

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {   // when i = 3 -> dp[0]dp[2] + dp[1]dp[1] + dp[2]dp[0]
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1]; // dp[j] will be always less than i - see above equation
                // dp[i-j-1] -> will give dp[2],dp[1],dp[0]
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        int i = new UniqueBST().numTrees(3);
        System.out.println(i);
    }
}
