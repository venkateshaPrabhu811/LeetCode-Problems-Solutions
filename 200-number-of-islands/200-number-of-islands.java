class Solution {
    int count = 0;
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0;i<n;++i){
            for(int j = 0;j<m;++j){
                if(grid[i][j] == '1'){
                    ++count;
                    dfs(i,j,grid,n,m);
                }
            }
        }
        return count;
    }
    private void dfs(int r,int c,char[][] grid,int n,int m){
        if(r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == '0') return;
        grid[r][c] = '0';
        dfs(r,c-1,grid,n,m);
        dfs(r,c+1,grid,n,m);
        dfs(r+1,c,grid,n,m);
        dfs(r-1,c,grid,n,m);
    }
}