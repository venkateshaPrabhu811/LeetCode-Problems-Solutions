class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        int len = s.length();
        int score = 0;
        for(int i = 0;i<len;i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stk.push(score);
                score = 0;
            }
            else{
                score = stk.pop() + Math.max(2*score,1);
            }
        }
        return score;
    }
}