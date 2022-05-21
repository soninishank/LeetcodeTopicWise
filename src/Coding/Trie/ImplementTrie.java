package Coding.Trie;

public class ImplementTrie {
    private TrieNode root;

    public ImplementTrie() {
        root = new TrieNode();
    }

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
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentLetter = word.charAt(i);
            if (node.containsKey(currentLetter)) {
                node = node.get(currentLetter);
            } else {
                return null;
            }
        }
        return node;
    }

    // check if the word is in trie
    private boolean search(String word) {
        TrieNode trieNode = searchPrefix(word);
        return trieNode != null && trieNode.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode trieNode = searchPrefix(prefix);
        return trieNode != null;
    }

    public static void main(String[] args) {
        new ImplementTrie().insert("nishank");
    }
}
