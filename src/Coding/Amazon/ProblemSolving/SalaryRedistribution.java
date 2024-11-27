package Coding.Amazon.ProblemSolving;

import java.util.Arrays;

public class SalaryRedistribution {
    public static double findMinSalary(double[] salaries, double budget) {
        // Sort salaries in ascending order
        Arrays.sort(salaries);
        int n = salaries.length;

        // Iterate through the salaries
        for (int i = 0; i < n; i++) {
            // Calculate the remaining employees and the budget required to raise all
            // salaries at this level
            int remainingEmployees = n - i;
            double requiredBudget = remainingEmployees * (salaries[i] - (i == 0 ? 0 : salaries[i - 1]));

            if (budget < requiredBudget) {
                // If budget is insufficient, distribute it evenly among the remaining employees
                return salaries[i - 1] + (budget / remainingEmployees);
            }

            // Deduct the used budget
            budget -= requiredBudget;
        }

        // If there's leftover budget, distribute it evenly across all employees
        return salaries[n - 1] + (budget / n);
    }

    public static double[] adjustSalaries(double[] salaries, double budget) {
        // Find the minimum salary achievable with the given budget
        double minSalary = findMinSalary(salaries, budget);

        // Adjust salaries based on the minimum salary
        for (int i = 0; i < salaries.length; i++) {
            if (salaries[i] < minSalary) {
                budget -= (minSalary - salaries[i]);
                salaries[i] = minSalary;
            }
        }

        return salaries;
    }

    public static void main(String[] args) {
        double[] salaries1 = {40, 50, 10, 30, 60};
        double budget1 = 20;
        double[] salaries2 = {40, 50, 10, 30, 60};
        double budget2 = 24;

        double[] adjustedSalaries1 = adjustSalaries(salaries1, budget1);
        double[] adjustedSalaries2 = adjustSalaries(salaries2, budget2);

        System.out.println("Adjusted Salaries (Budget 20): " + Arrays.toString(adjustedSalaries1));
        System.out.println("Adjusted Salaries (Budget 24): " + Arrays.toString(adjustedSalaries2));
    }
}