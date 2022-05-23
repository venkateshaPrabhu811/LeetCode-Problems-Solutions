class Solution {
    int[][][] dp;//recursive along with dp
    public int findMaxForm(String[] strs, int m, int n) {
        //Recursive Approach
        dp = new int[m+1][n+1][strs.length];
        return helper(strs,m,n,0);
        
    }
    private int helper(String[] str,int m,int n,int index){
        if(index == str.length || (m == 0 && n == 0)) return 0;
        
        if(dp[m][n][index] > 0) return dp[m][n][index];
        int[] count = count(str[index]);
        int consider = 0;
        if(m >= count[0] && n >= count[1])
            consider = 1 + helper(str,m-count[0],n-count[1],index+1);
        int skip = helper(str,m,n,index+1);
        
        dp[m][n][index] = Math.max(consider,skip);
        return dp[m][n][index];
    }
    private int[] count(String str){
        int[] count = new int[2];
        for(char ch : str.toCharArray()){
            count[ch - '0']++;
        }
        return count;
    }
}