package Coding.PriorityQueue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count frequency of each task
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Step 2: Find the frequency of the most common task
        int f_max = 0;
        for (int f : freq) {
            f_max = Math.max(f_max, f);
        }

        // Step 3: Count how many tasks have the max frequency
        int m_max = 0;
        for (int f : freq) {
            if (f == f_max) {
                m_max++;
            }
        }

        // Step 4: Calculate the minimum intervals required
        // This is the number of "full" cycles you need to complete the most frequent tasks, excluding the last occurrence
        // of the task. For example, if f_max = 3, you need 2 cycles to place the first two occurrences of the task, because
        // the last occurrence does not require a cycle after it.
        int maxFreq = f_max - 1;
        int total = maxFreq * (n + 1);
        return Math.max(tasks.length, total + m_max);
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        System.out.println(scheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));  // Output: 8
        System.out.println(scheduler.leastInterval(new char[]{'A', 'C', 'A', 'B', 'D', 'B'}, 1));  // Output: 6
        System.out.println(scheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 3));  // Output: 10
    }
}
