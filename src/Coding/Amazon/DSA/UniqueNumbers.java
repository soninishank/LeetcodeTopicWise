package Coding.Amazon.DSA;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UniqueNumbers {
    /**
     * Extracts unique numbers from a list of strings and sorts them in ascending order.
     *
     * @param strings List of input strings containing random characters and numbers.
     * @return A sorted list of unique numbers.
     */
    public static List<Double> extractAndSortUniqueNumbers(List<String> strings) {
        // Use a Set to store unique numbers
        Set<Double> uniqueNumbers = new HashSet<>();

        // Traverse each string
        for (String str : strings) {
            int n = str.length();
            StringBuilder currentNumber = new StringBuilder();

            for (int i = 0; i < n; i++) {
                char c = str.charAt(i);

                // Check if the character is part of a number
                if (c == '-' || Character.isDigit(c) || c == '.') {
                    currentNumber.append(c);
                } else {
                    // If a non-numeric character is encountered, process the number
                    if (currentNumber.length() > 0) {
                        try {
                            uniqueNumbers.add(Double.parseDouble(currentNumber.toString()));
                        } catch (NumberFormatException e) {
                            // Ignore invalid numbers
                        }
                        currentNumber.setLength(0); // Reset the number builder
                    }
                }
            }

            // Process any remaining number at the end of the string
            if (currentNumber.length() > 0) {
                try {
                    uniqueNumbers.add(Double.parseDouble(currentNumber.toString()));
                } catch (NumberFormatException e) {
                    // Ignore invalid numbers
                }
            }
        }

        // Convert the Set to a List and sort it
        List<Double> sortedNumbers = new ArrayList<>(uniqueNumbers);
        Collections.sort(sortedNumbers);

        return sortedNumbers;
    }

     private static List<Double> extractAndSortUniqueNumbersTest(List<String> strings) {
        // Use a Set to store unique numbers
        Set<Double> uniqueNumbers = new HashSet<>();

        // Regular expression to match numbers (including negative and decimal)
        String regex = "-?\\d+(\\.\\d+)?";
        Pattern pattern = Pattern.compile(regex);

        // Iterate over each string in the input
        for (String str : strings) {
            Matcher matcher = pattern.matcher(str);

            // Find all matches in the string
            while (matcher.find()) {
                // Parse the matched substring as a double and add it to the Set
                uniqueNumbers.add(Double.parseDouble(matcher.group()));
            }
        }

        // Convert the Set to a List and sort it
        List<Double> sortedNumbers = new ArrayList<>(uniqueNumbers);
        Collections.sort(sortedNumbers);

        return sortedNumbers;
    }


    public static void main(String[] args) {
        // Example Input
        List<String> input = Arrays.asList(
                "aKJ^*&^-8-7asd^&*asd9.87ad1",
                "1asdlkjal(^(*6liUlkasgdkjO&*%^23ads2^3f87asd1.2.3.4"
        );

        // Extract and sort unique numbers
        List<Double> result = extractAndSortUniqueNumbers(input);

        // Print the output
        System.out.println(result); // Expected Output: [-87.0, 1.0, 6.0, 9.87, 23.0]


        List<Double> doubles = extractAndSortUniqueNumbersTest(input);
        System.out.println(doubles);

    }
}
