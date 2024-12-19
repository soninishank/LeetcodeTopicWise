package Coding.String;

// https://leetcode.com/problems/verifying-an-alien-dictionary/
public class VerifyingAnAlienDictionary {
    // 1. Step 1: Create the Order Map
// 2. Step 2: Iterate Over the Words Array
// 3. Step 3: Conclusion for All Words
    public boolean isAlienSorted(String[] words, String order) {
        // Create a mapping of character to its index in the alien dictionary
        int[] orderMap = new int[26]; // map every character to index
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }

        // Compare each consecutive pair of words
        for (int i = 0; i < words.length - 1; i++) {
            if (!isInCorrectOrder(words[i], words[i + 1], orderMap)) {
                return false; // If any pair is not sorted, return false
            }
        }
        return true; // All pairs are sorted
    }

    // Helper function to compare two words
    private boolean isInCorrectOrder(String word1, String word2, int[] orderMap) {
        int length1 = word1.length();
        int length2 = word2.length();
        int minLength = Math.min(length1, length2); // iterate till min length

        // Compare letter by letter
        for (int i = 0; i < minLength; i++) {
            char char1 = word1.charAt(i);
            char char2 = word2.charAt(i);
            if (char1 != char2) { // if words did not match
                // Compare based on the order given in the alien dictionary
                // orderMap[char2 - 'a'] it should be greater
                return orderMap[char1 - 'a'] < orderMap[char2 - 'a'];
            }
        }

        // If all letters are the same up to minLength, compare lengths
        return length1 <= length2;
    }

// This is for last return statement -> length1 <= length2;
// Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
// Output: false
// Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character

    public static void main(String[] args) {
        VerifyingAnAlienDictionary verifyingAnAlienDictionary = new VerifyingAnAlienDictionary();
        String[] words = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";

        boolean result = verifyingAnAlienDictionary.isAlienSorted(words, order);
        System.out.println(result); // Output: true
    }

}
