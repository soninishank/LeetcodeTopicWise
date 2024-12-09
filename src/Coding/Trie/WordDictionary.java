package Coding.Trie;

// https://leetcode.com/problems/design-add-and-search-words-data-structure/
// Design Add and Search Words Data Structure
class WordDictionary {
    TrieNode trieNode;

    public WordDictionary() {
        trieNode = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = trieNode;
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (node.links[ch - 'a'] == null) {
                node.links[ch - 'a'] = new TrieNode();
            }
            node = node.links[ch - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode search = trieNode;
        return helper(word, 0, search);
    }

    private boolean helper(String word, int currentIndex, TrieNode node) {
        if (node == null) {
            return false;
        }
        if (currentIndex == word.length()) {
            return node.isEnd;
        }
        if (word.charAt(currentIndex) == '.') {
            for (TrieNode child : node.links) {
                if (child != null && helper(word, currentIndex + 1, child)) {
                    return true;
                }
            }
            return false;
        } // if it's not a dot
        else {
            char ch1 = word.charAt(currentIndex);
            if (node.links[ch1 - 'a'] == null) {
                return false;
            }
            node = node.links[ch1 - 'a']; // updating the root reference
            return helper(word, currentIndex + 1, node);
        }
    }
}