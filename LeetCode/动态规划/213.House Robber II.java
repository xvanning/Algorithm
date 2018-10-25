class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(robValue(nums, 0, nums.length - 2),robValue(nums, 1, nums.length - 1));
    }
    public int robValue(int[] nums, int first, int last){
        int[] dp = new int[nums.length];
        dp[first] = nums[first]; dp[first + 1] = Math.max(nums[first],nums[first + 1]);
        for (int i = first + 2; i < last + 1; i ++){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[last];
    }
}