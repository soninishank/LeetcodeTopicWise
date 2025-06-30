package Coding.Array;

public class MergeTwoSortedArraysWithoutExtraSpace {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - 1;
        int j = nums2.length - 1;
        m = m - 1;
        n = n - 1;

        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[i] = nums1[m];
                i--;
                m--;
            } else {
                nums1[i] = nums2[n];
                i--;
                n--;
            }
        }
        while (m >= 0) {
            nums1[i] = nums1[m];
            i--;
            m--;
        }
        while (n >= 0) {
            nums1[i] = nums2[n];
            i--;
            n--;
        }
    }

    public static void main(String[] args) {
        int[] X = {1,2,3,0,0,0};
        int[] Y = {2, 3, 9};
        new MergeTwoSortedArraysWithoutExtraSpace().merge(X, 3, Y, 3);
    }
}
