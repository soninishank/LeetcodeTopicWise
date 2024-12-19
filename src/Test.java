public class Test {
    int minStart = 0;
    int maxLength = Integer.MIN_VALUE;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            checkPalindrome(s, i, i); // TODO : You are passing the same index
            checkPalindrome(s, i, i + 1); // TODO : You are passing the i and i+1
        }
        return s.substring(minStart, minStart + maxLength);
    }

    // we are passing complete string
    // and just checking through index
    private void checkPalindrome(String s, int low, int high) {
        while (low >= 0 && high < s.length()) {
            if (s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            } else {
                break;
            }
        }
        int diff = high - low - 1;
        if (diff > maxLength) {
            maxLength = diff;
            minStart = low + 1;
        }
    }

    public static void main(String[] args) {
        String digits = "babad";
        String res = new Test().longestPalindrome(digits);
        System.out.println(res);
    }
}

