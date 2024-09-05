package Coding.WordSeries;

import java.util.*;

// https://leetcode.com/problems/word-ladder/
// You need three data structures
// 1.Queue -> for running the Coding.BFS
// 2.visited -> to not go in the loop
// 3.set -> to have a list of all words
// Just change the characters from a to z

// Generating transformations =  O(26 * M) = O(M)
// BFS Traversal = O(N)
// Total TC = O (M * N)
// Space Complexity = O(N)
public class WordLadderI {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;  // If the endWord is not in wordList, there's no valid sequence.
        }
        // Initialize the queue for BFS
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        // Initialize visited set to keep track of visited words
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        // To keep track of the levels in BFS
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                // Try to transform the current word by changing each character
                for (int j = 0; j < currentWord.length(); j++) {
                    char[] wordChars = currentWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordChars[j] = c;
                        String newWord = new String(wordChars);
                        // If we find the endWord, return the level + 1
                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }
                        // If the newWord is in the wordSet and not visited, add it to the queue
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            queue.add(newWord);
                            visited.add(newWord);  // Mark this word as visited
                        }
                    }
                }
            }
            level++;  // Increase the level after processing all words in this level
        }
        return 0;  // No transformation sequence found
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        int i = new WordLadderI().ladderLength(beginWord, endWord, Arrays.asList(wordList));
        System.out.println(i);
    }
}
