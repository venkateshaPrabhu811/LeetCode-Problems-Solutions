//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        int left = 0;
        int right = 0;
        int len = s.length();
        HashSet<Character> set = new HashSet<>();
        int[] freq = new int[26];
        int ans = 0;
        while(right < len){
            set.add(s.charAt(right));
            freq[s.charAt(right) - 'a']++;
            ++right;
            if(set.size() > k){
                while(set.size() > k){
                    freq[s.charAt(left) - 'a']--;
                    if(freq[s.charAt(left) - 'a'] == 0){
                        set.remove(s.charAt(left));
                    }
                    ++left;
                }
            }
            ans = Math.max(right - left,ans);
        }
        return set.size() < k ? -1 : ans;
    }
}