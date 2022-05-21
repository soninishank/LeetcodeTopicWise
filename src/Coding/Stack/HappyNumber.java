package Coding.Stack;

import java.util.HashSet;

public class HappyNumber {
    HashSet<Integer> hashset = new HashSet<>();

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        return checkValidity(n);
    }

    private boolean checkValidity(int num) {
        if (hashset.contains(num)) {
            return false;
        }
        hashset.add(num);
        int result = 0;
        while (num > 0) {
            int rem = num % 10;
            result += rem * rem;
            num = num / 10;
        }
        if (result == 1) {
            return true;
        } else {
            return checkValidity(result);
        }
    }

    public static void main(String[] args) {
        boolean happy = new HappyNumber().isHappy(2);
        System.out.println(happy);
    }
}
