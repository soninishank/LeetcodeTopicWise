// afc -> a.c   -> equal
// aab -> .a.   -> equal
// a. -> ad -> equal
public class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
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


    public void addWord(String word) {
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
        return searchHelper(root, word);
    }


    public boolean searchHelper(TrieNode root, String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            // int c = word.charAt(i) - 'a'; // for . it will throw index out of bound exception
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode trieNodeChildren : ws.children) {
                    if (trieNodeChildren != null) {
                        if (searchHelper(trieNodeChildren, word.substring(i + 1))) {
                            return true;
                        }
                    }
                }
                return false;
            } else if (ws.children[c - 'a'] == null) {
                return false;
            }
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }


    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }


}

// b.d -> [bad,bdb]
//      b       d
//   a    d          a
// d        b             d

// b.d