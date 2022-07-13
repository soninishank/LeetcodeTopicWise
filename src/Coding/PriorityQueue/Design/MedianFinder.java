package Coding.PriorityQueue.Design;

import java.util.Collections;
import java.util.PriorityQueue;

// https://leetcode.com/problems/find-median-from-data-stream/
// Time complexity is O(NlogN)
// Space complexity - O(N)

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




//    There are so many ways around this problem, that frankly, it is scary. Here are a few more that I came across:
//
//        Buckets! If the numbers in the stream are statistically distributed, then it is easier to keep track of buckets where the median would land, than the entire array. Once you know the correct bucket, simply sort it find the median. If the bucket size is significantly smaller than the size of input processed, this results in huge time saving. @mitbbs8080 has an interesting implementation here.
//
//        Reservoir Sampling. Following along the lines of using buckets: if the stream is statistically distributed, you can rely on Reservoir Sampling. Basically, if you could maintain just one good bucket (or reservoir) which could hold a representative sample of the entire stream, you could estimate the median of the entire stream from just this one bucket. This means good time and memory performance. Reservoir Sampling lets you do just that. Determining a "good" size for your reservoir? Now, that's a whole other challenge. A good explanation for this can be found in this StackOverflow answer.
//
//        Segment Trees are a great data structure if you need to do a lot of insertions or a lot of read queries over a limited range of input values. They allow us to do all such operations fast and in roughly the same amount of time, always. The only problem is that they are far from trivial to implement. Take a look at my introductory article on Segment Trees if you are interested.
//
//        Order Statistic Trees are data structures which seem to be tailor-made for this problem. They have all the nice features of a BST, but also let you find the k^{th}k
//        th
//        order element stored in the tree. They are a pain to implement and no standard interview would require you to code these up. But they are fun to use if they are already implemented in the language of your choice.