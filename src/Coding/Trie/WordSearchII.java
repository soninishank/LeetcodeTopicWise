package Coding.Trie;

import java.util.ArrayList;
import java.util.List;

// It's a very easy question if you know trie
// 212. Word Search II
// https://leetcode.com/problems/word-search-ii/
// N is the number of words and L is average word length
// O(N⋅L+M⋅N⋅4^L) - TC
// Space complexity is - O ( N * L ) for the Trie and result storage and O(L) for the DFS recursion stack.
//
public class WordSearchII {
    List<String> result = new ArrayList<>();
    private final TrieNode trieNode = new TrieNode();

    // Exact same code that we have used in implement trie function
    private void insert(String word) {
        TrieNode node = trieNode;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setActualWord(word);
        node.setEnd();
    }

    public List<String> findWords(char[][] board, String[] words) {
        // Build trie with words
        for (String word : words) {
            insert(word);
        }
        // now search for a word
        int row = board.length;
        int col = board[0].length;

        // traverse in the grid (just once) and find all the words
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char currentChar = board[i][j];
                // if char exist in trie
                if (trieNode.containsKey(currentChar)) {
                    applyDFS(board, trieNode, i, j);
                }
            }
        }
        return result;
    }

    // DFS template
    void applyDFS(char[][] board, TrieNode trieNode, int row, int col) {
        if (row < 0 || col < 0 || row > board.length - 1 || col > board[0].length - 1) {
            return;
        }
        // if visited already
        if (board[row][col] == '#') {
            return;
        }
        // if the child is not present
        char currentChar = board[row][col];
        if (!trieNode.containsKey(currentChar)) {
            return;
        }
        trieNode = trieNode.get(currentChar);
        if (trieNode.isEnd()) {
            result.add(trieNode.getActualWord());
            // https://youtu.be/DMP2bqW6URA?list=PLpIkg8OmuX-I99uuP2BZOz4mI_lms4gVG&t=2388
            trieNode.isEnd = false;
        }
        board[row][col] = '#'; // marking visited

        applyDFS(board, trieNode, row + 1, col);
        applyDFS(board, trieNode, row - 1, col);
        applyDFS(board, trieNode, row, col + 1);
        applyDFS(board, trieNode, row, col - 1);
        board[row][col] = currentChar; // marking unvisited
    }
}
