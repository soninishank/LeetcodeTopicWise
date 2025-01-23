package Meta;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/dot-product-of-two-sparse-vectors/
public class DotProductOfSparseVectors {
    private List<int[]> list;

    DotProductOfSparseVectors(int[] nums) {
        list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // only non zero elements
            if (nums[i] != 0) {
                list.add(new int[]{i, nums[i]}); // index, original element
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(DotProductOfSparseVectors vec) {
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

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
