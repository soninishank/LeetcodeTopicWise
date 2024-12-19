import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {


    List<String> resultList = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return resultList;
        }
        char[] charArray = digits.toCharArray();
        HashMap<Character, String> hashMap = new HashMap<>();
        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");

        backtrack(charArray, 0, hashMap, new StringBuilder());

        return resultList;
    }

    private void backtrack(char[] charArray, int index, HashMap<Character, String> hashMap, StringBuilder stringBuilder) {
        if (stringBuilder.length() == charArray.length) {
            resultList.add(stringBuilder.toString());
            return;
        }
        if (index == charArray.length) {
            return;
        }
        String str = hashMap.get(charArray[index]);
        char[] charArray1 = str.toCharArray();
        for (int i = 0; i < charArray1.length; i++) {
            stringBuilder.append(charArray1[i]);
            backtrack(charArray, index + 1, hashMap, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "2";
        List<String> strings = new Test().letterCombinations(digits);
        System.out.println(strings);
    }
}

