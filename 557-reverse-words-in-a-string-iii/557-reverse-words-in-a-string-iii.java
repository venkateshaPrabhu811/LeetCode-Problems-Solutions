class Solution {
    public String reverseWords(String s) {
        int ptr = 0;
        int n = s.length();
        String res = new String();
        while(ptr < n){
            StringBuilder sb = new StringBuilder();
            while(s.charAt(ptr) != ' '){
                sb.append(s.charAt(ptr));
                ++ptr;
                if(ptr == n) break;
            }
            if(ptr == n){
                res += sb.reverse().toString();
                break;
            }
            ++ptr;
            res += sb.reverse().toString() + " ";
        }
        return res;
    }
}