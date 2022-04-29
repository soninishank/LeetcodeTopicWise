package Coding.Matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/diagonal-traverse/
public class DiagonalTraverse {
    HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

    public int[] findDiagonalOrder(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (!hashMap.containsKey(i + j)) {
                    hashMap.put(i + j, new ArrayList<>());
                }
                hashMap.get(i + j).add(mat[i][j]);
            }
        }
        boolean flag = true;
        int[] result = new int[mat.length * mat[0].length];
        int index = 0;
        for (int key : hashMap.keySet()) {
            List<Integer> list = hashMap.get(key);
            if (flag) {
                for (int i = list.size() - 1; i >= 0; i--) {
                    result[index] = list.get(i);
                    index++;
                }
            } else {
                for (int num : list) {
                    result[index] = num;
                    index++;
                }
            }
            flag = !flag;
        }
        return result;
    }
}
