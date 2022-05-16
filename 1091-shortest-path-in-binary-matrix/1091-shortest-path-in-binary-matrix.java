class Solution {
    int min = Integer.MAX_VALUE;
    boolean goal = false;
    public int shortestPathBinaryMatrix(int[][] grid) {
        /*int n = grid.length;
        bfs(0,0,1,n,grid);
        return goal ? min : -1;
    }
    private void bfs(int currX,int currY,int shortest,int n,int[][] grid){
        if(currX > n-1 || currX < 0 || currY < 0 || currY > n-1 || grid[currX][currY] == 1 || grid[currX][currY] == -1 || goal) 
            return;
        if(currX == n-1 && currY == n-1){
            goal = true;
            if(min > shortest){
                min = shortest;
                return;
            }
        }
        else{
            int backup = grid[currX][currY];
            grid[currX][currY] = -1;
            bfs(currX + 1,currY,shortest + 1,n,grid);
            bfs(currX -1,currY,shortest + 1,n,grid);
            bfs(currX + 1,currY + 1,shortest + 1,n,grid);
            bfs(currX - 1,currY - 1,shortest  + 1,n,grid);
            bfs(currX + 1,currY - 1,shortest  + 1,n,grid);
            bfs(currX - 1,currY + 1,shortest + 1,n,grid);
            bfs(currX,currY + 1,shortest + 1,n,grid);
            bfs(currX,currY - 1,shortest + 1,n,grid);
            grid[currX][currY] = backup;
        }
    }*/
        int n = grid.length;
        int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{1,-1},{1,1},{-1,1}};
        Queue<Pair> q = new LinkedList<>();
        int[][] visited = new int[n][n];
        q.add(new Pair(0,0));
        visited[0][0] = -1;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        if(n == 1) return grid[0][0] == 0 ? 1 : -1;
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                Pair temp = q.remove();
                int x = temp.x;
                int y = temp.y;
                if(x == n-1 && y == n-1) return res + 1;
                for(int j = 0;j<8;j++){
                    int currX = x + dir[j][0];
                    int currY = y + dir[j][1];
                    if(currX >= 0 && currX < n && currY >= 0 && currY < n && grid[currX][currY] == 0 && visited[currX][currY] != -1){
                        q.add(new Pair(currX,currY));
                        visited[currX][currY] = -1;
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}