package Meta;

// https://leetcode.com/discuss/interview-experience/1833775/meta-london-9th-march
// https://leetcode.com/discuss/interview-question/4525578/Meta-Phone-Screen/
public class CountMonotonicSequences {
    public int countMonotonicSequences(int[] arr) {
        if (arr.length <= 1) {
            return arr.length; // A single element or empty array is one sequence
        }

        int count = 1; // At least one monotonic sequence
        int direction = 0; // 0 for unknown, 1 for increasing, -1 for decreasing

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                // Transition to increasing
                if (direction == -1) {
                    count++;
                }
                direction = 1;
            } else if (arr[i] < arr[i - 1]) {
                // Transition to decreasing
                if (direction == 1) {
                    count++;
                }
                direction = -1;
            }
            // If arr[i] == arr[i - 1], continue without changing direction
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 10}; // One monotonic sequence
        int[] arr2 = {7, 4, 2, 2, 2, 1}; // One monotonic sequence
        int[] arr3 = {5, 3, 1, 5, 6, 7}; // Two monotonic sequences
        int[] arr4 = {5, 5, 5, 8, 19, 14, 4, 1}; // Two monotonic sequences

        CountMonotonicSequences sequences = new CountMonotonicSequences();
        System.out.println("Monotonic sequences in arr1: " + sequences.countMonotonicSequences(arr1)); // Output: 1
        System.out.println("Monotonic sequences in arr2: " + sequences.countMonotonicSequences(arr2)); // Output: 1
        System.out.println("Monotonic sequences in arr3: " + sequences.countMonotonicSequences(arr3)); // Output: 2
        System.out.println("Monotonic sequences in arr4: " + sequences.countMonotonicSequences(arr4)); // Output: 2
    }
}
