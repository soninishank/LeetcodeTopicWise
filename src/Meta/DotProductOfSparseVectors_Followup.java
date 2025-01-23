package Meta;

import java.util.ArrayList;
import java.util.List;

public class DotProductOfSparseVectors_Followup {
    private List<int[]> list;

    DotProductOfSparseVectors_Followup(int[] nums) {
        list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // only non zero elements
            if (nums[i] != 0) {
                list.add(new int[]{i, nums[i]}); // index, original element
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(DotProductOfSparseVectors_Followup vec) {
        int result = 0;
        int p1 = 0, p2 = 0;
        while (true) {
            if (p1 == this.list.size() || p2 == vec.list.size()) {
                break;
            }
            int[] pair1 = this.list.get(p1);
            int[] pair2 = vec.list.get(p2);
            if (pair1[0] == pair2[0]) { // Index match
                result += pair1[1] * pair2[1];
                p1++;
                p2++;
                // we reached at the end so we cant do any computation
                if (p1 == this.list.size() || p2 == vec.list.size()) {
                    break;
                }
            } else if (pair1[0] < pair2[0]) {
                p1++;
                // we reached at the end so we cant find any matching elements now
                if (p1 == this.list.size()) {
                    break;
                }
            } else {
                p2++;
                if (p2 == vec.list.size()) {
                    break;
                }
            }
        }
        return result;
    }
}
