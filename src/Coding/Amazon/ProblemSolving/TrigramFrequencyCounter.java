package Coding.Amazon.ProblemSolving;

import java.util.*;

public class TrigramFrequencyCounter {

    public static void main(String[] args) {
        // Input text
        String inputText = "The brown dog jumps over the row."; // Example input

        // Process the text to extract valid trigrams
        Map<String, Integer> trigramFrequency = calculateTrigramFrequencies(inputText);

        // Sort and display the results in a simple way
        List<Map.Entry<String, Integer>> sortedTrigrams = new ArrayList<>(trigramFrequency.entrySet());
        sortedTrigrams.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        for (Map.Entry<String, Integer> entry : sortedTrigrams) {
            System.out.println("\"" + entry.getKey() + "\" " + entry.getValue());
        }
    }

    private static Map<String, Integer> calculateTrigramFrequencies(String text) {
        // Clean the input text: remove non-alphabetic characters and convert to lowercase
        text = text.replaceAll("[^a-zA-Z]", "").toLowerCase();

        System.out.println(text);
        Map<String, Integer> trigramFrequency = new HashMap<>();

        // Generate trigrams
        for (int i = 0; i < text.length() - 2; i++) {
            String trigram = text.substring(i, i + 3);
            trigramFrequency.put(trigram, trigramFrequency.getOrDefault(trigram, 0) + 1);
        }

        return trigramFrequency;
    }
}
