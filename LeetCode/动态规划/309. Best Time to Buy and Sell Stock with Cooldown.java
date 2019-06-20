/*
 * https://www.cnblogs.com/grandyang/p/4997417.html
 * 有点难，没太理解
 */
class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE, preBuy = 0, sell = 0, preSell = 0;
        for (int price : prices) {
            preBuy = buy;
            buy = Math.max(preSell - price, preBuy);
            preSell = sell;
            sell = Math.max(preBuy + price, preSell);
        }
        return sell;
    }
}