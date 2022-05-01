package Coding.PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

// https://leetcode.com/problems/find-median-from-data-stream/
public class MedianFinder {
    PriorityQueue<Integer> minPQ = new PriorityQueue<>();
    PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {
    }

    public void addNum(int num) {
        // add elements when maxPQ is empty
        if (maxPQ.isEmpty()) {
            maxPQ.add(num);
        }
        // add all smaller numbers which are less than maxPQ
        else if (maxPQ.peek() > num) {
            maxPQ.add(num);
        } else {
            minPQ.add(num);
        }
        // Balancing step
        if (maxPQ.size() > 1 + minPQ.size()) {
            Integer poll = maxPQ.poll();
            minPQ.add(poll);
        } else if (minPQ.size() > 1 + maxPQ.size()) {
            Integer poll = minPQ.poll();
            maxPQ.add(poll);
        }
    }

    public double findMedian() {
        // For even
        if (minPQ.size() == maxPQ.size()) {
            return (minPQ.peek() + maxPQ.peek()) / 2.0;
        }
        // For odd
        else if (maxPQ.size() > minPQ.size()) {
            return maxPQ.peek();
        } else {
            return minPQ.peek();
        }
    }
}
