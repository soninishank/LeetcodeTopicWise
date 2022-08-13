package Coding.Recursion;

public class DeleteAdjacentDuplicates {
    private static void removeCharacters(String str) {
        if (str.length() == 0) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        int i = 0;
        while (i + 1 < stringBuilder.length() && stringBuilder.charAt(i) == stringBuilder.charAt(i + 1)) {
            i++;
        }

    }

    public static void main(String[] args) {
        String str = "AABBCDMMMM";
        removeCharacters(str);
    }


}
