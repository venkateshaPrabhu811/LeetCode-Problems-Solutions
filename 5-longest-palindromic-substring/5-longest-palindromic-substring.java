class Solution {
    public String longestPalindrome(String s) {
        //Brute Force
        /*int maxLen = 0;
        String res = "";
        if(s.length() == 1) return s;
        for(int i = 0;i<s.length()-1;++i){
            for(int j = i;j<s.length();++j){
                String temp = s.substring(i,j+1);
                if(isPalindrome(temp)){
                    if(maxLen < j-i+1){
                        res = temp;
                        maxLen = j-i+1;
                    }
                }
            }
        }
        return res;*/
        //Optimized
        int maxLen = 1;
        int len = s.length();
        int start = 0;
        for(int i = 1;i<s.length();++i){
            int left = i-1;
            int right = i;
            while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)){
                if(maxLen <= right-left+1){
                    start = left;
                    maxLen = right - left + 1;
                }
                --left;
                ++right;
            }
            left = i-1;
            right = i+1;
            while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)){
                if(maxLen <= right-left+1){
                    start = left;
                    maxLen = right - left + 1;
                }
                --left;
                ++right;
            }
        }
        return s.substring(start,start+maxLen);
        
    }
    private boolean isPalindrome(String str){
        int left = 0;
        int right = str.length()-1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)) return false;
            ++left;
            --right;
        }
        return true;
    }
}