class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1) return s.length();
        int maxLen = 0;
        int ptr = 0;
        int prev = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(ptr < s.length()){
            char ch = s.charAt(ptr);
            if(map.get(ch) == null){
                map.put(ch,1);
                ++ptr;
            }
            else{
                map.clear();
                maxLen = Math.max(maxLen,ptr-prev);
                ptr = prev+1;
                ++prev;
            }
        }
        maxLen = Math.max(maxLen,ptr-prev);
        return maxLen;
    }
}