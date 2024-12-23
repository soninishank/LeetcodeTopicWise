package Meta;

import java.util.PriorityQueue;

// https://leetcode.com/problems/find-median-from-data-stream/
// https://leetcode.com/discuss/interview-question/432395/facebook-phone-screen-stream-median
public class MedianKeeper_50 {
    PriorityQueue<Integer> rightMinHeap;

    // extra element will always be in leftMaxHeap
    // leftMaxHeap will store only the smallest element
    PriorityQueue<Integer> leftMaxHeap;


    public MedianKeeper_50() {
        rightMinHeap = new PriorityQueue<>();
        leftMaxHeap = new PriorityQueue<>((o1, o2) -> (o2 - o1));
    }

    public void addNum(int num) {
        if (leftMaxHeap.isEmpty()) {
            leftMaxHeap.add(num);
        } else if (num < leftMaxHeap.peek()) {
            leftMaxHeap.add(num);
        } else {
            rightMinHeap.add(num); // big elements isme ayenge
        }

        // always maintain leftMaxHeap size one greater than rightMinHeap
        if (Math.abs(leftMaxHeap.size() - rightMinHeap.size()) > 1) {
            int val = leftMaxHeap.poll();
            rightMinHeap.add(val);
        } else if (leftMaxHeap.size() < rightMinHeap.size()) {
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }

    public double findMedian() {
        // even number of elements
        if (leftMaxHeap.size() == rightMinHeap.size()) {
            int val1 = leftMaxHeap.peek();
            int val2 = rightMinHeap.peek();
            return (double) (val1 + val2) / 2;
        } else {
            return leftMaxHeap.peek();
        }
    }
}
