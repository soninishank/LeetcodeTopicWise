package Coding.PriorityQueue;

import java.util.*;

public class TaskScheduler {

    Map<Character, Integer> hashMap = new HashMap<>();

    public int leastInterval(char[] tasks, int n) {
        for (char c : tasks) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        return taskScheduler(tasks, n);
    }

    public int taskScheduler(char[] tasks, int n) {
        PriorityQueue<Task> maxHeap = new PriorityQueue<>(((o1, o2) -> o2.freq - o1.freq));
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            maxHeap.add(new Task(entry.getKey(), entry.getValue(), -n - 1));
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < tasks.length) {
            List<Task> cooling = new ArrayList<>();
            while (!maxHeap.isEmpty()) {
                if (maxHeap.peek().lastUsed >= sb.length() - n) {
                    cooling.add(maxHeap.peek());
                    maxHeap.poll();
                } else
                    break;
            }
            if (!maxHeap.isEmpty()) {
                sb.append(maxHeap.peek().s);
                maxHeap.peek().freq--;
                maxHeap.peek().lastUsed = sb.length() - 1;
                if (maxHeap.peek().freq == 0)
                    maxHeap.poll();

                i++;
            } else {
                sb.append('#');
            }
            maxHeap.addAll(cooling);
        }
        return sb.length();
    }
}

class Task {

    char s;
    int freq;
    int lastUsed;

    Task(char s, int freq, int lastUsed) {
        this.s = s;
        this.freq = freq;
        this.lastUsed = lastUsed;
    }
}