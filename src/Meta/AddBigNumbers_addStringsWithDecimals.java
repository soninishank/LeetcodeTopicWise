package Meta;

public class AddBigNumbers_addStringsWithDecimals {
    public String addString(String str1, String str2) {
        final String ZERO = "0";
        String[] s1 = str1.split("\\.");
        String[] s2 = str2.split("\\.");

        StringBuilder sb = new StringBuilder();

        // step 1. calculate decimal points after decimal points
        // Prepare decimal point. - so we can get the sum of decimal values
        String sd1 = s1.length > 1 ? s1[1] : ZERO;
        String sd2 = s2.length > 1 ? s2[1] : ZERO;

        // If the length is not equal, add extra zeros
        while (sd1.length() != sd2.length()) {
            if (sd1.length() < sd2.length()) {
                sd1 += ZERO;
            } else {
                sd2 += ZERO;
            }
        }
        int carry = addStringHelper(sd1, sd2, sb, 0);
        sb.append(".");

        // Step 2. Calculate Number before decimal point.
        int finalCarry = addStringHelper(s1[0], s2[0], sb, carry);
        if (finalCarry > 0) {
            sb.append(finalCarry);
        }
        return sb.reverse().toString();
    }

    // This is a modified version of add strings.
    // LC: https://leetcode.com/problems/add-strings/
    private int addStringHelper(String str1, String str2, StringBuilder sb, int carry) {
        int i = str1.length() - 1;
        int j = str2.length() - 1;
        while (i >= 0 || j >= 0) {
            int sum = carry;

            if (j >= 0) {
                sum += str2.charAt(j) - '0';
                j--;
            }
            if (i >= 0) {
                sum += str1.charAt(i) - '0';
                i--;
            }
            carry = sum / 10;
            sb.append(sum % 10);
        }
        return carry;
    }

    public static void main(String[] args) {

        //Example 1:
        String str1 = "123.52";
        String str2 = "11.2";
        String ans = new AddBigNumbers_addStringsWithDecimals().addString(str1, str2);
        System.out.println(ans);

//        //Example 2:
//        str1 = "110.75";
//        str2 = "9";
//        ans = new AddBigNumbers_addStringsWithDecimals().addString(str1, str2);
//        System.out.println(ans);
    }
}
