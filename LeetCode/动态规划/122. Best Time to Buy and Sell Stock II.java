//分别找到波峰喝波谷，各个小利润相加；
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        if(prices.length == 0){
            return profit;
        }
        int peek = prices[0];
        int valley = prices[0];
        int i = 0;
        while(i < prices.length - 1){
            while(i < prices.length - 1 && prices[i] >= prices[i + 1]){
                i ++;
            }
            valley = prices[i];
            while(i < prices.length - 1 && prices[i] <= prices[i + 1]){
                i ++;
            }
            peek = prices[i];
            profit += peek - valley;
        }
        return profit;
    }
}

//有赚就立马抛售。
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 0; i < prices.length - 1; i ++){
            if(prices[i] < prices[i + 1]){
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }
}