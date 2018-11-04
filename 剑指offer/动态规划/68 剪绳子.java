//leetcode 343  Integer Break https://leetcode.com/problems/integer-break/description/
class Solution {
    public int integerBreak(int n) {
        //dp[i]表示的是讲数字i分割（至少分割为两部分）后得到的最大乘积；
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i <= n; i ++){
            //求解dp[i]
            for(int j = 1; j <= i - 1; j ++){
                //分割成j + (i - j)，与j * dp[i - j]（i-j继续分割）比较，最后还要与前面算出来过的dp[i]比较
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}