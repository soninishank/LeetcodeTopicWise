package Meta;

// Given a Sorted Array with Integer and two numbers A and B. Return how many elements are in that range (inclusive).
// See Counting Integers in a range.
public class FirstElementGreaterThanK_FollowUp {
    public int countElementsInRange(int[] array, int A, int B) {
        int left = findFirstGreaterOrEqual(array, A);
        int right = findLastLessOrEqual(array, B);

        if (left == -1 || right == -1 || left > right) {
            return 0; // No elements in the range
        }
        return right - left + 1;
    }

    private int findFirstGreaterOrEqual(int[] array, int A) {
        int left = 0, right = array.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= A) {
                result = mid; // Update the result
                right = mid - 1; // Move left to find smaller indices
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private int findLastLessOrEqual(int[] array, int B) {
        int left = 0, right = array.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] <= B) {
                result = mid; // Update the result
                left = mid + 1; // Move right to find larger indices
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4};
        FirstElementGreaterThanK_FollowUp test = new FirstElementGreaterThanK_FollowUp();
        System.out.println(test.countElementsInRange(array1, 0, 0)); // Output: 0
        System.out.println(test.countElementsInRange(array1, 1, 4)); // Output: 4
        System.out.println(test.countElementsInRange(array1, -5, 0)); // Output: 0

        int[] array2 = {1, 1, 2, 4};
        System.out.println(test.countElementsInRange(array2, 0, 1)); // Output: 3

        int[] array3 = {5, 6, 7, 8};
        System.out.println(test.countElementsInRange(array3, 7, 10)); // Output: 2
    }

}
