package Coding.Recursion;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return 0;
        }
        return applyRecursion(coins, amount);

    }

    private int applyRecursion(int[] arr, int amount) {
        if (amount == 0) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= amount) {
                result += applyRecursion(arr, amount - arr[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {2, 5, 3, 6};
        long count = new CoinChange().coinChange(arr, 10);
        System.out.println(count);
    }
}
