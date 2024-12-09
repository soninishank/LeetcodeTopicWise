import Coding.Tree.TreeNode;

import java.util.*;

public class Test {

    public int minStickers(String[] stickers, String target) {
        int[][] stickerCounts = new int[stickers.length][26];

        // Count the frequencies of letters in each sticker
        for (int i = 0; i < stickers.length; i++) {
            for (char c : stickers[i].toCharArray()) {
                stickerCounts[i][c - 'a']++;
            }
        }

        int result = helper(stickerCounts, target);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int helper(int[][] stickerCounts, String target) {
        // Base case: if target is empty, return 0 stickers needed
        if (target.isEmpty()) {
            return 0;
        }

        // Count frequencies of letters in the target
        int[] targetCounts = new int[26];
        for (char c : target.toCharArray()) {
            targetCounts[c - 'a']++;
        }

        int minStickers = Integer.MAX_VALUE;

        // Try using each sticker
        for (int[] sticker : stickerCounts) {
            // Optimization: Skip stickers that do not contain the first letter of the target
            if (sticker[target.charAt(0) - 'a'] == 0) {
                continue;
            }

            // Create a new target by reducing letters covered by this sticker
            StringBuilder newTarget = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (targetCounts[i] > 0) {
                    int remaining = targetCounts[i] - sticker[i];
                    while (remaining > 0) {
                        newTarget.append((char) (i + 'a'));
                        remaining--;
                    }
                }
            }
            System.out.println(newTarget.toString());
            // Recurse for the reduced target
            int stickersUsed = helper(stickerCounts, newTarget.toString());
            if (stickersUsed != Integer.MAX_VALUE) {
                minStickers = Math.min(minStickers, 1 + stickersUsed);
            }
        }
        return minStickers;
    }


    HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public int findDistance(TreeNode root, int p, int q) {
        if (root == null) {
            return 0;
        }
        traverseTree(root);
        return getDistance(p, q);
    }

    private void traverseTree(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            adjList.putIfAbsent(root.val, new ArrayList<>());
            adjList.putIfAbsent(root.left.val, new ArrayList<>());

            adjList.get(root.val).add(root.left.val);
            adjList.get(root.left.val).add(root.val);

            traverseTree(root.left);
        }
        if (root.right != null) {
            adjList.putIfAbsent(root.val, new ArrayList<>());
            adjList.putIfAbsent(root.right.val, new ArrayList<>());

            adjList.get(root.val).add(root.right.val);
            adjList.get(root.right.val).add(root.val);

            traverseTree(root.right);
        }
    }

    private int getDistance(int p, int q) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(p);

        Set<Integer> visited = new HashSet<>();
        visited.add(p);

        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                for (int neighbour : adjList.get(poll)) {
                    if (!visited.contains(neighbour)) {
                        visited.add(neighbour);
                        queue.add(neighbour);
                    }
                }
            }
            distance++;
        }
        return distance;
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hashmap = new HashMap<>();
        // Build hashmap
        for (String word : words) {
            hashmap.put(word, hashmap.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> hashmap.get(o1) - hashmap.get(o2));
        pq.addAll(hashmap.keySet());

        while (pq.size() > k) {
            pq.poll();
        }

        List<String> list = new ArrayList<>();
        while (pq.size() > 0) {
            list.add(pq.poll());
        }
        return list;
    }

    int globalCount = 0;

    public int averageOfSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        findAverage(root);
        return globalCount;
    }

    private Pair findAverage(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }
        Pair leftPair = findAverage(root.left);
        Pair rightPair = findAverage(root.right);

        int currentSum = root.val + leftPair.sum + rightPair.sum;
        int currentCount = 1 + leftPair.count + rightPair.count;

        int average = currentSum / currentCount;
        if (average == root.val) {
            globalCount++;
        }
        return new Pair(currentSum, currentCount);
    }

    class Pair {
        int sum;
        int count;

        public Pair(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }

    public boolean isValidPalindrome(String s, int k) {
        if (s.length() == 0) {
            return true;
        }
        return solvePalindrome(s, 0, s.length() - 1, k);
    }

    private boolean solvePalindrome(String str, int low, int high, int k) {
        if (k < 0) {
            return false;
        }
        if (low >= high) {
            return true;
        }
        if (str.charAt(low) == str.charAt(high)) {
            return solvePalindrome(str, low + 1, high - 1, k);
        } else {
            boolean a = solvePalindrome(str, low + 1, high, k - 1);
            boolean b = solvePalindrome(str, low, high - 1, k - 1);
            return a || b;
        }
    }


    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        if (nums.length == 0) {
            result.add(Arrays.asList(lower, upper));
            return result;
        }
        int i = 0;

        if (lower < nums[i]) {
            result.add(Arrays.asList(lower, nums[i] - 1));
        }
        while (i < nums.length-1) {
            int temp1 = nums[i];
            int temp2 = nums[i + 1];
            int diff = temp2 - temp1;
            if (diff > 1) {
                result.add(Arrays.asList(temp1 + 1, temp2 - 1));
            }
            i++;
        }

        if (nums[nums.length - 1] < upper) {
            result.add(Arrays.asList(nums[nums.length - 1] + 1, upper));
        }
        return result;
    }


    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(4);
//        treeNode.left = new TreeNode(8);
//        treeNode.right = new TreeNode(5);
//
//        treeNode.left.left = new TreeNode(0);
//        treeNode.left.right = new TreeNode(1);
//
//
//        treeNode.right.right = new TreeNode(6);
//
//        int i = new Test().averageOfSubtree(treeNode);
//        System.out.println(i);

        String s = "baaaabaa";
        int k = 3;
        boolean validPalindrome = new Test().isValidPalindrome(s, k);
        System.out.println(validPalindrome);

        int[] arr = {1, 3};
        int lower = 0, upper = 9;
        List<List<Integer>> missingRanges = new Test().findMissingRanges(arr, lower, upper);
        System.out.println(missingRanges);
    }
}