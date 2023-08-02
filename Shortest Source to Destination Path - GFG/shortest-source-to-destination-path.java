//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        if(A[0][0] == 0 || A[X][Y] == 0) return -1;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0));
        int[] dirX = {1,-1,0,0};
        int[] dirY = {0,0,1,-1};
        int[][] dist = new int[N][M];
        for(int[] row : dist){
            Arrays.fill(row,500);
        }
        dist[0][0] = 0;
        while(!q.isEmpty()){
            Node curr = q.poll();
            int currX = curr.r;
            int currY = curr.c;
            for(int i = 0;i<4;++i){
                int nextX = currX + dirX[i];
                int nextY = currY + dirY[i];
                if(isValid(nextX,nextY,A) && dist[nextX][nextY] > dist[currX][currY] + 1){
                    dist[nextX][nextY] = dist[currX][currY] + 1;
                    q.offer(new Node(nextX,nextY));
                }
            }
        }
        return dist[X][Y] == 500 ? -1 : dist[X][Y];
    }
    boolean isValid(int r,int c,int[][] grid){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0){
            return false;
        }
        return true;
    }
};
class Node{
    int r;
    int c;
    Node(int r,int c){
        this.r = r;
        this.c = c;
    }
}