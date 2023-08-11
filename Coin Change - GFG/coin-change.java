//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        long[][] dp = new long[N][sum+1];
        for(long[] row : dp){
            Arrays.fill(row,-1);
        }
        return helper(coins,N-1,sum,dp);
    }
    public long helper(int[] coins,int curr,int sum,long[][] dp){
        if(sum == 0){
            return 1;
        }
        if(sum < 0 || curr < 0){
            return 0;
        }
        if(dp[curr][sum] != -1){
            return dp[curr][sum];
        }
        long take = 0,notTake = 0;
        if(sum >= coins[curr]){
            take = helper(coins,curr,sum - coins[curr],dp);
        }
        notTake = helper(coins,curr-1,sum,dp);
        
        return dp[curr][sum] = take + notTake;
    }
}