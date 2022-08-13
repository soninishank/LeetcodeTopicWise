package Coding.Trie;

public class TrieNode {
    // R links to node children
    private final TrieNode[] links;
    private boolean isEnd;

    public TrieNode() {
        this.links = new TrieNode[26];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public void put(char ch, TrieNode trieNode) {
        links[ch - 'a'] = trieNode;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
