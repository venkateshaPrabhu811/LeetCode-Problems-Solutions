class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length;
        int col = mat[0].length;
        if(row * col != r*c){
            return mat;
        }
        row = 0;
        col = 0;
        int[][] newMat = new int[r][c];
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                if(col == mat[0].length){
                    col = 0;
                    row++;
                }
                newMat[i][j] = mat[row][col];
                col++;
            }
        }
        return newMat;
    }
}