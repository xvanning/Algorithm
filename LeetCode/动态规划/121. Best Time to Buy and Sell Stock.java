//暴力解法；
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int profit = 0;
        for(int i = 0; i < prices.length - 1; i ++){
            int buy = prices[i];
            for(int j = i + 1; j < prices.length; j ++){
                int sell = prices[j];
                int curProfit = sell - buy;
                profit = Math.max(profit,curProfit);
            }
        }
        return profit;
    }
}

//最优解：找到最小值。每次利润都为当前值减去最小值。
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i ++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            maxProfit = Math.max(prices[i] - minPrice,maxProfit);
        }
        return maxProfit;
    }
}