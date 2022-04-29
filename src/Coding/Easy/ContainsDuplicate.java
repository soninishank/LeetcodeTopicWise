package Coding.Easy;

public class ContainsDuplicate {
    public int trailingZeroes(int n) {
        int i = 1;
        double val = 5;
        int result = 0;
        while (n >= val) {
            val = Math.pow(5.0d, i);
            result += n / val;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int i = new ContainsDuplicate().trailingZeroes(4617);
        System.out.println(i);
    }
}
