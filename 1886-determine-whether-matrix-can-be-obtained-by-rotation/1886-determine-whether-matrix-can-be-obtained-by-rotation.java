class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i = 0;i<4;++i){
            if(Arrays.deepEquals(mat,target)) return true;
            rotate(mat);
        }
        return false;
    }
    private void rotate(int[][] mat){
        int i = 0;
        int j = mat.length-1;
        while(i < j){
            int[] temp = mat[i];
            mat[i] = mat[j];
            mat[j] = temp;
            ++i;
            --j;
        }
        int n = mat.length;
        for(int row = 0;row < n;++row){
            for(int col = row+1;col < n;++col){
                int temp = mat[row][col];
                mat[row][col] = mat[col][row];
                mat[col][row] = temp;
            }
        }
    }
}