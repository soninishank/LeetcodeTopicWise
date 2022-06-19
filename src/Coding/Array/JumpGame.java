package Coding.Array;

// https://www.youtube.com/watch?v=muDPTDrpS28
public class JumpGame {
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (reachable < i) {
                return false;
            }
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        boolean b = new JumpGame().canJump(nums);
        System.out.println(b);
    }
}
