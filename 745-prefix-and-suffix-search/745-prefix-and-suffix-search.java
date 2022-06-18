class WordFilter {
    HashMap<String,Integer> map = new HashMap<>();
    public WordFilter(String[] words) {
        for(int w = 0;w < words.length;++w){
            for(int pre = 0;pre <= 10 && pre <= words[w].length();++pre){
                for(int suf = 0;suf <= 10 && suf <= words[w].length();++suf){
                    map.put(words[w].substring(0,pre) + "#" + words[w].substring(words[w].length()-suf),w);
                }
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        return map.containsKey(prefix + "#" + suffix) ? map.get(prefix + "#" + suffix) : -1;
    }
}
/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */