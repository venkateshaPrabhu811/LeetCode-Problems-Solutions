class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        Arrays.sort(tokens);
        int left = 0;
        int right = tokens.length-1;
        int curr = 0;
        while(left <= right){
            if(power >= tokens[left]){
                power -= tokens[left];
                ++curr;
                ++left;
            }
            else{
                if(curr == 0) break;
                power += tokens[right];
                --right;
                --curr;
            }
            score = Math.max(score,curr);
        }
        return score;
    }
}