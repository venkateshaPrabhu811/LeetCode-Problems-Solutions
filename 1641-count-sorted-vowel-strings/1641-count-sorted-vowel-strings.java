class Solution {
    int count = 0;
    public int countVowelStrings(int n) {
        int[] dp = new int[5];
        Arrays.fill(dp,1);//Initially all vowels placed 1 time
        //aa,ae,ai,ao,au when we place one letter there are possibilities of 
        //placing same letter again and the lexicographically greater letters only
        while(n-- > 0){
            for(int i = 3;i>=0;i--){
                dp[i] += dp[i+1];
            }
        }
        return dp[0];
        
    }
}