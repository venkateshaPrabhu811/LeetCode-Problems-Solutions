class Solution {
    /*Brute Force DFS
    int resPath = 0;
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int n1 = matrix.length;
        int n2 = matrix[0].length;
        for(int r = 0;r<n1;r++){
            for(int c = 0;c<n2;c++){
                resPath = Math.max(resPath,dfs(matrix,r,c,n1,n2));
            }
        }
        return resPath;
    }
    private int dfs(int[][] matrix,int r,int c,int n1,int n2){
        int pathLen = 1;
        for(int i = 0;i<4;i++){
            int x = r + dir[i][0];
            int y = c + dir[i][1];
            if(x < 0 || y < 0 || x > n1 - 1 || y > n2 -1 || matrix[x][y] <= matrix[r][c])
                continue;
            pathLen = Math.max(pathLen,1 + dfs(matrix,x,y,n1,n2));
        }
        return pathLen;
    }*/
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    int resPath = 0;
    public int longestIncreasingPath(int[][] matrix){
        //DP approach along with dfs
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int r = 0;r<matrix.length;r++){
            for(int c = 0;c < matrix[0].length;c++){
                resPath = Math.max(resPath,dfs(dp,matrix,r,c));
            }
        }
        return resPath;
    }
    private int dfs(int[][] dp,int[][] matrix,int r,int c){
        if(dp[r][c] != 0) return dp[r][c];
        dp[r][c] = 1;
        for(int i = 0;i<4;i++){
            int x = r + dir[i][0];
            int y = c + dir[i][1];
            if(x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length || matrix[x][y] <= matrix[r][c])
                continue;
            dp[r][c] = Math.max(dp[r][c],1 + dfs(dp,matrix,x,y));
        }
        return dp[r][c];
    }
}