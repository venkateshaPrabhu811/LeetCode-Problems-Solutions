class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                stk.push(ch);
            }
            else{
                if(stk.isEmpty()) return false;
                char ch2 = stk.peek();
                if(ch == ')' && ch2 == '(') stk.pop();
                else if(ch == ']' && ch2 == '[') stk.pop();
                else if(ch == '}' && ch2 == '{') stk.pop();
                else return false;
            }
        }
        return stk.isEmpty();
    }
}