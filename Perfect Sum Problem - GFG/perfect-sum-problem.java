//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    int mod = 1000000007;
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    int[][] dp = new int[n+1][sum+1];
	    long total = 0;
	    for(int i = 0;i<n;++i){
	        total += arr[i];
	        Arrays.fill(dp[i],-1);
	    }
	    if(total < sum) return 0;
	    return helper(arr,n,sum,0,dp);
	}
	public int helper(int[] arr,int n,int target,int index,int[][] dp){
	    if(target == 0 && index == n) return 1;
	    if(target < 0 || index >= n) return 0;
	    if(dp[index][target] != -1) return dp[index][target];
	    int pick = helper(arr,n,target-arr[index],index+1,dp);
	    int nPick = helper(arr,n,target,index+1,dp);
	    return dp[index][target] = (pick % mod + nPick % mod) % mod;
	}
}