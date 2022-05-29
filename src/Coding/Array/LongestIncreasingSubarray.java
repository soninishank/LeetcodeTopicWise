package Coding.Array;

public class LongestIncreasingSubarray {
    private int printLongestIncSubArr(int[] arr, int n) {
        if (arr.length == 0) {
            return 0;
        }
        int maxLength = 1, currentLength = 1;
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                currentLength++;
            } else {
                currentLength = 1;
            }
            if (currentLength > maxLength) {
                maxLength = Math.max(maxLength, currentLength);
                index = i - maxLength;
            }
        }
        for (int i = index; i < index + maxLength; i++) {
            System.out.println(arr[i]);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 3, 5, 7, 8, 9, 1, 2};
        int i = new LongestIncreasingSubarray().printLongestIncSubArr(arr, arr.length);
        System.out.println(i);
    }
}
