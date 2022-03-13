class Solution {
    public boolean canBeValid(String s, String locked) {
        int len = s.length();
        if(len % 2 != 0) return false;
        int open = 0;
        int close = 0;
        int flip = 0;
        for(int i = 0;i<len;i++){
            char ch = s.charAt(i);
            char key = locked.charAt(i);
            if(key == '1'){
                if(ch == '('){
                    open++;
                }
                else{
                    close++;
                }
            }
            else{
                flip++;
            }
            if(flip + open < close) return false;
        }
        flip = 0;
        close = 0;
        open = 0;
        for(int i = len-1;i>=0;i--){
            char ch = s.charAt(i);
            char key = locked.charAt(i);
            if(key == '1'){
                if(ch == '('){
                    open++;
                }
                else{
                    close++;
                }
            }
            else{
                flip++;
            }
            if(flip + close < open) return false;
        }
        return true;
    }
}