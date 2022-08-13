import Coding.Tree.TreeNode;

import java.util.*;

public class Test1 {
    int count = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getCount(root);
        return count;
    }

    int getCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        count = Math.max(count, left + right);
        return 1 + Math.max(left, right);
    }

    static boolean isToeplitz(int[][] arr) {
        // your code goes here
        HashMap<Integer, List<Integer>> hashmap = new HashMap<>();
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if (arr[i - 1][j - 1] != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Integer>> list = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] arr : times) {
            list.get(arr[0]).add(arr[1]);
        }
        Set<Integer> set = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int totalCost = Integer.MIN_VALUE;
        pq.add(new int[]{k, 0});
        set.add(k);
        while (!pq.isEmpty()) {
            int[] ratio = pq.poll();
            totalCost = Math.max(totalCost, totalCost + ratio[1]);
            for (int neighbour : list.get(ratio[0])) {
                if (!set.contains(neighbour)) {
                    pq.add(new int[]{neighbour, ratio[1] + 1});
                    set.add(neighbour);
                }
            }
        }
        return totalCost;
    }

    static void m1() {
        String s3 = null;
        if (s3 == (null)) {
            System.out.println("true");
        }
        String s5 = "nishank";
        s5.intern();
        if (s5 == "nishank") {
            System.out.println("nishank");
        }
        String s4 = "null";
        if (s4 == null) {
            System.out.println("check now");
        }
        String s2="Java";
        s3 = "Java";
        System.out.println("s2==s3"+s2==s3);

    }


    static void listCheck() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer val = iterator.next();
            if (val.equals(2)) {
                list.remove(val);
                list.remove(2);
            }
        }
    }

    static void check() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer val = iterator.next();
            if (val.equals(2)) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
//        int[][] arr = {{3, 1, 7}, {4, 1, 1}, {2, 4, 3}};
//        boolean toeplitz = isToeplitz(arr);
//        System.out.println(toeplitz);

        m1();
        //listCheck();
        //check();
    }
}
