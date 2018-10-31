//动态规划。对应leetcode 53
//定义一个数组，dp[]，dp[i]以第i个元素为结尾的一段最大子序和。
//求dp[i]时，假设前面dp[0]~dp[i-1]都已经求出来了，dp[i-1]表示的是以i-1为结尾的最大子序和，
//若dp[i-1]小于0，则dp[i]加上前面的任意长度的序列和都会小于不加前面的序列（即自己本身一个元素是以自己为结尾的最大自序和）。
//举个例子：如-2，1，-3，4数组，dp[0]=-2；dp[1]=1(因为前一个dp[0]=-2<0，即（-2，1）子序和为-1，一个元素（1）子序和为1）；
//dp[2]=dp[1]+nums[2]=1+(-3)=-2；dp[3]=4，因为dp[2]<0；
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length == 0){
            return 0;
        }
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int maxSum = dp[0];
        for(int i = 1; i < array.length; i ++){
            if(dp[i - 1] < 0){
                dp[i] = array[i];
            }else{
                dp[i] = dp[i - 1] + array[i];
            }
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}