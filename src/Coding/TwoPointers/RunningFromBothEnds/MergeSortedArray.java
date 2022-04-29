package Coding.TwoPointers.RunningFromBothEnds;

/**
 * @author Nishank Soni
 * @project Leet Code Topic Wise on 4/1/22
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - 1;
        int j = nums2.length - 1;
        int c = m - 1;
        int d = n - 1;
        while (c >= 0 && d >= 0) {
            if (nums1[c] > nums2[d]) {
                nums1[i] = nums1[c];
                i--;
                c--;
            } else {
                nums1[i] = nums2[d];
                i--;
                d--;
            }
        }
        while (c >= 0) {
            nums1[i] = nums1[c];
            i--;
            c--;
        }
        while (d >= 0) {
            nums1[i] = nums2[d];
            i--;
            d--;
        }
    }
}
