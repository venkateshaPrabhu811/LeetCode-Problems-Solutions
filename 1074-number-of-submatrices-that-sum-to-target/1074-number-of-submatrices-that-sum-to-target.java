class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int res = 0;
        int r = matrix.length;
        int c = matrix[0].length;
        
        for(int i = 0;i<r;++i){
            for(int j = 1;j<c;++j){
                matrix[i][j] += matrix[i][j-1];
            }
        }
        
        HashMap<Integer,Integer> freq = new HashMap<>();
        
        for(int col1 = 0;col1 < c;++col1){
            for(int col2 = col1;col2 < c;++col2){
                freq.clear();
                freq.put(0,1);
                int currSum = 0;
                for(int row = 0;row < r;++row){
                    currSum += matrix[row][col2] - (col1 > 0 ? matrix[row][col1-1] : 0);
                    res += freq.getOrDefault(currSum - target,0);
                    freq.put(currSum,freq.getOrDefault(currSum,0) + 1);
                }
            }
        }
        return res;
    }
}