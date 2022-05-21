package Coding.String;

import java.util.ArrayList;
import java.util.List;

public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        List<Integer> list = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                list.add(count);
                count = 1;
            }
        }
        list.add(count);
        int result = 0;
        for (int i = 1; i < list.size(); i++) {
            result += Math.min(list.get(i - 1), list.get(i));
        }
        return result;
    }


    public static void main(String[] args) {
        String str = "0110001111";
        int i = new CountBinarySubstrings().countBinarySubstrings(str);
        System.out.println(i);
    }
}
