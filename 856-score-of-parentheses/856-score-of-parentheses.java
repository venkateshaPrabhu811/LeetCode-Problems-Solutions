class Solution {
    public int scoreOfParentheses(String s) {
        /*Stack<Integer> stk = new Stack<>();
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
        return score;*/
        
        Stack<Integer> stk = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stk.push(0);
            }
            else{
                if(stk.peek() == 0){
                    stk.pop();
                    stk.push(1);
                }
                else{
                    int ans = 0;
                    while(stk.peek() != 0){
                        ans += stk.pop();
                    }
                    stk.pop();
                    stk.push(ans*2);
                }
            }
        }
        int ans = 0;
        while(!stk.isEmpty()){
            ans += stk.pop();
        }
        return ans;
    }
}