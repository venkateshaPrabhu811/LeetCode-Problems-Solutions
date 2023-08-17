//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int num[] = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(str[i]);
            }

            Vector<Integer> ans = new Solution().generateNextPalindrome(num, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    Vector<Integer> generateNextPalindrome(int num[], int n) {
        boolean change = true;
        for(int i = 0;i<n/2;++i){
            if(num[i] < num[n-i-1]){
                change = true;
            }
            else if(num[i] > num[n-i-1]){
                change = false;
            }
            num[n-i-1] = num[i];
        }
        Vector<Integer> ans = new Vector<>();
        int ind = n/2;
        while(change && ind < n){
            if(num[ind] == 9){
                num[ind] = 0;
                num[n-ind-1] = 0;
            }
            else{
                num[ind]++;
                num[n - ind - 1] = num[ind];
                change = false;
            }
            ++ind;
        }
        for(int ele : num){
            ans.add(ele);
        }
        if(change){
            ans.add(1);
            ans.set(0,1);
        }
        return ans;
        
    }
}