package Coding.WordSeries;

import java.util.*;

// https://leetcode.com/problems/word-ladder-ii/
// It's a Four step process
// 1. Queue -> path of string
// 2. take last element of list after polling from queue - and find all neighbours
// 3. add these neighbours to the path returned and add this to a new list
// 4.
public class WordLadderII {
    List<List<String>> resultList = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> OriginalWordSet = new HashSet<>(wordList);
        if (!OriginalWordSet.contains(endWord)) {
            return resultList;
        }
        Queue<List<String>> queue = new LinkedList<>();   // each element in queue is a path
        queue.offer(Arrays.asList(beginWord));
        Set<String> visitedSet = new HashSet<>();
        visitedSet.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<String> currPath = queue.poll();
                String lastWord = currPath.get(currPath.size() - 1);// get only last element because we want to build
                // the path from there
                List<String> neighbors = getNeighbors(lastWord, OriginalWordSet);
                for (String neighbour : neighbors) {
                    List<String> newPath = new ArrayList<>(currPath);
                    newPath.add(neighbour);
                    visitedSet.add(neighbour);
                    if (neighbour.equals(endWord)) {
                        resultList.add(newPath);
                    } else {
                        queue.offer(newPath);
                    }
                }
            }
            for (String s : visitedSet)   // remove used words from wordSet to avoid going back
            {
                OriginalWordSet.remove(s);
            }
        }
        return resultList;
    }

    private List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new LinkedList<>();
        for (int i = 0; i < word.length(); i++) {
            char[] ch = word.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                ch[i] = c;
                String str = new String(ch);
                if (wordSet.contains(str))  // only get valid neighbors
                    neighbors.add(str);
            }
        }
        return neighbors;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<List<String>> ladders = new WordLadderII().findLadders(beginWord, endWord, Arrays.asList(wordList));
        System.out.println(ladders);
    }
}
