package Meta;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/discuss/interview-question/633689/facebook-phonevideo-find-cheese
public class FindCheese_6 {

    // Directions for moving the mouse
    enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    // Visited positions
    private Set<String> visited = new HashSet<>();

    // Recursive function to find cheese
    public boolean findCheese(int x, int y) {
        // If the cheese is at the current position
        if (hasCheese()) {
            return true;
        }
        // Mark current position as visited
        visited.add(x + "," + y);

        // Explore all possible directions
        for (Direction dir : Direction.values()) {
            int newX = x;
            int newY = y;

            // Update coordinates based on a direction
            switch (dir) {
                case UP:
                    newY -= 1;
                    break;
                case DOWN:
                    newY += 1;
                    break;
                case LEFT:
                    newX -= 1;
                    break;
                case RIGHT:
                    newX += 1;
                    break;
            }

            // Check if the new position is visited
            if (!visited.contains(newX + "," + newY)) {
                // Try moving in the direction
                if (move(dir)) {
                    // Recurse to search from the new position
                    if (findCheese(newX, newY)) {
                        return true;
                    }
                    // Backtrack if the path does not lead to cheese
                    move(oppositeDirection(dir));
                }
            }
        }

        // Cheese isn't found in any direction
        return false;
    }

    // Returns the opposite direction
    private Direction oppositeDirection(Direction dir) {
        switch (dir) {
            case UP:
                return Direction.DOWN;
            case DOWN:
                return Direction.UP;
            case LEFT:
                return Direction.RIGHT;
            case RIGHT:
                return Direction.LEFT;
            default:
                throw new IllegalArgumentException("Invalid direction");
        }
    }

    // API function stubs
    private boolean hasCheese() {
        // Implementation provided by the API
        return false;
    }

    private boolean move(Direction direction) {
        // Implementation provided by the API
        return false;
    }

    // Main function to execute the solver
    public static void main(String[] args) {
        FindCheese_6 solver = new FindCheese_6();
        boolean result = solver.findCheese(0, 0);
        System.out.println("Cheese found: " + result);
    }
}