//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.math.*;

class Multiply{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            Solution g=new Solution();
            System.out.println(g.multiplyStrings(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String multiplyStrings(String s1,String s2)
    {
        boolean neg = false;
        if(s1.charAt(0) =='-'){
            neg = neg ^ true;
            s1 = s1.substring(1);
        }
        if(s2.charAt(0) =='-'){
            neg = neg ^ true;
            s2 = s2.substring(1);
        }
        s1 = new StringBuilder(s1).reverse().toString();
        s2 = new StringBuilder(s2).reverse().toString();
        int n = s1.length();
        int m = s2.length();
        int[] res = new int[n+m+10];
        for(int i = 0;i<m;++i){
            int pos = i;
            int first = s2.charAt(i) - '0';
            for(int j = 0;j<n;++j){
                int second = s1.charAt(j) - '0';
                res[pos] += first * second;
                if(res[pos] > 9){
                    res[pos + 1] += res[pos] / 10;
                    res[pos] = res[pos] % 10;
                }
                ++pos;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(neg){
            sb.append('-');
        }
        boolean found = false;
        for(int i = res.length-1;i >= 0;--i){
            if(res[i] > 0){
                found = true;
            }
            if(found){
                sb.append(res[i]);
            }
        }
        return sb.toString();
    }
}