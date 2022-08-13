import java.util.Arrays;

public class PT {

    public boolean canPartition(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        boolean alphabetic = Character.isAlphabetic('1');
        System.out.println(alphabetic);
        int totalSum = Arrays.stream(nums).sum();
        if (totalSum % 2 != 0) {
            return false;
        }
        return applyRecursion(nums, totalSum / 2, nums.length - 1);
    }

    boolean applyRecursion(int[] nums, int totalSum, int index) {
        if (totalSum == 0) {
            return true;
        }
        if (index < 0) {
            return false;
        }
        boolean first = applyRecursion(nums, totalSum - nums[index], index - 1);
        boolean last = applyRecursion(nums, totalSum, index - 1);
        return first || last;
    }

    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int low = 0, high = chars.length - 1;
        while (low <= high) {
            if (Character.isAlphabetic(chars[low]) && Character.isAlphabetic(chars[high])) {
                char c = s.charAt(low);
                chars[low] = chars[high];
                chars[high] = c;
                low++;
                high--;
            } else if (Character.isAlphabetic(s.charAt(low))) {
                low++;
            } else {
                high--;
            }
        }
        return chars.toString();
    }

    public static void main(String[] args) {
        int[] numRows = {1, 2, 5};
        boolean generate = new PT().canPartition(numRows);
        System.out.println(generate);
    }
}
