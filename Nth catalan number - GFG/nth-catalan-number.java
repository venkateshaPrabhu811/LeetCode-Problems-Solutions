//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.findCatalan(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findCatalan(int n) {
        int mod = 1000000007;
        long[] arr = new long[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2;i<=n;++i){
            int left = 0;
            int right = i-1;
            long sum = 0;
            while(left <= right){
                if(left == right){
                    sum += (arr[left] * arr[right]) % mod;
                    break;
                }
                sum += 2 * (arr[left] * arr[right]) % mod;
                ++left;
                --right;
            }
            arr[i] = sum % mod;
        }
        return (int)arr[n];
        
    }
}
        
