class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        /*Brute Force
        Set<String> set = new HashSet<>();
        List<String> res = new LinkedList<>();
        for(String word1 : words1){
            int count = 0;
            int[] map = new int[26];
            for(int i = 0;i<word1.length();++i){
                ++map[word1.charAt(i) - 'a'];
            }
            for(String word2 : words2){
                int[] temp = new int[26];
                for(int i = 0;i<word2.length();++i){
                    ++temp[word2.charAt(i) - 'a'];
                }
                int i = 0;
                for(;i<26;++i){
                    if(map[i] < temp[i]) break;
                }
                if(i == 26) ++count;
            }
            if(count == words2.length) set.add(word1);
        }
        for(String str : set){
            res.add(str);
        }
        return res;*/
        
        //Optimal
        List<String> res = new LinkedList<>();
        int[] maxFreq = new int[26];
        for(String word2 : words2){
            int[] freq = countFreq(word2);
            for(int i = 0;i<26;++i){
                maxFreq[i] = Math.max(freq[i],maxFreq[i]);
            }
        }
        for(String word1 : words1){
            int[] freq = countFreq(word1);
            int i = 0;
            for(;i<26;++i){
                if(freq[i] < maxFreq[i]) break;
            }
            if(i == 26) res.add(word1);
        }
        return res;
    }
    private int[] countFreq(String str){
        int[] temp = new int[26];
        for(int i = 0;i<str.length();++i){
            ++temp[str.charAt(i) - 'a'];
        }
        return temp;
    }
}