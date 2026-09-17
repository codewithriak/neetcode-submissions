class Solution {
    public int maxProfit(int[] prices) {
     int  minPrice = prices[0], maxProfit = 0;   
     for(int i = 0 ; i < prices.length ; i++){
        int potentialProfit = prices[i] - minPrice;
        maxProfit = Math.max(maxProfit, potentialProfit);
        minPrice = Math.min(minPrice, prices[i]);
     }
     return maxProfit;
    }
}