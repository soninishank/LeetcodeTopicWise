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
        PriorityQueue<MetaData> priorityQueue = new PriorityQueue<>((o1, o2) -> (o2.frequency - o1.frequency));
        for (Character character : hashMap.keySet()) {
            priorityQueue.add(new MetaData(character, false, hashMap.get(character)));
        }
        StringBuilder stringBuilder = new StringBuilder();
        char prevChar = '\0';
        while (!priorityQueue.isEmpty()) {
            MetaData poll = priorityQueue.poll();
            if (poll.frequency > (s.length() + 1) / 2) {
                return "";
            }
            if (poll.currentVal == prevChar && priorityQueue.size() > 0) {
                MetaData secondPoll = priorityQueue.poll();
                stringBuilder.append(secondPoll.currentVal);
                secondPoll.frequency--;
                if (secondPoll.frequency > 0) {
                    prevChar = poll.currentVal;
                    priorityQueue.add(secondPoll);
                }
                priorityQueue.add(poll);
            } else {
                stringBuilder.append(poll.currentVal);
                poll.frequency--;
                if (poll.frequency > 0) {
                    prevChar = poll.currentVal;
                    priorityQueue.add(poll);
                }
            }
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        String s = "vvvlo";
        String s1 = new ReorganizeString().reorganizeString(s);
        System.out.println(s1);
    }

    class MetaData {
        char currentVal;
        int frequency;

        public MetaData(char currentVal, boolean lastUsed, int frequency) {
            this.currentVal = currentVal;
            this.frequency = frequency;
        }
    }
}
