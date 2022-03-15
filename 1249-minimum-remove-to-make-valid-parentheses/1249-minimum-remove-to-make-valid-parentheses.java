class Solution {
    public String minRemoveToMakeValid(String s) {
        /*Stack<Integer> stk = new Stack<>();
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
        return sb.toString();*/
        
        char[] arr = s.toCharArray();
        int count = 0;
        for(int i = 0;i<s.length();++i){
            if(arr[i] == '('){
                ++count;
            }
            else if(arr[i] == ')'){
                if(count == 0){
                    arr[i] = '#';
                }
                else{
                    count--;
                }
            }
        }
        count = 0;
        for(int i = s.length()-1;i>=0;--i){
            if(arr[i] == ')'){
                count++;
            }
            else if(arr[i] == '('){
                if(count == 0){
                    arr[i] = '#';
                }
                else{
                    count--;
                }
            }
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