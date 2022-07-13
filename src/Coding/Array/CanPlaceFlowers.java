package Coding.Array;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/can-place-flowers/
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                list.add(i);
            }
        }
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (flowerbed[i] == 0) {
                if (!list.contains(i - 1) && !list.contains(i + 1)) {
                    n--;
                    list.add(i);
                }
            }
        }
        return n == 0 ? true : false;
    }

    public boolean canPlaceFlowersOptimized(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (flowerbed[i] == 0) {
                int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
                int prev = (i == 0) ? 0 : flowerbed[i - 1];
                if (next == 0 && prev == 0) {
                    n--;
                    flowerbed[i] = 1;
                }
            }
        }
        return n == 0 ? true : false;
    }


    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 0, 1};
        int n = 2;
        boolean b = new CanPlaceFlowers().canPlaceFlowers(arr, n);
        System.out.println(b);
    }
}
