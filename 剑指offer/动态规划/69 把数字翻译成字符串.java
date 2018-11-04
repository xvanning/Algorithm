//leetcode 91 Decode Ways https://leetcode.com/problems/decode-ways/description/

//动态规划，找方程式。
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        //dp[i] 表示的有i个字符的字符串的解码个数。 所以空字符dp[0]只有一种解码方式。 dp[1]有0或1种解码方式。
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i < n + 1; i ++){
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if(first >= 1 && first <= 9){
                dp[i] += dp[i - 1];
            }
            if(second >= 10 && second <= 26){
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}