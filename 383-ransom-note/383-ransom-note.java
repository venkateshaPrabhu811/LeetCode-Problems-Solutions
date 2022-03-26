class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.length() < ransomNote.length()){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<magazine.length();i++){
            char ch = magazine.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int flag = 0;
        for(int i = 0;i<ransomNote.length();i++){
            char ch = ransomNote.charAt(i);
            if(map.containsKey(ch) && map.get(ch) > 0){
                flag++;
                map.put(ch,map.get(ch)-1);
            }
        }
        return flag == ransomNote.length();
    }
}