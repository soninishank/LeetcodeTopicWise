package Coding.WordSeries;

import java.util.ArrayList;
import java.util.List;

// !resultList.contains(word) because there might be duplicates - [["o","a","b","n"],["o","t","a","e"],["a","h","k","r"],["a","f","l","v"]]  O/p : ["oa","oaa"]
// https://leetcode.com/problems/word-search-ii/
// This solution will give TLE
// TC - O(W.L.m.n) - W is word , L is length of the word , m * n is grid
// SC - O(L+W. L)
public class WordSearchII {

    List<String> resultList = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        // We are iterating every word
        for (String word : words) {
            // we are always starting from index 0 and doing the DFS
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    // checking if the character is matching with the word first character
                    if (board[i][j] == word.charAt(0) && !resultList.contains(word) && exist(board, i, j, word, 0)) {
                        resultList.add(word);
                    }
                }
            }
        }
        return resultList;
    }

    private boolean exist(char[][] board, int i, int j, String word, int ind) {
        if (ind == word.length()) {
            return true;
        }
        if (i > board.length - 1 || i < 0 || j < 0 || j > board[0].length - 1 || board[i][j] != word.charAt(ind))
            return false;
        board[i][j] = '*';
        boolean result = exist(board, i - 1, j, word, ind + 1) || exist(board, i, j - 1, word, ind + 1) || exist(board, i, j + 1, word, ind + 1) || exist(board, i + 1, j, word, ind + 1);
        board[i][j] = word.charAt(ind);
        return result;
    }

    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] arr = {"oath", "pea", "eat", "rain"};
        List<String> words = new WordSearchII().findWords(board, arr);
        System.out.println(words);
    }
}
