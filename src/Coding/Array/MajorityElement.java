// https://leetcode.com/problems/majority-element/
// https://medium.com/@snehakweera77/169-majority-element-c43b10155375
// It's very easy - just write it down on pen and paper
// Do the dry run

class MajorityElement {
    public int majorityElement(int[] nums) {
        if(nums.length == 0){
            return -1;
        }
        int ans = nums[0], count = 0;
        
        for(int num : nums){
            if(count == 0){
                ans = num;
            }
            if(ans == num){
                count++;
            }else{
                count--;
            }
        }
        return ans;
    }
}

