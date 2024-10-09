import java.util.*;

public class NextGreaterElementCircular {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count frequencies of each task
        Map<Character, Integer> taskFrequency = new HashMap<>();
        for (char task : tasks) {
            taskFrequency.put(task, taskFrequency.getOrDefault(task, 0) + 1);
        }

        // Step 2: Add frequencies to a max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int freq : taskFrequency.values()) {
            maxHeap.offer(freq);
        }

        // Step 3: Use a queue to manage cooldown
        Queue<int[]> cooldownQueue = new LinkedList<>();
        int time = 0;

        // Step 4: Process tasks until no more tasks or cooldowns are left
        while (!maxHeap.isEmpty() || !cooldownQueue.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                // Take the task with the highest frequency
                int currentTaskFreq = maxHeap.poll() - 1;
                if (currentTaskFreq > 0) {
                    // Add to cooldown if it still has frequency left
                    cooldownQueue.offer(new int[]{currentTaskFreq, time + n});
                }
            }

            // Move tasks from cooldown back to the heap if their cooldown is complete
            if (!cooldownQueue.isEmpty() && cooldownQueue.peek()[1] == time) {
                maxHeap.offer(cooldownQueue.poll()[0]);
            }
        }
        return time;
    }

    public static void main(String[] args) {
        NextGreaterElementCircular solution = new NextGreaterElementCircular();
        char[] tasks1 = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n1 = 2;
        System.out.println(solution.leastInterval(tasks1, n1)); // Output: 8

        char[] tasks2 = {'A', 'C', 'A', 'B', 'D', 'B'};
        int n2 = 1;
        System.out.println(solution.leastInterval(tasks2, n2)); // Output: 6

        char[] tasks3 = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n3 = 3;
        System.out.println(solution.leastInterval(tasks3, n3)); // Out
    }
}
