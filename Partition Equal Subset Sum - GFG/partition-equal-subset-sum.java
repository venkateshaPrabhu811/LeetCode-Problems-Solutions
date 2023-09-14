//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        int sum = 0;
        for(int i = 0;i<N;++i){
            sum += arr[i];
        }
        if(sum % 2 != 0) return 0;
        sum /= 2;
        int[][] dp = new int[N+1][sum + 1];
        for(int i = 0;i<=N;++i){
            Arrays.fill(dp[i],-1);
        }
        return helper(arr,sum,N,0,dp);
    }
    public static int helper(int[] arr,int target,int n,int index,int[][] dp){
        if(target == 0 && index == n){
            return 1;
        }
        if(target < 0 || index >= n) return 0;
        if(dp[index][target] != -1) return dp[index][target];
        int pick = helper(arr,target-arr[index],n,index+1,dp);
        int nPick = helper(arr,target,n,index+1,dp);
        return dp[index][target] = pick + nPick > 0 ? 1 : 0;
    }
}