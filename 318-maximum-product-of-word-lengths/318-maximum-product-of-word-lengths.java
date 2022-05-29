class Solution {
    public int maxProduct(String[] words) {
        //brute force with every character array
        int[][] dp = new int[words.length][26];//for counting evey character in every word
        int max = 0;
        for(int i = 0;i<words.length;i++){
            for(int j = 0;j<words[i].length();j++){
                int ch = words[i].charAt(j) - 'a';
                dp[i][ch] = 1;
            }
        }
        for(int i = 0;i<words.length-1;i++){
            for(int j = i+1;j<words.length;j++){
                if(check(dp,i,j) == true)
                    max = Math.max(words[i].length()*words[j].length(),max);
            }
        }
        return max;
    }
    private boolean check(int[][] dp,int i,int j){
        for(int k = 0;k<26;k++){
            if(dp[i][k] == 1 && dp[j][k] == 1) return false;
        }
        return true;
    }
    //Time : O(n*n*26) ==> O(n*n)
    //Space : O(n*26) ==> O(n)
}