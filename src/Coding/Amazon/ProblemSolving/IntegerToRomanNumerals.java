package Coding.Amazon.ProblemSolving;

public class IntegerToRomanNumerals {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] charName = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String result = "";
        while (num > 0) {
            for (int i = 0; i < values.length; i++) {
                if (num / values[i] > 0) {
                    int count = num / values[i];
                    num = num % values[i];
                    // repeat the characters based on count
                    while (count > 0) {
                        result += charName[i];
                        count--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = new IntegerToRomanNumerals().intToRoman(3749);
        System.out.println(s);
    }
}
