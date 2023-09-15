//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG implements Runnable {
    public void run() {
        try {
            BufferedReader in;
            PrintWriter out;
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine());

            while (t-- > 0) {
                int n = Integer.parseInt(in.readLine().trim());

                Solution g = new Solution();
                out.println(g.countWays(n));
            }
            out.close();
        } catch (Exception e) {
            ;
        }
    }

    public static void main(String args[]) throws IOException {
        new Thread(null, new GFG(), "whatever", 1 << 26).start();
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to count the number of ways in which frog can reach the top.
    static int mod = 1000000007;
    static long countWays(int n)
    {
        if(n == 0 || n == 1) return 1;
        long prev1 = 1;
        long prev2 = 1;
        long prev3 = 2;
        long ans = 0;
        for(int i = 3;i<=n;++i){
            ans = (prev1 + prev2 + prev3) % mod;
            prev1 = prev2;
            prev2 = prev3;
            prev3 = ans;
        }
        return prev3;
    }
    
}

