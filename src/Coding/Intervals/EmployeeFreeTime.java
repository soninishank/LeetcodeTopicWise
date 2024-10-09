package Coding.Intervals;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        // Priority Queue to merge all intervals by their start time
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);

        // Add all employee intervals to the priority queue
        for (List<Interval> employee : schedule) {
            for (Interval interval : employee) {
                pq.offer(interval);
            }
        }

        List<Interval> result = new ArrayList<>();

        // Take the first interval as the starting point for comparison
        Interval prev = pq.poll();

        while (!pq.isEmpty()) {
            Interval curr = pq.poll();

            // If there's a gap between the previous interval's end and the current interval's start,
            // that represents free time
            if (prev.end < curr.start) {
                result.add(new Interval(prev.end, curr.start));
                prev = curr;  // move to the next interval
            } else {
                // Otherwise, merge the intervals if they overlap
                prev.end = Math.max(prev.end, curr.end);
            }
        }
        return result;
    }

    class Interval {
        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }
}

