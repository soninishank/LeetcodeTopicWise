package Coding.Trie;

// https://leetcode.com/problems/design-add-and-search-words-data-structure/
// Design Add and Search Words Data Structure
class WordDictionary {
    TrieNode trieNode;

    public WordDictionary() {
        trieNode = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode start = trieNode;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!start.containsKey(ch)) {
                start.put(ch, new TrieNode());
            }
            start = start.get(ch);
        }
        start.setEnd();
    }

    public boolean search(String word) {
        TrieNode search = trieNode;
        return helper(word, 0, search);
    }

    private boolean helper(String word, int currentIndex, TrieNode root) {
        if (root == null) {
            return false;
        }
        if (currentIndex == word.length()) {
            return root.isEnd();
        }
        if (word.charAt(currentIndex) == '.') {
            for (TrieNode child : root.links) {
                if (child != null && helper(word, currentIndex + 1, child)) {
                    return true;
                }
            }
            return false;
        } // if it's not a dot
        else {
            if (!root.containsKey(word.charAt(currentIndex))) {
                return false;
            }
            root = root.get(word.charAt(currentIndex)); // updating the root reference
            return helper(word, currentIndex + 1, root);
        }
    }
}