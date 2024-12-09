package Coding.String;

public class CustomSortString {
    public String customSortString(String order, String s) {
        int[] frequency = new int[26];  // Array to store the frequency of each character in 's'
        char[] sChars = s.toCharArray();  // Convert string 's' to a character array

        // Count the frequency of each character in 's'
        for (int i = 0; i < sChars.length; i++) {
            frequency[sChars[i] - 'a']++;
        }

        StringBuilder stringBuilder = new StringBuilder();  // StringBuilder to build the result string
        char[] orderChars = order.toCharArray();  // Convert string 'order' to a character array

        // Append characters from the 'order' string to the result based on frequency
        for (int i = 0; i < orderChars.length; i++) {
            while (frequency[orderChars[i] - 'a'] > 0) { // use while loop - "kqep"  "pekeq" -> output is "kqeep"
                stringBuilder.append(orderChars[i]);
                frequency[orderChars[i] - 'a']--;  // Decrease frequency of the character
            }
        }

        // Append remaining characters from 's' that are not in 'order'
        for (int i = 0; i < sChars.length; i++) {
            while (frequency[sChars[i] - 'a'] > 0) { // use while loop
                stringBuilder.append(sChars[i]);
                frequency[sChars[i] - 'a']--;  // Decrease frequency of the character
            }
        }

        return stringBuilder.toString();  // Return the final sorted string
    }


    public static void main(String[] args) {
        String order = "cba", s = "abcd";
        String s1 = new CustomSortString().customSortString(order, s);
        System.out.println(s1);
    }
}
