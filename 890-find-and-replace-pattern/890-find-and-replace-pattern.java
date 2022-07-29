class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new LinkedList<>();
        String match = generateCode(pattern,new HashMap<Character,Integer>());
        for(int i = 0;i<words.length;++i){
            String temp = generateCode(words[i],new HashMap<Character,Integer>());
            if(temp.equals(match)) res.add(words[i]);
        }
        return res;
    }
    private String generateCode(String pattern,HashMap<Character,Integer> map){
        String res = "";
        for(int i = 0;i<pattern.length();++i){
            char ch = pattern.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,i);
            }
            res += map.get(ch);
        }
        return res;
    }
}