package String;

public class RotateString {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        return (s + s).contains(goal);
    }

    // understand substring method
    // Params:
    // beginIndex – the beginning index, inclusive.
    // endIndex – the ending index, exclusive.
    private void testJavaSubstring(String str) {
        System.out.println(str.substring(0)); // abcde
        System.out.println(str.substring(1)); // bcde
        System.out.println(str.substring(0, 1)); // a
        System.out.println(str.substring(0, str.length())); // abcde
    }

    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";
        boolean b = new RotateString().rotateString(s, goal);
        System.out.println(b);

        new RotateString().testJavaSubstring(s);
    }

}
