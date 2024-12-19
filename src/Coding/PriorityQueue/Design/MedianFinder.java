package Coding.PriorityQueue.Design;

import java.util.PriorityQueue;

// https://leetcode.com/problems/find-median-from-data-stream/
// Time complexity is O(NlogN)
// Space complexity - O(N)
// 295. Find Median from Data Stream

public class MedianFinder {
    // store only largest elements
    PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();

    // extra element will always be in leftMaxHeap
    // leftMaxHeap will store only the smallest element
    PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>((o1, o2) -> (o2 - o1));

    public MedianFinder() {
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


//    There are so many ways around this problem, that frankly, it is scary. Here are a few more that I came across:
//
// Buckets! If the numbers in the stream are statistically distributed, 
// then it is easier to keep track of buckets where the median would land,
// than the entire array. Once you know the correct bucket, 
// simply sort it find the median. If the bucket size is significantly smaller than the size of input processed,
//  this results in huge time saving. @mitbbs8080 has an interesting implementation here.
//
// Reservoir Sampling. Following along the lines of using buckets: if the stream is statistically distributed,
// you can rely on Reservoir Sampling. Basically, if you could maintain just one good bucket (or reservoir) which could hold a representative sample
// of the entire stream, you could estimate the median of the entire stream from just this one bucket. This means good time and memory performance.
// Reservoir Sampling lets you do just that. Determining a "good" size for your reservoir? Now, that's a whole other challenge.
// A good explanation for this can be found in this StackOverflow answer.
//  Segment Trees are a great data structure if you need to do a lot of insertions or a lot of read queries over a limited range of input values. They allow us to do all such operations fast and in roughly the same amount of time, always. The only problem is that they are far from trivial to implement. Take a look at my introductory article on Segment Trees if you are interested.
//  Order Statistic Trees are data structures which seem to be tailor-made for this problem. They have all the nice features of a BST, 
// but also let you find the k^{th}kth
// order element stored in the tree. They are a pain to implement and no standard interview would require you to code these up. 
//But they are fun to use if they are already implemented in the language of your choice.