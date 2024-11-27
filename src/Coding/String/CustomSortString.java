package Coding.String;

public class CustomSortString {
    public String customSortString(String order, String s) {
        // Create a frequency array for characters
        int[] count = new int[26]; // Assuming only lowercase English letters
        // Count occurrences of each character in s
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder result = new StringBuilder();
        // Append characters in the order specified
        for (char c : order.toCharArray()) {
            while (count[c - 'a'] > 0) {
                result.append(c);
                count[c - 'a']--;
            }
        }
        // Append remaining characters that are not in order
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                result.append((char) (i + 'a'));
                count[i]--;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String order = "cba", s = "abcd";
        String s1 = new CustomSortString().customSortString(order, s);
        System.out.println(s1);
    }
}
