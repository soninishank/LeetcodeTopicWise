package Coding.PriorityQueue;

import java.util.HashMap;
import java.util.PriorityQueue;

// sort by largest to smallest - descending order
public class ReorganizeString {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>((o1, o2) -> (hashMap.get(o2) - hashMap.get(o1)));
        priorityQueue.addAll(hashMap.keySet());
        while (priorityQueue.size() >= 2) {
            Character first = priorityQueue.poll();
            Character second = priorityQueue.poll();
            stringBuilder.append(first);
            stringBuilder.append(second);
            hashMap.put(first, hashMap.get(first) - 1);
            hashMap.put(second, hashMap.get(second) - 1);
            if (hashMap.get(first) > 0) {
                priorityQueue.add(first);
            }
            if (hashMap.get(second) > 0) {
                priorityQueue.add(second);
            }
        }
        while (!priorityQueue.isEmpty()) {
            Character poll = priorityQueue.poll();
            if (hashMap.get(poll) > 1) {
                return ""; // unable to form the string
            }
            stringBuilder.append(poll);
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        String s = "aab";
        String s1 = new ReorganizeString().reorganizeString(s);
        System.out.println(s1);
    }
}
