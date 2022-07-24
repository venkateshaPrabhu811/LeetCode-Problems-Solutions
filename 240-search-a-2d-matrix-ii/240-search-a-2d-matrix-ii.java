class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*int r = 0;
        int c = matrix[0].length-1;
        while(r < matrix.length && c >= 0){
            if(matrix[r][c] == target) return true;
            else if(matrix[r][c] > target) c--;
            else r++;
        }
        return false;
        */
        
        //Binary Search
        int m = matrix.length;
        int n = matrix[0].length;
        for(int[] row : matrix){
            if(row[0] <= target && target <= row[n-1]){
                
                int left = 0;
                int right = n-1;
                
                while(left <= right){
                    int mid = left + (right - left)/2;
                    
                    int val = row[mid];
                    if(val == target) return true;
                    else if(val < target) left = mid+1;
                    else right = mid-1;
                    
                }
            }
        }
        return false;
    }
}