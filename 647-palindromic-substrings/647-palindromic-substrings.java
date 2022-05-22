class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        for(int i = 0;i<s.length();i++){
            isPal(s,i,i);//for odd length initially it checks single char always
            isPal(s,i,i+1);//for even length starting with two characters
        }
        return count;
    }
    private void isPal(String str,int left,int right){//to extend palindrome on both sides
        while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)){
            count++;
            left--;
            right++;
        }
    }
}