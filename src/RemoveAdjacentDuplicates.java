public class RemoveAdjacentDuplicates {

    private String removeElements(String str, int index, StringBuilder stringBuilder) {
        int i = 0;
        int start = i;
        int end = i;
        while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
            end = i;
            i++;
        }
        return "";
    }

    public static void main(String[] args) {
        String str = "AAAAABBCCBCDA";
        new RemoveAdjacentDuplicates().removeElements(str, 0, new StringBuilder());
    }
}
