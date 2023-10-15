//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[][] grid = IntMatrix.input(br, n, n);
            
            Solution obj = new Solution();
            int res = obj.largestIsland(n, grid);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution{
    int n;
    int[] dp;
    boolean[][] visited;
    int[] dirX = {-1,0,0,1};
    int[] dirY = {0,-1,1,0};
    int key = 2;
    public int largestIsland(int N,int[][] grid) 
    {
        n = grid.length;
        dp = new int[(n*n) + 10];
        visited = new boolean[n][n];
        boolean flag = false;
        for(int i = 0;i<n;++i){
            for(int j = 0;j<n;++j){
                if(grid[i][j] == 0){
                    flag = true;
                    continue;
                }
                if(!visited[i][j] && grid[i][j] == 1){
                    int res = dfs(i,j,grid);
                    dp[key++] = res;
                }
            }
        }
        if(!flag) return n * n;
        int max = -1;
        for(int i = 0;i<n;++i){
            for(int j = 0;j < n;++j){
                if(grid[i][j] == 0){
                    HashSet<Integer> hs = new HashSet<>();
                    int res = 1;
                    hs.add(i > 0 ? grid[i-1][j] : 0);
                    hs.add(j > 0 ? grid[i][j-1] : 0);
                    hs.add(i < n-1 ? grid[i+1][j] : 0);
                    hs.add(j < n-1 ? grid[i][j+1] : 0);
                    for(int num : hs){
                        res += dp[num];
                    }
                    max = Math.max(res,max);
                }
            }
        }
        return max;
    }
    public int dfs(int r,int c,int[][] grid){
        if(r < 0 || r >= n || c < 0 || c >= n || visited[r][c] || grid[r][c] == 0) return 0;
        int ans = 1;
        visited[r][c] = true;
        for(int i = 0;i<4;++i){
            int nr = r + dirX[i];
            int nc = c + dirY[i];
            ans += dfs(nr,nc,grid);
        }
        grid[r][c] = key;
        return ans;
    }
}
