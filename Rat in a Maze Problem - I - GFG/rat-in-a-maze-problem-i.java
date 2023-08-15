//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    static int[] dirX = {1,0,0,-1};
    static int[] dirY = {0,-1,1,0};
    static char[] ch = {'D','L','R','U'};
    public static ArrayList<String> findPath(int[][] m, int n) {
        boolean[][] visited = new boolean[n][n];
        ArrayList<String> res = new ArrayList<>();
        if(m[0][0] == 1 && m[n-1][n-1] == 1){
            helper(0,0,new StringBuilder(),visited,m,n,res);   
        }
        return res;
        
    }
    public static void helper(int r,int c,StringBuilder sb,boolean[][] visited,int[][] m,int n,ArrayList<String> res){
        if(r == n-1 && c == n-1){
            res.add(sb.toString());
            return;
        }
        for(int i = 0;i<4;++i){
            int nR = r + dirX[i];
            int nC = c + dirY[i];
            if(nR >= 0 && nR < n && nC >= 0 && nC < n && !visited[nR][nC] && m[nR][nC] == 1){
                visited[r][c] = true;
                sb.append(ch[i]);
                helper(nR,nC,sb,visited,m,n,res);
                visited[r][c] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}