// dp[i]为当前剩余步数
class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1]) - 1;
            if (dp[i] < 0) {
                return false;
            }
        }
        return dp[n - 1] >= 0;
    }
}