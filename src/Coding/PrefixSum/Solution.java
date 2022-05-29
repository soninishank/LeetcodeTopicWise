package Coding.PrefixSum;

import java.util.Objects;

public class Solution {
    Validator validator = new Validator();

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String str = solution.getEncryptedName("Kate Winslet");
        System.out.println(str);
    }


    private String getEncryptedName(String str) throws Exception {
        if (validator.validate(str))
        {
            char[] chars = str.toCharArray();
            int low = 0 , high = chars.length-1;
            while (low <= high){
                char temp = chars[low];
                chars[low] = chars[high];
                chars[high] = temp;
                low++;
                high--;
            }
            String s = String.valueOf(chars).toLowerCase();
            return s;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        return Objects.equals(validator, solution.validator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(validator);
    }
}

class Validator {
    public boolean validate(String name) {
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);

            if (ch != ' ' && !(Character.isLowerCase(ch) || Character.isUpperCase(ch))) {
                return false;
            }
        }

        return true;
    }
}