package Coding.PriorityQueue.K;// https://leetcode.com/problems/last-stone-weight/

import java.util.Collections;
import java.util.PriorityQueue;

class LastStoneWeight {
     public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i < stones.length; i++){
            pq.add(stones[i]);
        }
        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            if(first == second){
                continue;
            }else {
                int val = Math.abs(first) - Math.abs(second);
                pq.add(val);
            }
        }
        if(pq.size() == 0){
            return 0;
        }
        return pq.poll();
    }

    public static void main(String[] args){
        int[] arr = {2,7,4,1,8,1};
        int res = new LastStoneWeight().lastStoneWeight(arr);
        System.out.println(res);
    }
}