class Solution {
    boolean[] rowcheck;
    boolean[] colcheck;
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        char[][] grid = new char[n][n];//chess board
        for(char[] row : grid){
            Arrays.fill(row,'.');//filling with '.' initially
        }
        rowcheck = new boolean[n];//check for row crash
        colcheck = new boolean[n];//check for col crash
        res = new ArrayList<>();
        helper(0,grid,n);
        return res;
    }
    private void helper(int row,char[][] grid,int n){
        if(row == n){
            List<String> temp = strBuild(grid);
            res.add(temp);
            return;
        }
        for(int col = 0;col < n;++col){
            if(row >= 0 && row < n && !rowcheck[row] && !colcheck[col] && isSafe(row,col,grid)){
                grid[row][col] = 'Q';
                rowcheck[row] = true;
                colcheck[col] = true;
                helper(row+1,grid,n);
                grid[row][col] = '.';
                rowcheck[row] = false;
                colcheck[col] = false;
            }
        }
    }
    private boolean isSafe(int row,int col,char[][] grid){
        int n = grid.length;
        //checking diagonals
        for(int r = row-1,c=col-1;r >= 0 && c >= 0;--r,--c){
            if(grid[r][c] == 'Q') return false;
        }
        for(int r = row-1,c=col+1;r >= 0 && c < n;--r,++c){
            if(grid[r][c] == 'Q') return false;
        }
        return true;
    }
    private List<String> strBuild(char[][] grid){
        List<String> temp = new ArrayList<>();
        for(int i = 0;i<grid.length;++i){
            temp.add(new String(grid[i]));
        }
        return temp;
    }
}