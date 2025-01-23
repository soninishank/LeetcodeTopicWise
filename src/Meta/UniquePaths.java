package Meta;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/discuss/interview-question/4935830/Meta-or-Onsite-or-Coding-rounds-Mostly-Reject/
public class UniquePaths {
    public static List<String> findAllPaths(int n) {
        List<String> paths = new ArrayList<>();
        findPaths(0, 0, n, "", paths);
        return paths;
    }

    private static void findPaths(int row, int col, int n, String currentPath, List<String> paths) {
        // Base case: if we reach the bottom-right corner, add the path to the list
        if (row == n - 1 && col == n - 1) {
            paths.add(currentPath);
            return;
        }
        // Move down
        if (row < n - 1) {
            findPaths(row + 1, col, n, currentPath + "D", paths);
        }

        // Move right
        if (col < n - 1) {
            findPaths(row, col + 1, n, currentPath + "R", paths);
        }
    }

    public static void main(String[] args) {
        int n = 3; // Size of the grid
        List<String> paths = findAllPaths(n);

        // Print all paths
        System.out.println("All unique paths in a " + n + "x" + n + " grid:");
        for (String path : paths) {
            System.out.println(path);
        }
    }
}
