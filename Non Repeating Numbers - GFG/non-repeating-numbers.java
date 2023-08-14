//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        int xor = 0;
        int n = nums.length;
        for(int i = 0;i<n;++i){
            xor = xor ^ nums[i];
        }
        int mask = (xor & (xor - 1)) ^ xor;
        int first = 0;
        int second = 0;
        for(int i = 0;i<n;++i){
            if((nums[i] & mask) > 0){
                first = first ^ nums[i];
            }
            else{
                second = second ^ nums[i];
            }
        }
        int[] res = new int[2];
        res[0] = first;
        res[1] = second;
        Arrays.sort(res);
        return res;
    }
}