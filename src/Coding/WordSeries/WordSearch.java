package Coding.WordSeries;

// https://leetcode.com/problems/word-search/
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && exist(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
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
}

//    I think the overall time complexity is closer to O(N*3^min(L, N)).
//    Each cell has only 3 directions to be potentially explored because one direction has been already visited by
//    its parent.
//    So, the worst case can be expressed by N * 4 * 3^min(L - 1, N - 1) (4 means the beginning point) and by big O,
//    O(N * 3^min(L, N))