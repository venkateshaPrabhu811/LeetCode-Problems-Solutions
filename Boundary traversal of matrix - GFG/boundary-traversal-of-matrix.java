//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            s = in.readLine().trim().split(" ");
            int ind=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[ind++]);
                }
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.boundaryTraversal(a, n, m);
            for (int i : ans) {
                out.print(i + " ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return list of integers that form the boundary 
    //traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m)
    {
        ArrayList<Integer> res = new ArrayList<>();
        int rs = 0;
        int re = n-1;
        int cs = 0;
        int ce = m-1;
        for(int i = cs;i<=ce;++i){
            res.add(matrix[rs][i]);
        }
        ++rs;
        for(int i = rs;i<=re;++i){
            res.add(matrix[i][ce]);
        }
        --ce;
        if(rs <= re){
            for(int i = ce;i>=cs;--i){
                res.add(matrix[re][i]);
            }
            --re;
        }
        if(cs <= ce){
            for(int i = re;i>=rs;--i){
                res.add(matrix[i][cs]);
            }   
        }
        return res;
    }
}
