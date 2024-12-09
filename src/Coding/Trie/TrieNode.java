package Coding.Trie;

public class TrieNode {
    // R links to node children
    public final TrieNode[] links;
    public boolean isEnd;
    public String actualWord;

    public TrieNode() {
        this.links = new TrieNode[256];
    }
}
