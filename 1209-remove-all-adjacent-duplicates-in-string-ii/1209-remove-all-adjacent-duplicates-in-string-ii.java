class Solution {
    public String removeDuplicates(String s, int k) {
        /*Brute force TLE
        Stack<Character> Master = new Stack<>();
        for(int i = 0;i<s.length();i++){
            Stack<Character> helper = new Stack<>();
            helper.push(s.charAt(i));
            while(!Master.isEmpty() && Master.peek() == s.charAt(i)){
                helper.push(Master.pop());
            }
            if(helper.size() != k){
                while(!helper.isEmpty()){
                    Master.push(helper.pop());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!Master.isEmpty()){
            sb.append(Master.pop());
        }
        return sb.reverse().toString();*/
        //Optimized Approach
        Stack<pair> stk = new Stack<>();
        for(int i = 0;i<s.length();i++){
            if(!stk.isEmpty() && stk.peek().ch == s.charAt(i)){
                stk.peek().count++;
            }
            else{
                stk.push(new pair(s.charAt(i),1));
            }
            if(stk.peek().count == k) stk.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            pair temp = stk.pop();
            while(temp.count-- > 0){
                sb.append(temp.ch);
            }
        }
        return sb.reverse().toString();
    }
}
class pair{
    char ch;
    int count;
    pair(char ch,int count){
        this.ch = ch;
        this.count = count;
    }
}