package WordSeries;

import java.util.ArrayList;
import java.util.List;

// !resultList.contains(word) because there might be duplicates - [["o","a","b","n"],["o","t","a","e"],["a","h","k","r"],["a","f","l","v"]]  O/p : ["oa","oaa"]
// https://leetcode.com/problems/word-search-ii/
// This solution will give TLE
public class WordSearchII {

    List<String> resultList = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == word.charAt(0) && !resultList.contains(word) && exist(board, i, j, word, 0)) {
                        resultList.add(word);
                    }
                }
            }
        }
        return resultList;
    }

    private boolean exist(char[][] board, int currentRow, int currentCol, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (index > word.length()) {
            return false;
        }
        if (currentRow >= 0 && currentRow <= board.length - 1 && currentCol >= 0 && currentCol <= board[0].length - 1 && board[currentRow][currentCol] == word.charAt(index)) {
            board[currentRow][currentCol] = '*';
            boolean result = exist(board, currentRow - 1, currentCol, word, index + 1) ||
                    exist(board, currentRow + 1, currentCol, word, index + 1) ||
                    exist(board, currentRow, currentCol - 1, word, index + 1) ||
                    exist(board, currentRow, currentCol + 1, word, index + 1);
            board[currentRow][currentCol] = word.charAt(index);
            return result;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] arr = {"oath", "pea", "eat", "rain"};
        List<String> words = new WordSearchII().findWords(board, arr);
        System.out.println(words);
    }
}
