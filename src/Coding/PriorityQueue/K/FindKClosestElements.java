package Coding.PriorityQueue.K;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/find-k-closest-elements/
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.diff - o2.diff == 0) {
                return o2.value - o1.value; // if key is same compare based on value
            }
            return o2.diff - o1.diff; // compare based on diff
        });
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(new Pair(Math.abs(x - arr[i]), arr[i]));
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            list.add(priorityQueue.poll().value);
        }
        return list;
    }

    class Pair {
        int diff;
        int value;

        public Pair(int diff, int value) {
            this.diff = diff;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4, x = 3;
        List<Integer> closestElements = new FindKClosestElements().findClosestElements(arr, k, x);
        System.out.println(closestElements);
    }
}
