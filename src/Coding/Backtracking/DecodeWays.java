package Coding.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class DecodeWays {
    int count = 0;
    String name = "nishank";
    boolean flag;

    public int numDecodings(String s) {
        if (s.length() == 0) {
            return count;
        }
        HashMap<Integer, Character> hashMap = new HashMap<>();
        hashMap.put(1, 'A');
        hashMap.put(2, 'B');
        hashMap.put(3, 'C');
        hashMap.put(4, 'D');
        hashMap.put(5, 'E');
        hashMap.put(6, 'F');
        hashMap.put(7, 'G');
        hashMap.put(8, 'H');
        hashMap.put(9, 'I');
        hashMap.put(10, 'J');
        hashMap.put(11, 'K');
        hashMap.put(12, 'L');
        hashMap.put(13, 'M');
        hashMap.put(14, 'N');
        hashMap.put(15, 'O');
        hashMap.put(16, 'P');
        hashMap.put(17, 'Q');
        hashMap.put(18, 'R');
        hashMap.put(19, 'S');
        hashMap.put(20, 'T');
        hashMap.put(21, 'U');
        hashMap.put(22, 'V');
        hashMap.put(23, 'W');
        hashMap.put(24, 'X');
        hashMap.put(25, 'Y');
        hashMap.put(26, 'Z');
        doBacktracking(s, hashMap, 0, new ArrayList<>());
        return count;
    }

    private void doBacktracking(String str, HashMap<Integer, Character> hashMap, int index, ArrayList<Integer> list) {
        if (index > str.length()) {
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String substring = str.substring(0, i + 1);
            if (hashMap.containsKey(Integer.valueOf(substring))) {
                count++;
                String remainingSubstring = str.substring(i + 1);
                doBacktracking(remainingSubstring, hashMap, index + 1, list);
            }
        }
    }

    public static void main(String[] args) {
        String s = "226";
        int i = new DecodeWays().numDecodings(s);
        System.out.println(i);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DecodeWays)) return false;
        DecodeWays that = (DecodeWays) o;
        return count == that.count && flag == that.flag && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, name, flag);
    }
}
