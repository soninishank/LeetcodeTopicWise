package Coding.HashMap;

import java.util.HashMap;
import java.util.Map;

// A Sparse Vector is a data structure used to efficiently represent vectors (or arrays) that have a significant number
// of zero elements. In contrast to a dense vector, where every element is stored, a sparse vector only stores non-zero
// elements along with their indices. This reduces memory usage and can speed up computations when dealing with large vectors.
// https://leetcode.com/problems/dot-product-of-two-sparse-vectors/
// 1570. Dot Product of Two Sparse Vectors
// https://leetcode.com/problems/dot-product-of-two-sparse-vectors/discuss/1823242/Clean-solutions-for-meta-interview-with-potential-follow-ups
public class SparseVector {

    private Map<Integer, Integer> hashmap;


    SparseVector(int[] nums) {
        hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                hashmap.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec2) {
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : this.hashmap.entrySet()) {
            int index = entry.getKey();
            int value = entry.getValue();
            if (vec2.hashmap.containsKey(index)) {
                result += value * vec2.hashmap.get(index);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 0, 0, 2, 3}, nums2 = {0, 3, 0, 4, 0};
        SparseVector v1 = new SparseVector(nums1);
        SparseVector v2 = new SparseVector(nums2);
        int ans = v1.dotProduct(v2);
    }
}
