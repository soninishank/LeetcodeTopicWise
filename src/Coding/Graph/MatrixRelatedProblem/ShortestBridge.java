//package Coding.Graph.MatrixRelatedProblem;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class ShortestBridge {
//    public int shortestBridge(int[][] grid) {
//        Queue<int[]> queue = new LinkedList<>();
//        boolean flag = false;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                if (flag == true) {
//                    break;
//                } else if (grid[i][j] == 1) {
//                    flag = true;
//                    applyDFS(grid, i, j, queue);
//                }
//            }
//        }
//        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//        int count = 0;
//        while (!queue.isEmpty()) {
//            for (int i = 0; i < queue.size(); i++)
//            {
//                int[] poll = queue.poll();
//                for (int[] dir : dirs) {
//                    int x = dir[0] + poll[0];
//                    int y = dir[1] + poll[1];
//                }
//            }
//        }
//    }
//
//    private void applyDFS(int[][] grid, int i, int j, Queue<int[]> queue) {
//        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] != 1) {
//            return;
//        }
//        queue.add(new int[]{i, j});
//        grid[i][j] = -1;// change the color
//        applyDFS(grid, i + 1, j, queue);
//        applyDFS(grid, i - 1, j, queue);
//        applyDFS(grid, i, j + 1, queue);
//        applyDFS(grid, i, j - 1, queue);
//    }
//
//    public static void main(String[] args) {
//        int[][] arr = {{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}};
//        int i = new ShortestBridge().shortestBridge(arr);
//        System.out.println(i);
//    }
//}
