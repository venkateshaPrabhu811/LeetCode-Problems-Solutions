class Solution {
    public int uniquePaths(int m, int n) {
        //recurcsive + dp
        int[][] dp = new int[m][n];
        for(int[] temp : dp){
            Arrays.fill(temp,-1);
        }
        return helper(dp,0,0,m,n);
    }
    /*DFS TLE
    private int helper(int row,int col,int m,int n){
        if(row == m-1 && col == n-1) return 1;
        if(row < 0 || row >= m || col < 0 || col >= n) return 0;
        
        return helper(row + 1,col,m,n) + helper(row,col+1,m,n);
    }*/
    private int helper(int[][] dp,int row,int col,int m,int n){
        if(row == m-1 && col == n-1) return 1;
        if(row < 0 || row >= m || col < 0 || col >= n) return 0;
        if(dp[row][col] != -1) return dp[row][col];
        dp[row][col] = helper(dp,row + 1,col,m,n) + helper(dp,row,col+1,m,n);
        return dp[row][col];
    }
}