import java.util.AbstractMap;
import java.util.ArrayList;

//https://www.lintcode.com/problem/dices-sum/

public class Solution {
    /**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */

     /** 在当前循环中的骰子总和 n 出现次数，等于上一轮循环中骰子点数为 n-1 n-2 n-3 n-4 n-5 n-6的次数的总和
      * 因为新加入一个骰子，可以出现六种结果。
      * 所以我们使用动态规划，来进行累加；
      */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        int face = 6;
        int pointNum = face * n;

        //dp[i][j]表示的是前i个骰子，数值总和为j。出现的次数。
        double[][] dp = new double[n + 1][pointNum + 1];

        for(int j = 1; j <= face; j ++){
            dp[1][j] = 1;
        }

        for(int i = 2; i <= n ; i ++){
            /** i个骰子的最小点数为 i */
            for(int j = i; j <= pointNum; j ++){
                for(int k = 1; k <= face; k ++){
                    if(j > k){ //当前点数一定要大于上一轮循环的点数。
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }
        }

        double totalNum = Math.pow(face, n);
        List<Map.Entry<Integer, Double>> list = new ArrayList<>();
        for(int i = n; i <= pointNum; i ++){
            list.add(new AbstractMap.SimpleEntry<>(i,dp[n][i] / totalNum));
        }
        return list;
    }
}