class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int col = m*n-1;
        int row = 0;
        while(row <= col){
            int mid = row + (col - row)/2;
            int value = matrix[mid/m][mid%m];
            if(value == target){
                return true;
            }
            else if(value < target){
                row = mid + 1;
            }
            else{
                col = mid - 1;
            }
        }
        return false;
    }
}