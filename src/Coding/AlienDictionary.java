package Coding;

public class AlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        // Create a mapping of character to its index in the alien dictionary
        int[] orderMap = new int[26];
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
        int minLength = Math.min(length1, length2);

        // Compare letter by letter
        for (int i = 0; i < minLength; i++) {
            char char1 = word1.charAt(i);
            char char2 = word2.charAt(i);
            if (char1 != char2) {
                // Compare based on the order given in the alien dictionary
                return orderMap[char1 - 'a'] < orderMap[char2 - 'a'];
            }
        }

        // If all letters are the same up to minLength, compare lengths
        return length1 <= length2;
    }

    public static void main(String[] args) {
        AlienDictionary alienDictionary = new AlienDictionary();
        String[] words = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";

        boolean result = alienDictionary.isAlienSorted(words, order);
        System.out.println(result); // Output: true
    }

}
