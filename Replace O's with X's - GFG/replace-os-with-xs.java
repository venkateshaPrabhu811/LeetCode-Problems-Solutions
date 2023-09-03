//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[] dirX = {-1,0,0,1};
    static int[] dirY = {0,-1,1,0};
    static char[][] fill(int n, int m, char a[][])
    {
        for(int i = 0;i<m;++i){
            if(a[0][i] == 'O'){
                dfs(0,i,a);
            }
            if(a[n-1][i] == 'O'){
                dfs(n-1,i,a);
            }
        }
        for(int i = 0;i<n;++i){
            if(a[i][0] == 'O'){
                dfs(i,0,a);
            }
            if(a[i][m-1] == 'O'){
                dfs(i,m-1,a);
            }
        }
        for(int i = 0;i<n;++i){
            for(int j = 0;j<m;++j){
                if(a[i][j] == '*'){
                    a[i][j] = 'O';
                }
                else{
                    a[i][j] = 'X';
                }
            }
        }
        return a;
    }
    static void dfs(int r,int c,char[][] grid){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 'O') return;
        grid[r][c] = '*';
        for(int i = 0;i<4;++i){
            int nextR = r + dirX[i];
            int nextC = c + dirY[i];
            dfs(nextR,nextC,grid);
        }
    }
}