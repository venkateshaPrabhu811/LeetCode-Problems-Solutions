//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            List<Integer> ans = obj.maxCombinations(n, k, a, b);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        Arrays.sort(A);
        Arrays.sort(B);
        pq.add(new int[]{A[N-1] + B[N-1],N-1,N-1});
        while(!pq.isEmpty() && K > 0){
            int[] arr = pq.poll();
            res.add(arr[0]);
            int l = arr[1];
            int r = arr[2];
            if(l == N-1 && r-1 >= 0){
                pq.add(new int[]{A[N-1] + B[r-1],N-1,r-1});
            }
            if(l-1 >= 0){
                pq.add(new int[]{A[l-1] + B[r],l-1,r});
            }
            --K;
        }
        return res;
    }
}
