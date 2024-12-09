package Coding.Trie;

// 79. Word Search
// https://leetcode.com/problems/word-search/
public class WordSearchI {
    private final TrieNode trieNode = new TrieNode();


    // Exact same code that we have used in implement trie function
    private void insert(String word) {
        TrieNode node = trieNode;
        char[] charArray = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            char currentChar = charArray[i];
            if (node.links[currentChar - 'a'] == null) {
                node.links[currentChar - 'a'] = new TrieNode();
            }
            node = node.links[currentChar - 'a'];
        }
        node.actualWord = word;
        node.isEnd = true;
    }

    private boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return false;
        }
        insert(word);
        // now search for a word
        int row = board.length;
        int col = board[0].length;

        // traverse in the grid (just once) and find all the words
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char currentChar = board[i][j];
                // if char exist in trie
                if (trieNode.links[currentChar - 'a'] != null) {
                    if (applyDFS(board, trieNode, i, j)) { // it might be possible that he wasn't able to find it in first iteration
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean applyDFS(char[][] board, TrieNode trieNode, int row, int col) {
        if (row < 0 || col < 0 || row > board.length - 1 || col > board[0].length - 1) {
            return false;
        }
        // if visited already
        if (board[row][col] == '#') {
            return false;
        }
        // if the child is not present
        char currentChar = board[row][col];
        if (trieNode.links[currentChar - 'a'] == null) {
            return false;
        }
        trieNode = trieNode.links[currentChar - 'a'];
        if (trieNode.isEnd) {
            return true;
        }
        board[row][col] = '#'; // marking visited

        boolean res = applyDFS(board, trieNode, row + 1, col) ||
                applyDFS(board, trieNode, row - 1, col) ||
                applyDFS(board, trieNode, row, col + 1) ||
                applyDFS(board, trieNode, row, col - 1);
        board[row][col] = currentChar; // marking unvisited
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'a', 'b', 'c', 'e'},
                {'s', 'f', 'c', 's'},
                {'a', 'd', 'e', 'e'}
        };
        boolean see = new WordSearchI().exist(board, "see");
        System.out.println(see);

    }
}
