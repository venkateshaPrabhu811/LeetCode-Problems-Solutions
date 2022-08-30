class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int col = 0;col<m;++col){
            int top = 0;
            int bottom = n-1;
            while(top < bottom){
                int temp = matrix[top][col];
                matrix[top][col] = matrix[bottom][col];
                matrix[bottom][col] = temp;
                ++top;
                --bottom;
            }
        }
        for(int row = 0;row < n;++row){
            for(int col = row+1;col<m;++col){
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }
}