class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        Arrays.sort(sarr);
        Arrays.sort(tarr);
        if(String.valueOf(sarr).equals(String.valueOf(tarr))){
            return true;
        }
        return false;
    }
}