package Design;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/design-hit-counter/
// some request might be concurrent
// TODO - good question
//
public class HitCounter {
    Queue<Integer> queue;

    public HitCounter() {
        queue = new LinkedList<>();
    }

    // O(1)
    public void hit(int timestamp) {
        queue.add(timestamp);
    }

    // removing all the entries till N will take - O(N)
    public int getHits(int timestamp) {
        while (!queue.isEmpty() && timestamp - queue.peek() >= 300) {
            queue.poll();
        }
        return queue.size();
    }
}
