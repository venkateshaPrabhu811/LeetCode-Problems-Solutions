class Solution {
    int[][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        dp = new int[m+1][n+1];
        //dp bottom up approach
        for(String s : strs){
            int[] count = count(s);
            for(int zero = m;zero >= count[0];zero--){
                for(int one = n;one >= count[1];one--){
                    dp[zero][one] = Math.max(dp[zero - count[0]][one-count[1]] + 1,dp[zero][one]);
                }
            }
        }
        return dp[m][n];
        //return helper(strs,m,n,0);
        
    }
    //Recursive Approach with dp
    /*private int helper(String[] str,int m,int n,int index){
        if(index == str.length || (m == 0 && n == 0)) return 0;
        
        if(dp[m][n][index] > 0) return dp[m][n][index];
        int[] count = count(str[index]);
        int consider = 0;
        if(m >= count[0] && n >= count[1])
            consider = 1 + helper(str,m-count[0],n-count[1],index+1);
        int skip = helper(str,m,n,index+1);
        
        dp[m][n][index] = Math.max(consider,skip);
        return dp[m][n][index];
    }*/
    private int[] count(String str){
        int[] count = new int[2];
        for(char ch : str.toCharArray()){
            count[ch - '0']++;
        }
        return count;
    }
}