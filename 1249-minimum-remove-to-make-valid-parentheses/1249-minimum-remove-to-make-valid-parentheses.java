class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stk = new Stack<>();
        char[] arr = s.toCharArray();
        for(int i = 0;i<s.length();i++){
            if(arr[i] == '('){
                stk.push(i);
            }
            else if(arr[i] == ')'){
                if(stk.isEmpty()){
                    arr[i] = '#';
                }
                else{
                    stk.pop();
                }
            }
        }
        while(!stk.isEmpty()){
            arr[stk.peek()] = '#';
            stk.pop();
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            if(arr[i] != '#'){
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}