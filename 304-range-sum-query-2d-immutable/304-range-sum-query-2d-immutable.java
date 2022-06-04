class NumMatrix {
    int[][] mat;
    public NumMatrix(int[][] matrix) {
        //mat = matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        mat = new int[m+1][n+1];
        for(int r = 1;r<=m;++r){
            for(int c = 1;c<=n;++c){
                mat[r][c] = matrix[r-1][c-1] + mat[r-1][c] + mat[r][c-1] - mat[r-1][c-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        /*int sum = 0;
        for(int r = row1;r<=row2;++r){
            for(int c = col1;c<=col2;++c){
                sum += mat[r][c];
            }
        }*/
        
        return mat[row2+1][col2+1] - mat[row1][col2 + 1] - mat[row2 + 1][col1] + mat[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */