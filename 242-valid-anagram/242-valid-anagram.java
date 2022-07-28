class Solution {
    public boolean isAnagram(String s, String t) {
        /*Sorting without space
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        Arrays.sort(sarr);
        Arrays.sort(tarr);
        if(String.valueOf(sarr).equals(String.valueOf(tarr))){
            return true;
        }
        return false;*/
        
        //HashMap Approach
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int m = t.length();
        if(n != m) return false;
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch : t.toCharArray()){
            if(!map.containsKey(ch)|| map.get(ch) == 0) return false;
            map.put(ch,map.get(ch)-1);
        }
        return true;
    }
}