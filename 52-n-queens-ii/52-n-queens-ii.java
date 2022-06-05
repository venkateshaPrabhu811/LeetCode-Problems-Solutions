class Solution {
    int count = 0;
    boolean[] colcheck;
    char[][] grid;
    public int totalNQueens(int n) {
        colcheck = new boolean[n];
        grid = new char[n][n];
        helper(0,n);
        return count;
    }
    private void helper(int row,int n){
        if(row == n){
            ++count;
            return;
        }
        for(int col = 0;col < n;++col){
            if(!colcheck[col] && isSafe(row,col,n)){
                grid[row][col] = 'Q';
                colcheck[col] = true;
                helper(row+1,n);
                grid[row][col] = '.';
                colcheck[col] = false;
            }
        }
        
    }
    private boolean isSafe(int row,int col,int n){
        for(int r = row-1,c=col-1;r>=0 && c>=0;--r,--c){
            if(grid[r][c] == 'Q') return false;
        }
        for(int r = row-1,c=col+1;r>=0 && c<n;--r,++c){
            if(grid[r][c] == 'Q') return false;
        }
        return true;
    }
}