//动态规划，对应leetcode 264 Ugly Number II;
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index < 1) {
            return 0;
        }
        if (index <= 6) {
            return index;
        }

        int[] dp = new int[index];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < index; i++) {
            int next2 = dp[i2] * 2;
            int next3 = dp[i3] * 3;
            int next5 = dp[i5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if (dp[i] == next2) {
                i2++;
            }
            if (dp[i] == next3) {
                i3++;
            }
            if (dp[i] == next5) {
                i5++;
            }
        }
        return dp[index - 1];
    }
}