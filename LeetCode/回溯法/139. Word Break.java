import java.util.List;
/**
 * 其中dp[i]表示范围[0, i)内的子串是否可以拆分，
 * 注意这里dp数组的长度比s串的长度大1，是因为我们要handle空串的情况，
 * 我们初始化dp[0]为true，然后开始遍历。注意这里我们需要两个for循环来遍历，
 * 因为此时已经没有递归函数了，所以我们必须要遍历所有的子串，
 * 我们用j把[0, i)范围内的子串分为了两部分，[0, j) 和 [j, i)，
 * 其中范围 [0, j) 就是dp[j]，范围 [j, i) 就是s.substring(j, i)，其中dp[j]是之前的状态，
 * 我们已经算出来了，可以直接取，只需要在字典中查找s.substr(j, i-j)是否存在了，
 * 如果二者均为true，将dp[i]赋为true，并且break掉，此时就不需要再用j去分[0, i)范围了，
 * 因为[0, i)范围已经可以拆分了。最终我们返回dp数组的最后一个值，就是整个数组是否可以拆分的布尔值了
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict.isEmpty()) {
            return false;
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (dp[j] && wordDict.contains(sub)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}