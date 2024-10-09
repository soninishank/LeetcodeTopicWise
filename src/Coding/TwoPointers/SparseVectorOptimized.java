package Coding.TwoPointers;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/dot-product-of-two-sparse-vectors/
// 1570. Dot Product of Two Sparse Vectors
public class SparseVectorOptimized {

    private List<int[]> pairs; // <index, value>

    SparseVectorOptimized(int[] nums) {
        pairs = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != 0) {
                int value = nums[index];
                pairs.add(new int[]{index, value});
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVectorOptimized vec) {
        int result = 0, currentElement = 0, otherElement = 0;
        while (currentElement < pairs.size() && otherElement < vec.pairs.size()) {
            if (pairs.get(currentElement)[0] == vec.pairs.get(otherElement)[0]) {
                result += pairs.get(currentElement)[1] * vec.pairs.get(otherElement)[1];
                currentElement++;
                otherElement++;
            } else if (pairs.get(currentElement)[0] > vec.pairs.get(otherElement)[0]) {
                otherElement++;
            } else {
                currentElement++;
            }
        }
        return result;
    }
}
