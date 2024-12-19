package Coding.Amazon.DSA;

import java.util.*;

public class LargestIslandWithCoordinates {

    public static int[] largestIslandCoordinates(int[][] grid) {
        int n = grid.length;

        // Step 1: Identify islands and assign unique IDs
        int[][] islandId = new int[n][n];
        Map<Integer, Integer> islandSizes = new HashMap<>();
        int currentIslandId = 2; // Start IDs from 2 (1 and 0 are already used in the grid)

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && islandId[i][j] == 0) {
                    int size = dfsMarkIsland(grid, islandId, i, j, currentIslandId);
                    islandSizes.put(currentIslandId, size);
                    currentIslandId++;
                }
            }
        }

        // Step 2: Try changing each 0 to 1 and calculate the resulting island size
        int maxIslandSize = 0;
        int[] bestCoordinates = null;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int newSize = calculateNewIslandSize(grid, islandId, islandSizes, i, j);
                    if (newSize > maxIslandSize) {
                        maxIslandSize = newSize;
                        bestCoordinates = new int[]{i, j};
                    }
                }
            }
        }

        // Step 3: If no 0 was found, return null (or [-1, -1])
        if (bestCoordinates == null) {
            return new int[]{-1, -1};
        }

        return bestCoordinates;
    }

    private static int dfsMarkIsland(int[][] grid, int[][] islandId, int i, int j, int currentIslandId) {
        int n = grid.length;

        // Base case: Out of bounds or already visited
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] == 0 || islandId[i][j] != 0) {
            return 0;
        }

        // Mark the cell with the current island ID
        islandId[i][j] = currentIslandId;
        int size = 1;

        // Explore all 4 directions
        size += dfsMarkIsland(grid, islandId, i + 1, j, currentIslandId);
        size += dfsMarkIsland(grid, islandId, i - 1, j, currentIslandId);
        size += dfsMarkIsland(grid, islandId, i, j + 1, currentIslandId);
        size += dfsMarkIsland(grid, islandId, i, j - 1, currentIslandId);

        return size;
    }

    private static int calculateNewIslandSize(int[][] grid, int[][] islandId, Map<Integer, Integer> islandSizes, int i, int j) {
        int n = grid.length;
        Set<Integer> visitedIslands = new HashSet<>();
        int newSize = 1; // Changing this 0 to 1 adds 1 to the island size

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];

            if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] == 1) {
                int id = islandId[ni][nj];
                if (!visitedIslands.contains(id)) {
                    visitedIslands.add(id);
                    newSize += islandSizes.get(id);
                }
            }
        }

        return newSize;
    }

    public static void main(String[] args) {
        int[][] grid1 = {{1, 0}, {0, 1}};

        int[][] grid2 = {{1, 1}, {1, 0}};

        int[][] grid3 = {{1, 1}, {1, 1}};

        int[][] grid4 = {{1, 0, 0, 1}, {1, 0, 0, 0}, {0, 1, 1, 1}, {0, 0, 1, 1}};
        System.out.println("Best coordinates for grid1: " + Arrays.toString(largestIslandCoordinates(grid1))); // [0, 1] or [1, 0]
        System.out.println("Best coordinates for grid2: " + Arrays.toString(largestIslandCoordinates(grid2))); // [1, 1]
        System.out.println("Best coordinates for grid3: " + Arrays.toString(largestIslandCoordinates(grid3))); // [-1, -1]

        System.out.println("Best coordinates for grid3: " + Arrays.toString(largestIslandCoordinates(grid4))); // [-1, -1]

    }
}
