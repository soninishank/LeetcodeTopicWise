package WordSeries;

import java.util.*;

// https://leetcode.com/problems/word-ladder/
// You need three data structures
// 1.Queue -> for running the BFS
// 2.visited -> to not go in the loop
// 3.set -> to have a list of all words
// Just change the characters from a to z
public class WordLadderI {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Set<String> visited = new HashSet<>();
        queue.add(beginWord);

        int changes = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) return changes;

                for (int j = 0; j < word.length(); j++) {
                    for (int k = 'a'; k <= 'z'; k++) {
                        char arr[] = word.toCharArray();
                        arr[j] = (char) k;

                        String str = new String(arr);
                        if (set.contains(str) && !visited.contains(str)) {
                            queue.add(str);
                            visited.add(str);
                        }
                    }
                }
            }
            ++changes;
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        int i = new WordLadderI().ladderLength(beginWord, endWord, Arrays.asList(wordList));
        System.out.println(i);
    }
}
