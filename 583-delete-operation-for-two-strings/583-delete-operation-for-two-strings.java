class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        int maxLen = 0;
        for(int row = 1;row <= len1;++row){
            for(int col = 1;col <= len2;++col){
                if(word1.charAt(row-1) == word2.charAt(col-1)){
                    dp[row][col] = 1 + dp[row-1][col-1];
                    maxLen = Math.max(dp[row][col],maxLen);
                }
                else{
                    dp[row][col] = Math.max(dp[row][col-1],dp[row-1][col]);
                }
            }
        }
        return (len1 - maxLen) + (len2 - maxLen);
    }
}