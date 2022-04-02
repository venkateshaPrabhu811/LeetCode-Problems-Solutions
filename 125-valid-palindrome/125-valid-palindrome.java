class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch) || (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))
                sb.append(ch);
        }
        String res = new String(sb).toLowerCase();
        int left = 0;
        int right = res.length()-1;
        while(left < right){
            if(res.charAt(left) != res.charAt(right)){
                return false;
            }
            else{
                left++;
                right--;
            }
        }
        return true;
    }
}