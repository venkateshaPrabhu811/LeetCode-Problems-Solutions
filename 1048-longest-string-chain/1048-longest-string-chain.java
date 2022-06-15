class Solution {
    public int longestStrChain(String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
        Arrays.sort(words,Comparator.comparingInt(String :: length));
        int res = 1;
        for(String word : words){
            map.put(word,1);
            StringBuilder sb = new StringBuilder(word);
            for(int i = 0;i<word.length();++i){
                char ch = sb.charAt(i);
                sb.deleteCharAt(i);
                if(map.containsKey(sb.toString())){
                    int val = map.get(sb.toString());
                    map.put(word,val+1);
                    res = Math.max(res,val+1);
                }
                sb.insert(i,ch);
            }
        }
        return res;
    }
}