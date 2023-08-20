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
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int  Count(int[][] matrix)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        int r = 0;
        int total = 0;
        while(r < n){
            int c = 0;
            while(c < m){
                if(matrix[r][c] != 1){
                    ++c;
                    continue;
                }
                int count = 0;
                if(r-1 >= 0 && matrix[r-1][c] == 0)
                    ++count;
                if(r+1 < n && matrix[r+1][c] == 0)
                    ++count;
                if(c-1 >= 0 && matrix[r][c-1] == 0)
                    ++count;
                if(c+1 < m && matrix[r][c+1] == 0)
                    ++count;
                if(c+1 < m && r-1 >= 0 && matrix[r-1][c+1] == 0)
                    ++count;
                if(c-1 >= 0 && r-1 >= 0 && matrix[r-1][c-1] == 0)
                    ++count;
                if(c+1 < m && r+1 < n && matrix[r+1][c+1] == 0)
                    ++count;
                if(c-1 >= 0 && r+1 < n && matrix[r+1][c-1] == 0)
                    ++count;
                if(count != 0 && count % 2 == 0) ++total;
                
                ++c;
            }
            ++r;
        }
        return total;
    }
}