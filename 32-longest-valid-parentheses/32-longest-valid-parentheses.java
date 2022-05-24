class Solution {
    public int longestValidParentheses(String s) {
        //Normal stack approach
        /*Stack<Integer> stk = new Stack<>();
        stk.add(-1);
        int max = 0;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stk.push(i);
            }
            else{
                stk.pop();
                if(stk.isEmpty()){
                    stk.push(i);
                }
                else{
                    int len = i - stk.peek();
                    max = Math.max(len,max);
                }
            }
        }
        return max;*/
        //O(1) space approach by counting the open and close paranthesis
        /*int open = 0;
        int close = 0;
        int max = 0;
        char ch;
        for(int i = 0;i<s.length();i++){
            ch = s.charAt(i);
            if(ch == '(')open++;
            else close++;
            
            if(open == close){
                int len = open + close;
                max = Math.max(len,max);
            }
            else if(close > open)
                open = close = 0;
        }
        open = close = 0;
        for(int i = s.length()-1;i>=0;i--){
            ch = s.charAt(i);
            if(ch == '(') open++;
            else close++;
            
            if(open == close){
                int len = open + close;
                max = Math.max(len,max);
            }
            else if(open > close)
                open = close = 0;
        }
        return max;*/
        //Using dp
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}