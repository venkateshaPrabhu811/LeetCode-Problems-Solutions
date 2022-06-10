class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int maxLen = 0;
        int ptr = 0;
        int prev = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(ptr < s.length()){
            if(map.containsKey(s.charAt(ptr))){
                prev = Math.max(prev,map.get(s.charAt(ptr))+1);
            }
            map.put(s.charAt(ptr),ptr);
            maxLen = Math.max(maxLen,ptr-prev+1);
            ++ptr;
        }
        return maxLen;
    }
}