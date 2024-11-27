package Coding.TwoPointers;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/dot-product-of-two-sparse-vectors/
// 1570. Dot Product of Two Sparse Vectors
public class SparseVectorOptimized {
    private List<int[]> list;

    SparseVectorOptimized(int[] nums) {
        list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // only non zero elements
            if (nums[i] != 0) {
                list.add(new int[]{i, nums[i]}); // index, original element
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVectorOptimized vec) {
        int result = 0;
        int p1 = 0, p2 = 0;
        while (p1 < this.list.size() && p2 < vec.list.size()) {
            int[] pair1 = this.list.get(p1);
            int[] pair2 = vec.list.get(p2);
            // index match
            if (pair1[0] == pair2[0]) {
                result += pair1[1] * pair2[1];
                p1++;
                p2++;
            } else if (pair1[0] < pair2[0]) {
                p1++;
            } else {
                p2++;
            }
        }
        return result;
    }
}