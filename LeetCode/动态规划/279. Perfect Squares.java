/**
 * 解法1：四平方数之和
 * https://www.cnblogs.com/grandyang/p/4800552.html
 */
class Solution {
    public int numSquares(int n) {
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 4;
        }
        for (int i = 0; i * i < n; i++) {
            int j = (int) Math.sqrt(n - i * i);
            if (i * i + j * j == n) {
                int a = i > 0 ? 1 : 0;
                int b = j > 0 ? 1: 0;
                return a + b;
            }
        }
        return 3;
    }
}

/**
 * 动态规划，
 * 我们建立一个长度为 n+1 的一维dp数组，
 * 将第一个值初始化为0，其余值都初始化为 INT_MAX, i从0循环到n，j从1循环到 i+j*j <= n 的位置，
 * 然后每次更新 dp[i+j*j] 的值，动态更新 dp 数组，其中 dp[i] 表示正整数i能少能由多个完全平方数组成，
 * 那么我们求n，就是返回 dp[n] 即可，也就是 dp 数组的最后一个数字。
 * 需要注意的是这里的写法，i必须从0开始，j必须从1开始，因为我们的初衷是想用 dp[i] 来更新 dp[i + j * j]
 */
import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        while (n % 4 == 0) {
            n /= 4;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
            }
        }
        return dp[n];
    }
}