package Coding.Recursion;

public class RodCutting {

    int rodCut(int[] price, int n) {
        if (price.length == 0) {
            return 0;
        }
        return applyRecursion(price, n, n);
    }

    private int applyRecursion(int[] price, int n, int rodLength) {
        if (rodLength == 0) {
            return 0;
        }
        int maxValue = Integer.MIN_VALUE;
        for (int i = 1; i <= rodLength; i++) {
            if (i <= rodLength) {
                int val = price[i-1] + applyRecursion(price, n, rodLength - i);
                maxValue = Math.max(maxValue,val);
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9, 10, 17, 17, 20};
        int i = new RodCutting().rodCut(arr, 4);
        System.out.println(i);
    }
}
