class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        /*Top Down Approach using O(1) space
        for(int row = 1;row<triangle.size();++row){
            int size = triangle.get(row).size();
            for(int col = 0;col<size;++col){
                if(col == 0){
                    int prev = triangle.get(row-1).get(col);
                    int curr = triangle.get(row).get(col);
                    triangle.get(row).set(col,prev + curr);
                }
                else if(col == size-1){
                    int prev = triangle.get(row-1).get(col-1);
                    int curr = triangle.get(row).get(col);
                    triangle.get(row).set(col,prev + curr);
                }
                else{
                    int left = triangle.get(row-1).get(col-1);
                    int right = triangle.get(row-1).get(col);
                    int curr = triangle.get(row).get(col);
                    triangle.get(row).set(col,Math.min(curr+left,curr+right));
                }
            }
        }
        int minSum = Integer.MAX_VALUE;
        int size = triangle.size();
        for(int col = 0;col < triangle.get(size-1).size();++col){
            minSum = Math.min(minSum,triangle.get(size-1).get(col));
        }
        return minSum;*/
        //Bottom Up approach Using O(n) space
        int[] A = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
            }
        }
        return A[0];
    }
}