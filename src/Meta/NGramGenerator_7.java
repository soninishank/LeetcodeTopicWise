package Meta;

import java.util.*;

// Implement a function that generates all k-skip-n-grams with the given sequence of tokens L,
// non-negative N and K. In other words, generate all subsequences of size N with up to K skips budget.
// https://leetcode.com/discuss/interview-question/2048705/meta-phone-screen-mle-remote
public class NGramGenerator_7 {

    public static Set<List<Character>> generateKSkipNGrams(List<Character> L, int N, int K) {
        Set<List<Character>> result = new HashSet<>();
        generateNGrams(L, N, K, 0, new ArrayList<>(), result);
        return result;
    }

    private static void generateNGrams(List<Character> L, int N, int K, int start, List<Character> current, Set<List<Character>> result) {
        // Base case: if the current n-gram size matches N, add to result
        if (current.size() == N) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Iterate through the list with skips
        for (int i = start; i < L.size(); i++) {
            current.add(L.get(i)); // Add the current element
            generateNGrams(L, N, K, i + 1, current, result); // Recurse for the next element
            current.remove(current.size() - 1); // Backtrack
        }

        // Allow skips if K > 0
        if (K > 0) {
            for (int i = start + 1; i < L.size(); i++) {
                current.add(L.get(i));
                generateNGrams(L, N, K - 1, i + 1, current, result); // Recurse with reduced skip budget
                current.remove(current.size() - 1); // Backtrack
            }
        }
    }

    public static void main(String[] args) {
        List<Character> L = Arrays.asList('a', 'b', 'c', 'd', 'e'); // Input sequence
        int N = 3; // Size of n-grams
        int K = 2; // Maximum skips allowed

        Set<List<Character>> result = generateKSkipNGrams(L, N, K);

        // Print the result
        for (List<Character> ngram : result) {
            System.out.println(ngram);
        }
    }
}

