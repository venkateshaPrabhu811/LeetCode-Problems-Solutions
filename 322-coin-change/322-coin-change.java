class Solution {
    public int coinChange(int[] coins, int amount) {
        /*Intuitive Approach
        Arrays.sort(coins);
        int i = coins.length-1;
        int count = 0;
        while(amount > 0 && i >= 0){
            count += amount / coins[i];
            amount %= coins[i];
            i--;
        }
        return (amount > 0) ? -1 : count;*/
        
        //DP approach 
        int[] dp = new int[amount+1];
        dp[0] = 0;
        Arrays.sort(coins);
        for(int i = 1;i<=amount;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int c : coins){
                if(i - c < 0) break;
                if(dp[i - c] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],1+dp[i-c]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}