package Meta;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Time complexity of O(n + m)
public class RemoveElementsFromArray {
    public List<String> removeElements(String[] inputArray, String[] removeArray) {
        // Convert the removeArray to a HashSet for quick lookups
        Set<String> removeSet = new HashSet<>();
        for (String element : removeArray) {
            removeSet.add(element);
        }
        // Prepare the result list
        List<String> result = new ArrayList<>();
        for (String element : inputArray) {
            // Only add elements not present in the removeSet
            if (!removeSet.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Example input
        String[] inputArray = {"d", "a", "b", "e", "e", "f", "a"};
        String[] removeArray = {"f", "a"};

        // Compute result
        List<String> result = new RemoveElementsFromArray().removeElements(inputArray, removeArray);

        // Print the result
        System.out.println(result); // Output: [d, b, e, e]
    }
}
