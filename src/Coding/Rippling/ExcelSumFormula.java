package Coding.Rippling;

import java.util.HashMap;
import java.util.Map;

public class ExcelSumFormula {
    final Cell[][] cells; // Matrix of cells

    public ExcelSumFormula(int height, char width) {
        // Initialize the matrix to store Cell objects
        cells = new Cell[height + 1][width - 'A' + 1];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j] = new Cell(0); // Initialize each cell with value 0
            }
        }
    }

    // Set a value for a specific cell
    public void set(int row, char col, int value) {
        cells[row][col - 'A'].set(value); // Update the cell's value
    }

    // Get the current value of a specific cell
    public int get(int row, char col) {
        return cells[row][col - 'A'].getValue();
    }

    // Define a formula (sum) for a specific cell and return its value
    public int sum(int row, char col, String[] references) {
        Cell targetCell = cells[row][col - 'A']; // Target cell to store the sum
        targetCell.set(0); // Reset the cell's value to 0

        for (String ref : references) {
            int colonIndex = ref.indexOf(':'); // Check if it's a range
            if (colonIndex > 0) {
                // It's a range like "A1:B3"
                int[] start = getPosition(ref.substring(0, colonIndex)); // Top-left of the range
                int[] end = getPosition(ref.substring(colonIndex + 1)); // Bottom-right of the range
                for (int i = start[0]; i <= end[0]; i++) {
                    for (int j = start[1]; j <= end[1]; j++) {
                        targetCell.addDependency(cells[i][j]);
                    }
                }
            } else {
                // It's a single cell like "A1"
                int[] pos = getPosition(ref);
                targetCell.addDependency(cells[pos[0]][pos[1]]);
            }
        }
        return targetCell.getValue(); // Return the computed sum
    }

    // Convert a string like "A1" or "B3" to a row-column position
    private int[] getPosition(String ref) {
        int row = Integer.parseInt(ref.substring(1)); // Extract the row index
        int col = ref.charAt(0) - 'A'; // Convert the column character to an index
        return new int[]{row, col};
    }

    // Inner class to represent a cell
    class Cell {
        int value; // The value of the cell
        final Map<Cell, Integer> dependencies = new HashMap<>(); // Dependencies for sum formulas

        // Constructor to initialize the cell with a value
        Cell(int value) {
            this.value = value;
        }

        // Add a dependency (another cell) to this cell
        void addDependency(Cell cell) {
            dependencies.put(cell, dependencies.getOrDefault(cell, 0) + 1);
        }

        // Get the current value of the cell
        int getValue() {
            if (dependencies.isEmpty()) {
                return value; // No dependencies, return the stored value
            } else {
                // Calculate the sum of all dependencies
                int sum = 0;
                for (Map.Entry<Cell, Integer> entry : dependencies.entrySet()) {
                    Cell dependentCell = entry.getKey();
                    int multiplier = entry.getValue();
                    sum += multiplier * dependentCell.getValue();
                }
                return sum;
            }
        }

        // Set a new value for the cell and clear dependencies
        void set(int value) {
            this.value = value;
            dependencies.clear(); // Clear dependencies because this cell now has a direct value
        }
    }
}
