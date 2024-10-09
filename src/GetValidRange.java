public class GetValidRange {
    private int getValidRange(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char prev = '0';
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '=') {
                continue;
            }
            if (s.charAt(i) == prev) {
                count++;
            } else {
                prev = s.charAt(i);
                count = 1;
            }
            max = Math.max(max, count);
        }
        return max + 1;
    }

    public static void main(String[] args) {
        GetValidRange obj = new GetValidRange();
        System.out.println("<<<" + " : " + obj.getValidRange("<<<"));
        System.out.println("<=>" + " : " + obj.getValidRange("<=>"));
        System.out.println(">><>" + " : " + obj.getValidRange(">><>"));
        System.out.println("<<<" + " : " + obj.getValidRange("<<<"));
        System.out.println("<>><<<>>=<<<<>" + " : " + obj.getValidRange("<>><<<>>=<<<<>"));
        System.out.println("<<====>>>" + " : " + obj.getValidRange("<<====>>>"));
    }
}
