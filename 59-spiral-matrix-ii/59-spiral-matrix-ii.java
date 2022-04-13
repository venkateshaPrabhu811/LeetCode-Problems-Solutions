class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int rs = 0;
        int cs= 0;
        int re = n-1;
        int ce = n-1;
        int num = 1;
        while(rs <= re && cs <= ce){
            for(int i = cs;i<=ce;i++){
                mat[rs][i] = num++;
            }
            rs++;
            for(int i = rs;i<=re;i++){
                mat[i][ce] = num++;
            }
            ce--;
            for(int i = ce;i>=cs;i--){
                mat[re][i] = num++;
            }
            re--;
            for(int i = re;i>=rs;i--){
                mat[i][cs] = num++;
            }
            cs++;
        }
        return mat;
    }
}