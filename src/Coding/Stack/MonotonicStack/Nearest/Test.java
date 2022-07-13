package Coding.Stack.MonotonicStack.Nearest;

public class Test {
    public int countCharacters(String[] words, String chars) {
        int[] arr1 = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            arr1[chars.charAt(i) - 'a']++;
        }
        int count = 0;
        for (String str : words) {
            if (doCompare(str, arr1.clone())) {
                count += str.length();
            }
        }
        return count;
    }

    private boolean doCompare(String arr1, int[] arr2) {
        for (char c1 : arr1.toCharArray()) {
            if (--arr2[c1 - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void myCount(int n) {
        if (n < 0) {
            return;
        }
        System.out.println(n);
        myCount(n - 1);
        myCount(n - 2);
    }

    public static void main(String[] args) {
//        String[] words = {"cat", "bt", "hat", "tree"};
//        String chars = "atach";
//        int i = new Test().countCharacters(words, chars);
//        System.out.println(i);
        myCount(4);
    }
}