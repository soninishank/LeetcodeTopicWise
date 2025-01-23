package Coding.Amazon.ProblemSolving;

import java.util.ArrayList;
import java.util.List;

// ProductSuggestionSystem
// 3 suggestions
// input is given 1 by 1
public class DesignASearchSystem {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        List<String> suggestions = new ArrayList<>();
    }

    private void insert(TrieNode root, String product) {
        TrieNode node = root;
        for (char c : product.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
            // Add product to suggestions, maintaining at most 3 suggestions
            if (node.suggestions.size() < 3) {
                node.suggestions.add(product);
            }
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        // Build the Trie
        for (String product : products) {
            insert(root, product);
        }

        List<List<String>> result = new ArrayList<>();
        TrieNode node = root;
        for (char c : searchWord.toCharArray()) {
            if (node != null) {
                node = node.children[c - 'a'];
            }
            result.add(node == null ? new ArrayList<>() : node.suggestions);
        }

        return result;
    }


    public static void main(String[] args) {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";

        List<List<String>> output = new DesignASearchSystem().suggestedProducts(products, searchWord);

        // Print the result
        System.out.println(output);
    }
}
