//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public ArrayList<String> permutation(String S)
    {
        ArrayList<String> res = new ArrayList<>();
        int n = S.length();
        helper(0,new StringBuilder(S),n,res);
        Collections.sort(res);
        return res;
    }
    public void helper(int currIndex,StringBuilder sb,int n,ArrayList<String> res){
        if(currIndex == n){
            res.add(sb.toString());
            return;
        }
        for(int i = currIndex;i<n;++i){
            sb = swap(sb,currIndex,i);
            helper(currIndex+1,sb,n,res);
            sb = swap(sb,currIndex,i);
        }
    }
    public StringBuilder swap(StringBuilder sb,int i,int j){
        char left = sb.charAt(i);
        char right = sb.charAt(j);
        sb.setCharAt(i,right);
        sb.setCharAt(j,left);
        return sb;
    }
	   
}
