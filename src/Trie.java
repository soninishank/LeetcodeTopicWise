public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    private class TrieNode {
        public boolean isWord;
        public TrieNode[] children;

        public TrieNode() {
            this.children = new TrieNode[26]; // having 26 links , 1 for each alphabet - either null or point to another trieNde
            this.isWord = false;
        }
    }

    public void insert(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) {
                ws.children[c - 'a'] = new TrieNode();
            }
            ws = ws.children[c - 'a']; // each and every character is a TrieNode - now your ws shifted to that index reference
        }
        ws.isWord = true; // last character
    }

    public boolean search(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (ws.children[c] == null) {
                return false;
            }
            ws = ws.children[c];
        }
        return ws.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for (int i = 0; i < prefix.length(); i++) {
            int c = prefix.charAt(i) - 'a';
            if (ws.children[c] == null) // we are just checking whether that character exists or not , not checking the isWord
            {
                return false;
            }
            ws = ws.children[c];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // return True
        trie.search("app");     // return False
        trie.startsWith("app"); // return True
        trie.insert("app");
        trie.search("app");     // return True
    }
}