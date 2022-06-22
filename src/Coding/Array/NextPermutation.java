package Coding.Array;

import java.util.Arrays;

// https://leetcode.com/problems/next-permutation/
// https://leetcode.com/problems/next-greater-element-iii/
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // Finding the first decreasing element
        int i = 0;
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        // Finding the just larger number than the above element
        if (i >= 0) {
            int j = 0;
            for (j = nums.length - 1; j >= 0; j--) {
                if (nums[j] > nums[i]) {
                    break;
                }
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int low, int high) {
        while (low <= high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }

    public int nextGreaterElement(int n) {
        int[] arr = covertIntToArray(n);
        nextPermutation(arr);
        int val = convertArrayToInt(arr);
        return val;
    }

    private int convertArrayToInt(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result * 10 + arr[i];
        }
        return result;
    }

    private int[] covertIntToArray(int key) {
        String temp = Integer.toString(key);
        int[] arr = new int[temp.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp.charAt(i) - '0';
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {2,1};
        new NextPermutation().nextPermutation(arr);
        System.out.println("The next permutations " + Arrays.toString(arr));

        int val = 12;
        int i = new NextPermutation().nextGreaterElement(val);
        System.out.println("The greater element  " + i);
    }
}
