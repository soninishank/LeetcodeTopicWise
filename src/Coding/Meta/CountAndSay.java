package Coding.Meta;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String say = countAndSay(n - 1);
        String result = "";
        // Just count and store in result and return
        for (int i = 0; i < say.length(); i++) {
            int count = 1;
            char actualChar = say.charAt(i);
            //It is important because when you have 1, it will not go into while loop
            while (i < say.length() - 1 && actualChar == say.charAt(i + 1)) {
                count++;
                i++;
            }
            result += String.valueOf(count) + String.valueOf(actualChar);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = new CountAndSay().countAndSay(4);
        System.out.println(s);
    }
}
