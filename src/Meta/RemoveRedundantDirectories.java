package Meta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/discuss/interview-question/394896/Facebook-or-Phone-Screen-or-Redundant-Paths-and-Next-Permutation
//  D be the total number of directories.
//  M be the average number of folder names per directory.
// L be the average length of a folder name.
// TC - O(D×M×L)
// SC - O(D×M×L)
public class RemoveRedundantDirectories {
    TrieNode root;

    RemoveRedundantDirectories() {
        root = new TrieNode();
    }

    public void addDirectory(String dir) {
        TrieNode node = root;
        String[] split = dir.split("/");
        for (String folder : split) {
            if (folder.isEmpty()) {
                continue;
            }
            char[] charArray = folder.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char currentChar = charArray[i];
                if (node.links[currentChar - 'a'] == null) {
                    node.links[currentChar - 'a'] = new TrieNode();
                }
                node = node.links[currentChar - 'a'];
            }
            node.isEnd = true;
            node.actualWord = folder;
        }
    }

    public static List<String> removeRedundantDirectories(List<String> dirs) {
        RemoveRedundantDirectories trie = new RemoveRedundantDirectories();
        for (String dir : dirs) {
            trie.addDirectory(dir); // Add all directories to the Trie
        }
        List<String> result = new ArrayList<>();
        trie.collectNonRedundant(trie.root, result); // Collect non-redundant directories
        return result;
    }

    public void collectNonRedundant(TrieNode node, List<String> result) {
        if (node == null) {
            return;
        }
        if (node.isEnd) {
            result.add(node.actualWord); // Add the full directory path
            return; // Stop further recursion
        }
        for (TrieNode child : node.links) {
            if (child != null) {
                collectNonRedundant(child, result);
            }
        }
    }

    public static void main(String[] args) {
        List<String> dirs = Arrays.asList("/abc/def", "/xyz", "/abc", "/xyz/lmn", "/xyz/lmn/tuv");
        List<String> result = removeRedundantDirectories(dirs);
        System.out.println(result); // Output: ["/abc", "/xyz"]
    }
}

class TrieNode {

    public String actualWord;
    TrieNode[] links;
    boolean isEnd;

    TrieNode() {
        links = new TrieNode[26];
        isEnd = false;
    }
}