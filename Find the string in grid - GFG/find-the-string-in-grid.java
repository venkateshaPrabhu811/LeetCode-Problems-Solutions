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
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    List<int[]> res = new ArrayList<>();
    public int[][] searchWord(char[][] grid, String word)
    {
        for(int i = 0;i<grid.length;++i){
            for(int j = 0;j<grid[i].length;++j){
                if(grid[i][j] == word.charAt(0))
                    helper(grid,i,j,word);
            }
        }
        return res.toArray(new int[0][0]);
    }
    public void helper(char[][] grid,int r,int c,String word){
        int ptr = 0;
        int len = word.length();
        // Down
        for(int i = r;i<grid.length && ptr < len;++i){
            if(grid[i][c] == word.charAt(ptr)){
                ++ptr;
            }
            else{
                break;
            }
        }
        if(ptr == len){
            res.add(new int[]{r,c});
            return;
        }
        // Up
        ptr = 0;
        for(int i = r;i>=0 && ptr < len;--i){
            if(grid[i][c] == word.charAt(ptr)){
                ++ptr;
            }
            else{
                break;
            }
        }
        if(ptr == len){
            res.add(new int[]{r,c});
            return;
        }
        
        // Left
        ptr = 0;
        for(int i = c;i>=0 && ptr < len;--i){
            if(grid[r][i] == word.charAt(ptr)){
                ++ptr;
            }
            else{
                break;
            }
        }
        if(ptr == len){
            res.add(new int[]{r,c});
            return;
        }
        // Right
        ptr = 0;
        for(int i = c;i<grid[0].length && ptr < len;++i){
            if(grid[r][i] == word.charAt(ptr)){
                ++ptr;
            }
            else{
                break;
            }
        }
        if(ptr == len){
            res.add(new int[]{r,c});
            return;
        }
        
        // Upper Left Diagonal
        ptr = 0;
        for(int i = r,j = c;i >= 0 && j >= 0 && ptr < len;--i,--j){
            if(grid[i][j] == word.charAt(ptr)){
                ++ptr;
            }
            else{
                break;
            }
        }
        if(ptr == len){
            res.add(new int[]{r,c});
            return;
        }
        // Lower Left Diagonal
        ptr = 0;
        for(int i = r,j = c;i < grid.length && j >= 0 && ptr < len;++i,--j){
            if(grid[i][j] == word.charAt(ptr)){
                ++ptr;
            }
            else{
                break;
            }
        }
        if(ptr == len){
            res.add(new int[]{r,c});
            return;
        }
        // Upper Right Diagonal
        ptr = 0;
        for(int i = r,j = c;i >= 0 && j < grid[0].length && ptr < len;--i,++j){
            if(grid[i][j] == word.charAt(ptr)){
                ++ptr;
            }
            else{
                break;
            }
        }
        if(ptr == len){
            res.add(new int[]{r,c});
            return;
        }
        // Lower Right Diagonal
        ptr = 0;
        for(int i = r,j = c;i < grid.length && j < grid[0].length && ptr < len;++i,++j){
            if(grid[i][j] == word.charAt(ptr)){
                ++ptr;
            }
            else{
                break;
            }
        }
        if(ptr == len){
            res.add(new int[]{r,c});
            return;
        }
    }
}