//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int[] dirX = {1,0,0,-1};
    int[] dirY = {0,-1,1,0};
    int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0;i<n;++i){
            if(grid[i][0] == 1) dfs(i,0,grid);
            if(grid[i][m-1] == 1) dfs(i,m-1,grid);
        }
        for(int i = 1;i<m-1;++i){
            if(grid[0][i] == 1) dfs(0,i,grid);
            if(grid[n-1][i] == 1) dfs(n-1,i,grid);
        }
        int count = 0;
        for(int i = 0;i<n;++i){
            for(int j = 0;j<m;++j){
                if(grid[i][j] == 1) ++count;
            }
        }
        return count;
    }
    void dfs(int r,int c,int[][] grid){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0){
            return;
        }
        grid[r][c] = 0;
        for(int i = 0;i<4;++i){
            int nr = dirX[i] + r;
            int nc = dirY[i] + c;
            dfs(nr,nc,grid);
        }
    }
}