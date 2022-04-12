class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] res = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                res[i][j] = board[i][j];
            }
        }
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                int count = 0;
                if(checkAdj(res,i,j+1)) count++;
                if(checkAdj(res,i,j-1)) count++;
                if(checkAdj(res,i-1,j)) count++;
                if(checkAdj(res,i+1,j)) count++;
                if(checkAdj(res,i+1,j+1)) count++;
                if(checkAdj(res,i+1,j-1)) count++;
                if(checkAdj(res,i-1,j+1)) count++;
                if(checkAdj(res,i-1,j-1)) count++;
                if(res[i][j] == 1){
                    if(count < 2 || count > 3){
                        board[i][j] = 0;
                    }
                }
                else{
                    if(count == 3) board[i][j] = 1;
                }
            }
        }
    }
    public static boolean checkAdj(int[][] board,int x,int y){
        if(x > -1 && x < board.length && y > -1 && y < board[0].length && board[x][y] == 1) return true;
        return false;
    }
}