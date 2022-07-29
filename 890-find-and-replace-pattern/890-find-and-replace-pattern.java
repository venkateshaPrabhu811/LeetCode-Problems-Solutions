class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new LinkedList<>();
        String match = generateCode(pattern);
        for(String str : words){
            if(generateCode(str).equals(match)) res.add(str);
        }
        return res;
    }
    private String generateCode(String pattern){
        String res = "";
        HashMap<Character,Integer> map = new HashMap<>();
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