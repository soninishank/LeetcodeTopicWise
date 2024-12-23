package Meta;

import java.util.ArrayList;
import java.util.List;

public class GridPaths {
    // Recursive helper function
    private static void findPaths(int x, int y, int n, StringBuilder currentPath, List<String> result) {
        // Base Case: If we reach the bottom-right corner
        if (x == n - 1 && y == n - 1) {
            result.add(currentPath.toString());
            return;
        }

        // Move Down (D) if within bounds
        if (x < n - 1) {
            currentPath.append("D");
            findPaths(x + 1, y, n, currentPath, result);
            currentPath.deleteCharAt(currentPath.length() - 1); // Backtrack
        }

        // Move Right (R) if within bounds
        if (y < n - 1) {
            currentPath.append("R");
            findPaths(x, y + 1, n, currentPath, result);
            currentPath.deleteCharAt(currentPath.length() - 1); // Backtrack
        }
    }

    // Main function to get all paths
    public static List<String> getPaths(int n) {
        List<String> result = new ArrayList<>();
        findPaths(0, 0, n, new StringBuilder(), result);
        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        int n = 3; // Size of the grid
        List<String> paths = getPaths(n);
        System.out.println("Paths: " + paths); // Output: [DDRR, DRDR, DRRD, RDDR, RDRD, RRDD]
    }
}
