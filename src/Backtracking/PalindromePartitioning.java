package Backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/palindrome-partitioning/
// we reduce the string everytime until it become zero - that's the condition of recursion
// index i = 0
public class PalindromePartitioning {
    List<List<String>> resultList = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s.length() == 0) {
            return resultList;
        }
        applyPalindromePartition(s, new ArrayList<>());
        return resultList;
    }

    private void applyPalindromePartition(String str, ArrayList<String> arrayList) {
        if (str.length() == 0) {
            resultList.add(new ArrayList<>(arrayList));
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String substring = str.substring(0, i + 1);
            if (isPalindrome(substring)) {
                arrayList.add(substring);
                String remainingSubstring = str.substring(i + 1);
                applyPalindromePartition(remainingSubstring, arrayList);
                arrayList.remove(arrayList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String substring) {
        int low = 0, high = substring.length() - 1;
        while (low <= high) {
            if (substring.charAt(low) == substring.charAt(high)) {
                low++;
                high--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "madam";
        List<List<String>> partition = new PalindromePartitioning().partition(s);
        System.out.println(partition);
    }
}
