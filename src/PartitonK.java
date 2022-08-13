public class PartitonK {
    public boolean validPartition(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        Boolean[] dp = new Boolean[nums.length + 1];
        return applyPartition(nums, 0, dp);
    }

    private boolean applyPartition(int[] nums, int index, Boolean[] dp) {
        if (index > nums.length - 1) {
            return false;
        }
        if (dp[index] != null) {
            return dp[index];
        }
        if (isValid3(nums, index, index + 3) || isValid2(nums, index, index + 3)) // 0 , 3 but i can run from 0 to 2
        {
            if (applyPartition(nums, index + 3, dp)) {
                dp[index] = true;
                return true;
            }
        }
        if (isValid2(nums, index, index + 2)) // 0 , 2 but i can run from 0 to 1
        {
            if (applyPartition(nums, index + 2, dp)) {
                dp[index] = true;
                return true;
            }
        }
        dp[index] = false;
        return false;
    }

    private boolean isValid3(int[] nums, int start, int end) {
        if (end - 1 > nums.length - 1) {
            return false;
        }
        for (int i = start; i < end - 1; i++) {
            if (nums[i + 1] - nums[i] != 1) {
                return false;
            }
        }
        return true;
    }

    // start = 0 , end = 3
    private boolean isValid2(int[] nums, int start, int end) {
        if (end - 1 > nums.length - 1) {
            return false;
        }
        for (int i = start; i < end - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {4, 4, 4, 5, 6};
        boolean b = new PartitonK().validPartition(arr);
        System.out.println(b);
    }
}

// 1,1,1,2
// index = 0 -> 3 consecutive or diff -> true
//                      index -> 3
//                              consecutive or diff-> false
//                              2  -> false
// index = 0 -> 2 consecutive -> return true
//                      index -> 2
//                          consecutive or diff -> false
//                          2 consecutive -> false;
