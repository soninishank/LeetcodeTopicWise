package Coding.Intervals;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

// https://leetcode.com/discuss/interview-question/2016783/Shopee-interview-question
public class MostOverlappingIntervals {

    private void getMostOccurringEvent(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        System.out.println(Arrays.deepToString(arr));
    }

    public static void main(String[] args) {
        int arr[][] = {{5, 8}, {1, 5}, {4, 5}, {2, 6}}; // {4,5}
        new MostOverlappingIntervals().getMostOccurringEvent(arr);
    }
}
