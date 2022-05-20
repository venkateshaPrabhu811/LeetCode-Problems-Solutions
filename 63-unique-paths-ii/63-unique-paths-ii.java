class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[n-1][m-1] == 1) return 0;
        obstacleGrid[0][0] = 1;
        for(int i = 1;i<m;i++){
            if(obstacleGrid[0][i] == 0){
                obstacleGrid[0][i] = obstacleGrid[0][i-1];
            }
            else{
                obstacleGrid[0][i] = 0;
            }
        }
        for(int i = 1;i<n;i++){
            if(obstacleGrid[i][0] == 0){
                obstacleGrid[i][0] = obstacleGrid[i-1][0];
            }
            else{
                obstacleGrid[i][0] = 0;
            }
        }
        for(int i = 1;i<n;i++){
            for(int j = 1;j<m;j++){
                if(obstacleGrid[i][j] == 0){
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }
                else{
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[n-1][m-1];
    }
}