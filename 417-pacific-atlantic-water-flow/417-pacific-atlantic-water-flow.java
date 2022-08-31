class Solution {
    boolean[][] pacific,atlantic;
    List<List<Integer>> res;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        res = new LinkedList<>();
        int n = heights.length;
        int m = heights[0].length;
        pacific = new boolean[n][m];
        atlantic = new boolean[n][m];
        for(int i = 0;i<n;++i){
            dfs(i,0,heights,Integer.MIN_VALUE,pacific,n,m);
            dfs(i,m-1,heights,Integer.MIN_VALUE,atlantic,n,m);
        }
        for(int i = 0;i<m;++i){
            dfs(0,i,heights,Integer.MIN_VALUE,pacific,n,m);
            dfs(n-1,i,heights,Integer.MIN_VALUE,atlantic,n,m);
        }
        for(int i = 0;i<n;++i){
            for(int j = 0;j<m;++j){
                if(pacific[i][j] && atlantic[i][j])
                    res.add(new LinkedList<Integer>(Arrays.asList(i,j)));
            }
        }
        return res;
    }
    private void dfs(int r,int c,int[][] heights,int prev,boolean[][] visited,int n,int m){
        if(r < 0 || r >= n || c < 0 || c >= m || visited[r][c] || prev > heights[r][c])
              return;
        visited[r][c] = true;
        dfs(r+1,c,heights,heights[r][c],visited,n,m);
        dfs(r-1,c,heights,heights[r][c],visited,n,m);
        dfs(r,c+1,heights,heights[r][c],visited,n,m);
        dfs(r,c-1,heights,heights[r][c],visited,n,m);
    }
}