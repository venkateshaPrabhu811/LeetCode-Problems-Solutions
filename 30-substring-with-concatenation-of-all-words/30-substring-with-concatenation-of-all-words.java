class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        /*HashMap<Character,Integer> wordMap = new HashMap<>();
        int wordSize = words[0].length();
        int size = words.length; 
        for(int i = 0;i<size;++i){
            for(int j = 0;j<wordSize;++j){
                char ch = words[i].charAt(j);
                wordMap.put(ch,wordMap.getOrDefault(ch,0)+1);
            }
        }
        int currSize = 0;
        int start = 0;
        int end = 0;
        int windowSize = size * wordSize;
        HashMap<Character,Integer> window = new HashMap<>();
        List<Integer> res = new LinkedList<>();
        if(windowSize > s.length()) return res;
        while(start < s.length() - windowSize){
            char ch = s.charAt(end);
            window.put(ch,window.getOrDefault(ch,0)+1);
            ++end;
            ++currSize;
            if(currSize == windowSize){
                if(match(wordMap,window)){
                    res.add(start);
                }
                currSize--;
                char temp = s.charAt(start);
                window.put(temp,window.get(temp)-1);
                if(window.get(temp) == 0) window.remove(temp);
                ++start;
            }
        }
        return res;*/
        
        HashMap<String,Integer> count = new HashMap<>();
        int sLen = s.length();
        int wLen = words[0].length();
        int window = words.length * wLen;
        for(String word : words){
            count.put(word,count.getOrDefault(word,0)+1);
        }
        List<Integer> index = new LinkedList<>();
        int start = 0;
        while(start < sLen - window + 1){
            String sub = s.substring(start,start + window);
            if(isMatch(sub,count,wLen)) index.add(start);
            ++start;
        }
        return index;
    }
    
    /*private boolean match(HashMap<Character,Integer> wordMap,HashMap<Character,Integer> window){
        for(Map.Entry<Character,Integer> entry : wordMap.entrySet()){
            char key = entry.getKey();
            int freq = entry.getValue();
            if(!window.containsKey(key) || window.get(key) != freq) return false;
        }
        return true;
    }*/
    
    private boolean isMatch(String sub,HashMap<String,Integer> count,int wLen){
        HashMap<String,Integer> word = new HashMap<>();
        for(int i = 0;i < sub.length();i += wLen){
            String w = sub.substring(i,i+wLen);
            word.put(w,word.getOrDefault(w,0)+1);
        }
        return word.equals(count);
    }
}