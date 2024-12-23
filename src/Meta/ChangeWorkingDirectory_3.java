package Meta;

import java.util.Stack;

// https://leetcode.com/discuss/interview-question/553454/facebook-phone-change-working-directory
public class ChangeWorkingDirectory_3 {

    public static String changeDirectory(String cwd, String changeDirectory) {
        // Initialize a stack to simulate the path
        Stack<String> stack = new Stack<>();
        // If the argument is an absolute path, start from root
        if (changeDirectory.startsWith("/")) {
            stack.clear();
        } else {
            // Add the current working directory to the stack
            String[] split = cwd.split("/");
            for (String dir : split) {
                if (!dir.isEmpty()) {
                    stack.push(dir);
                }
            }
        }

        // Split the argument path and process each component
        String[] splittedString = changeDirectory.split("/");
        for (String part : splittedString) {
            if (part.isEmpty() || part.equals(".")) {
                // Ignore empty or current directory indicators
                continue;
            } else if (part.equals("..")) {
                // Go up one directory, if possible
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Add the directory to the stack
                stack.push(part);
            }
        }

        // Reconstruct the path from the stack
        StringBuilder result = new StringBuilder("/");
        for (String dir : stack) {
            result.append(dir).append("/");
        }

        // Remove the trailing slash, if necessary
        if (result.length() > 1) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(changeDirectory("/", "foo")); // Expected: /foo
        System.out.println(changeDirectory("/baz", "/bar")); // Expected: /bar
        System.out.println(changeDirectory("/foo/bar", "../../../../..")); // Expected: /
        System.out.println(changeDirectory("/x/y", "../p/../q")); // Expected: /x/q
        System.out.println(changeDirectory("/x/y", "/p/./q")); // Expected: /p/q
        System.out.println(changeDirectory("/a", "b")); // Expected: /a/b

    }
}
