class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rs = 0;
        int cs = 0;
        int re = matrix.length-1;
        int ce = matrix[0].length-1;
        List<Integer> res = new ArrayList<>();
        while(rs <= re && cs <= ce){
            for(int i = cs;i<=ce;i++){
                res.add(matrix[rs][i]);
            }
            for(int i = rs+1;i<=re;i++){
                res.add(matrix[i][ce]);
            }
            if(rs < re && cs < ce){
                for(int i = ce-1;i>cs;i--){
                    res.add(matrix[re][i]);
                }
                for(int i = re;i>rs;i--){
                    res.add(matrix[i][cs]);
                }
            }
            cs++;
            re--;
            ce--;
            rs++;
        }
        return res;
    }
}