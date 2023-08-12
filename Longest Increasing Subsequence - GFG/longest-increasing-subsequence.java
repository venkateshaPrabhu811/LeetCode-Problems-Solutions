//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int nums[])
    {
        int[] dp = new int[size];
        Arrays.fill(dp,Integer.MAX_VALUE);
        int ans = -1;
        for(int i = 0;i<size;++i){
            int index = findPos(dp,nums[i],i);
            dp[index] = nums[i];
            ans = Math.max(ans,index);
        }
        return ans+1;
    }
    static int findPos(int[] dp,int target,int high){
        int low = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(dp[mid] == target){
                return mid;
            }
            else if(dp[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return low;
    }
} 