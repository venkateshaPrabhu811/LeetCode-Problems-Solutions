//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] colors = new int[n];
        return helper(0,n,m,colors,graph);
    }
    public boolean helper(int currNode,int n,int m,int[] colors,boolean[][] graph){
        if(currNode == n){
            return true;
        }
        for(int i = 1;i<=m;++i){
            if(isSafe(colors,i,graph,currNode)){
                colors[currNode] = i;
                if(helper(currNode+1,n,m,colors,graph)) return true;
                colors[currNode] = 0;
            }
        }
        return false;
    }
    public boolean isSafe(int[] colors,int c,boolean[][] graph,int currNode){
        for(int i = 0;i<graph[currNode].length;++i){
            if(graph[currNode][i] && colors[i] == c) return false;
        }
        return true;
    }
}