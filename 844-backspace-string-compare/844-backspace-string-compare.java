class Solution {
    public boolean backspaceCompare(String s, String t) {
        /*Stack<Character> stk1 = new Stack<>();
        Stack<Character> stk2 = new Stack<>();
        int ptr1 = 0;
        int ptr2 = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '#'){
                if(stk1.isEmpty()) continue;
                else stk1.pop();
            }
            else{
                stk1.push(s.charAt(i));
            }
        }
        for(int i = 0;i<t.length();i++){
            if(t.charAt(i) == '#'){
                if(stk2.isEmpty()) continue;
                else stk2.pop();
            }
            else{
                stk2.push(t.charAt(i));
            }
        }
        if(stk1.size() != stk2.size()) return false;
        while(!stk1.isEmpty()){
            if(stk1.pop() != stk2.pop()){
                return false;
            }
        }
        return true;*/
        int left = s.length()-1;
        int right = t.length()-1;
        int spaceLeft = 0;
        int spaceRight = 0;
        while(left >= 0 || right >= 0){
            while(left >= 0){
                if(s.charAt(left) == '#'){
                    spaceLeft++;
                    left--;
                }
                else if(spaceLeft > 0){
                    left--;
                    spaceLeft--;
                }
                else{
                    break;
                }
            }
            while(right >= 0){
                if(t.charAt(right) == '#'){
                    spaceRight++;
                    right--;
                }
                else if(spaceRight > 0){
                    right--;
                    spaceRight--;
                }
                else{
                    break;
                }
            }
            if(left < 0 && right < 0) return true;
            if(left >= 0 && right >= 0 && s.charAt(left) != t.charAt(right)) return false;
            if(left < 0 || right < 0) return false;
            left--;
            right--;
        }
        return true;
    }
}