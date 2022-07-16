class Solution {
    int mod = 1000000007;
    //int[][][] dp;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        /*Brute Force
        if(startRow < 0 || startColumn < 0 || startRow >= m || startColumn >= n) return 1;
        if(maxMove == 0) return 0;
        
        int a = findPaths(m,n,maxMove-1,startRow + 1,startColumn);
        int b = findPaths(m,n,maxMove-1,startRow - 1,startColumn);
        int c = findPaths(m,n,maxMove-1,startRow,startColumn + 1);
        int d = findPaths(m,n,maxMove-1,startRow,startColumn - 1);
        return (a + b + c + d) % mod; */
        
        //Dp
        /*dp = new int[m][n][maxMove+1];
        for(int i = 0;i<m;++i){
            for(int j = 0;j<n;++j){
                for(int k = 0;k<=maxMove;++k){
                    dp[i][j][k] = -1;
                }
            }
        }
        return helper(m,n,maxMove,startRow,startColumn) % mod;*/
        
        if(maxMove <= 0) return 0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        
        int result = 0;
        int[][] count = new int[m][n];
        count[startRow][startColumn] = 1;
        
        for(int step = 0;step < maxMove;++step){
            int[][] temp = new int[m][n];
            for(int r = 0;r<m;++r){
                for(int c = 0;c<n;++c){
                    for(int[] d : dir){
                        int nr = r + d[0];
                        int nc = c + d[1];
                        if(nr < 0 || nc < 0 || nr >= m || nc >= n){
                            result = (result + count[r][c]) % mod;
                        }
                        else{
                            temp[nr][nc] = (temp[nr][nc] + count[r][c]) % mod;
                        }
                    }
                }
            }
            count = temp;
        }
        return result % mod;
    }
    /*private int helper(int m, int n, int move, int r, int c) {
        if (r < 0 || c < 0 || r >= m || c >= n)
            return 1;
        if (move <= 0)
            return 0;
        if (dp[r][c][move] != -1)
            return dp[r][c][move] % mod;
        dp[r][c][move] = ((helper(m, n, move - 1, r + 1, c) % mod + helper(m, n, move - 1, r - 1, c) % mod) % mod + (helper(m, n, move - 1, r, c + 1) % mod + helper(m, n, move - 1, r, c - 1) % mod) % mod ) % mod;
        return dp[r][c][move] % mod;
    }*/
}