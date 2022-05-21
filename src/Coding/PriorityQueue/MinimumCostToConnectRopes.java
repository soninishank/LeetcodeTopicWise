package Coding.PriorityQueue;

import java.util.PriorityQueue;

// https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
public class MinimumCostToConnectRopes {

    //Function to return the minimum cost of connecting the ropes.
    long minCost(int arr[], int n) {
        // your code here
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
        }
        int sum = 0;
        while (priorityQueue.size() > 2) {
            int a = priorityQueue.poll();
            int b = priorityQueue.poll();
            sum += a + b;
            priorityQueue.add(a + b);
        }
        sum += priorityQueue.poll() + priorityQueue.poll();
        return sum;
    }

    public static void main(String[] args) {
        int n = 4;
        int arr[] = {4, 3, 2, 6};
        long l = new MinimumCostToConnectRopes().minCost(arr, n);
        System.out.println(l);
    }
}
