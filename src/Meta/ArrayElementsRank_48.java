package Meta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/rank-transform-of-an-array/
// Copy arr into A and sort it.
//Iterate sorted array A and record the rank for each element in hashmap rank.
//Iterate arr again, and assign rank[arr[i]] to A[i].
//return the final result A.
public class ArrayElementsRank_48 {

    // TC - O(NlogN)
    // SC - O(N)
    // It will handle duplicates also
    public int[] arrayRankTransform(int[] arr) {
        // Base condition
        if (arr.length == 0) return new int[0];

        // Step 1: Create a sorted copy of the array
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr); // sorting here

        // Step 2: Create a hashmap to store the rank of each element
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int num : sortedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank);
                rank++;
            }
        }

        // Step 3: Replace elements in the original array with their ranks
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = rankMap.get(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayElementsRank_48 ra = new ArrayElementsRank_48();
        System.out.println(Arrays.toString(ra.arrayRankTransform(new int[]{40, 10, 20, 30}))); // Output: [4, 1, 2, 3]
        System.out.println(Arrays.toString(ra.arrayRankTransform(new int[]{100, 100, 100}))); // Output: [1, 1, 1]
        System.out.println(Arrays.toString(ra.arrayRankTransform(new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12}))); // Output: [5, 3, 4, 2, 8, 6, 7, 1, 3]
    }
}
