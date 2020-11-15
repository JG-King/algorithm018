class Solution {
    /**
     * 买卖股票的最佳时机 II
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i - 1]){
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}