package Coding.Trie;

// https://leetcode.com/problems/implement-trie-prefix-tree/
public class ImplementTrie {
    private final TrieNode root;

    public ImplementTrie() {
        root = new TrieNode();
    }

    // Time complexity - O (n)
    // Space complexity - O ( m * n )
    private void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    // search a key in trie
    // Time complexity - O (n)
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (node.containsKey(currentChar)) {
                node = node.get(currentChar);
            } else {
                return false;
            }
        }
        return node.isEnd();
    }

    // Time complexity - O (n)
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char currentChar = prefix.charAt(i);
            if (node.containsKey(currentChar)) {
                node = node.get(currentChar);
            } else {
                return false;
            }
        }
        return node != null;
    }

    public static void main(String[] args) {
        ImplementTrie trie = new ImplementTrie();
        trie.insert("hello");
        trie.search("hell");   // return True
        trie.search("helloa");     // return False
        trie.startsWith("app"); // return True
        trie.insert("app");
        trie.search("app");     // return True
        trie.startsWith("a"); //
    }
}
