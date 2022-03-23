class Solution {
    public int maxProfit(int[] prices) {
        int currentPrice = 10001;
        int profit = 0;
        for(int  i = 0;i<prices.length;i++){
            if(prices[i] < currentPrice){
                currentPrice = Math.min(currentPrice,prices[i]);
            }
            else{
                profit = Math.max(profit,prices[i] - currentPrice);
            }
        }
        return profit;
    }
}