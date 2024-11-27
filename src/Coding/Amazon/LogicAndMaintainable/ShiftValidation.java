package Coding.Amazon.LogicAndMaintainable;

import java.util.*;

public class ShiftValidation {

    // Mock API calls for validation
    public static boolean isUserTrained(String employeeId, String process) {
        // Mock API call to check if the user is trained
        // Replace with real implementation
        return !employeeId.equals("E003") || process.equals("Pick");
    }

    public static boolean isProcessValid(String buildingId, String process) {
        // Mock API call to check if the process is valid for the building
        // Replace with real implementation
        return !process.equals("InvalidProcess");
    }

    public static List<String> validateShiftPlan(
            List<Employee> employees,
            List<String> processes,
            String buildingId
    ) {
        List<String> violations = new ArrayList<>();

        // Rule 1: Validate assigned processes
        for (Employee emp : employees) {
            if (!processes.contains(emp.getAssignedProcess())) {
                violations.add("Employee " + emp.getEmployeeId() + " has an invalid process: " + emp.getAssignedProcess());
            }
        }

        // Rule 2: Check process coverage
        Map<String, Integer> processCount = new HashMap<>();
        for (String process : processes) {
            processCount.put(process, 0);
        }
        for (Employee emp : employees) {
            String process = emp.getAssignedProcess();
            if (processes.contains(process)) {
                processCount.put(process, processCount.get(process) + 1);
            }
        }
        for (String process : processes) {
            if (processCount.get(process) == 0) {
                violations.add("Process " + process + " has no employees assigned.");
            }
        }

        // Rule 3: Check assignment balance
        int totalAssignments = processCount.values().stream().mapToInt(Integer::intValue).sum();
        double averageAssignments = (double) totalAssignments / processes.size();
        for (Map.Entry<String, Integer> entry : processCount.entrySet()) {
            double count = entry.getValue();
            if (count < averageAssignments * 0.8 || count > averageAssignments * 1.2) {
                violations.add("Process " + entry.getKey() + " is unbalanced with " + count + " assignments.");
            }
        }

        // Extension Rule 1: Employee training
        for (Employee emp : employees) {
            if (!isUserTrained(emp.getEmployeeId(), emp.getAssignedProcess())) {
                violations.add("Employee " + emp.getEmployeeId() + " is not trained for process: " + emp.getAssignedProcess());
            }
        }

        // Extension Rule 2: Building-specific process validation
        for (String process : processes) {
            if (!isProcessValid(buildingId, process)) {
                violations.add("Process " + process + " is not valid for building " + buildingId + ".");
            }
        }

        return violations;
    }

    public static void main(String[] args) {
        // Sample Input
        List<Employee> employees = Arrays.asList(
                new Employee("E001", "Pick"),
                new Employee("E002", "InvalidProcess"),
                new Employee("E003", "Pack")
        );

        List<String> processes = Arrays.asList("Receive", "Stow", "Pick", "Pack");
        String buildingId = "B001";

        // Run validation
        List<String> violations = validateShiftPlan(employees, processes, buildingId);

        // Output violations
        if (violations.isEmpty()) {
            System.out.println("Shift plan is valid.");
        } else {
            System.out.println("Shift plan has the following violations:");
            for (String violation : violations) {
                System.out.println("- " + violation);
            }
        }
    }
}

// Employee class to hold employee data
class Employee {
    private String employeeId;
    private String assignedProcess;

    public Employee(String employeeId, String assignedProcess) {
        this.employeeId = employeeId;
        this.assignedProcess = assignedProcess;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getAssignedProcess() {
        return assignedProcess;
    }
}
