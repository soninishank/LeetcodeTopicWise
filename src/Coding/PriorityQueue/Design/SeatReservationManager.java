package Coding.PriorityQueue.Design;

import java.util.PriorityQueue;

// https://leetcode.com/problems/seat-reservation-manager/
public class SeatReservationManager {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public SeatReservationManager(int n) {
    }

    int count = 1;

    public int reserve() {
        if (pq.size() == 0) {
            return count++;
        }
        return pq.poll();
    }

    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}
