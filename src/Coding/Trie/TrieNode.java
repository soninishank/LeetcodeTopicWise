package Coding.Trie;

public class TrieNode {
    // R links to node children
    final TrieNode[] links;
    public boolean isEnd;
    private String actualWord;

    public TrieNode() {
        this.links = new TrieNode[256];
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

    public void setActualWord(String actualWord) {
        this.actualWord = actualWord;
    }

    public String getActualWord() {
        return actualWord;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
