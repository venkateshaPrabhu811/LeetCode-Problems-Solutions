//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static int nthFibonacci(int n){
        if(n == 1) return 0;
        if(n == 2) return 1;
        int mod = 1000000007;
        long prev1 = 1;
        long prev2 = 0;
        long curr = 0;
        for(int i = 2;i<=n;++i){
            curr = prev1 + prev2;
            curr = curr % mod;
            prev2 = prev1;
            prev1 = curr;
        }
        return (int)(curr % mod);
        
        
    }
}