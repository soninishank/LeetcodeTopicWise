package Coding.String;

import java.util.HashMap;

// https://leetcode.com/problems/longest-palindrome/
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashmap.put(s.charAt(i), hashmap.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        boolean flag = false;
        for (char keyName : hashmap.keySet()) {
            int value = hashmap.get(keyName);
            if (value % 2 == 0) {
                count += value;
            } else if (value % 2 == 1 && !flag) {
                flag = true;
                count += value;
            } else if (value % 2 == 1) {
                count += value - 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        int i = new LongestPalindrome().longestPalindrome(str);
        System.out.println(i);
    }
}
