package LLD.Multithreading.PureStorage;

import java.util.HashMap;
import java.util.Map;

public class TaskManagerWithCallbacks {
    private Map<String, Runnable> callbacks;

    public TaskManagerWithCallbacks() {
        callbacks = new HashMap<>();
    }

    // Method to register a callback for a specific task
    public void registerCallback(String taskName, Runnable callback) {
        callbacks.put(taskName, callback);
    }

    // Method to execute the callback for a specific task
    public void executeCallback(String taskName) {
        Runnable callback = callbacks.get(taskName);
        if (callback != null) {
            callback.run();
        } else {
            System.out.println("No callback registered for " + taskName);
        }
    }

    // Method to clear all callbacks
    public void clearCallbacks() {
        callbacks.clear();
    }

    public static void main(String[] args) {
        TaskManagerWithCallbacks manager = new TaskManagerWithCallbacks();

        // Register a callback
        manager.registerCallback("Task1", () -> System.out.println("Task1 completed!"));

        // Execute the callback
        manager.executeCallback("Task1"); // Output: "Task1 completed!"

        // Clear all callbacks
        manager.clearCallbacks();

        // Try executing after clearing
        manager.executeCallback("Task1"); // No output, as the callback is cleared.
    }
}
