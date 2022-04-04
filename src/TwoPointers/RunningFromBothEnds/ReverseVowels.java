package TwoPointers.RunningFromBothEnds;

/**
 * @author Nishank Soni
 * @project Leet Code Topic Wise on 4/1/22
 */
public class ReverseVowels {
    public String reverseVowels(String str) {
        int low = 0, high = str.length() - 1;
        char[] ch = str.toCharArray();
        String s = "aeiouAEIOU";
        while (low < high) {
            char lowSide = ch[low];
            char highSide = ch[high];
            if (s.indexOf(lowSide) >= 0 && s.indexOf(highSide) >= 0) {
                char temp = ch[low];
                ch[low] = ch[high];
                ch[high] = temp;
                low++;
                high--;
            } else if (!(s.indexOf(lowSide) >= 0)) {
                low++;
            } else {
                high--;
            }
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        String s = "hello";
        String s1 = new ReverseVowels().reverseVowels(s);
        System.out.println(s1);
    }
}
