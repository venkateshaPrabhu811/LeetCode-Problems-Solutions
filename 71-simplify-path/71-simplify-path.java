class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stk = new Stack<>();
        for(String s : paths){
            if(s.equals(".") || s.equals("")){
                continue;
            }
            if(s.equals("..")){
                if(!stk.isEmpty()) stk.pop();
                else continue;
            }
            else{
                stk.push(s);
            }
            
        }
        return "/" + String.join("/",stk);
    }
}