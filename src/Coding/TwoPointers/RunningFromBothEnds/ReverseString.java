package Coding.TwoPointers.RunningFromBothEnds;

/**
 * @author Nishank Soni
 * @project Leet Code Topic Wise on 4/1/22
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int low = 0, high = s.length - 1;
        while (low < high) {
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            low++;
            high--;
        }
    }
}
