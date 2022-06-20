class Solution {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words,Comparator.comparingInt(String :: length));
        HashMap<String,Integer> map = new HashMap<>();
        for(int ptr = words.length-1;ptr >=0 ;--ptr){
            map.put(words[ptr],1);
        }
        int res = 0;
        for(int ptr = words.length-1;ptr >= 0;--ptr){
            if(map.get(words[ptr]) == 0) continue;
            int len = words[ptr].length();
            int right = len-1;
            while(right >= 0){
                String temp = words[ptr].substring(right,len);
                if(map.containsKey(temp) && map.get(temp) == 1) map.put(temp,0);
                --right;
            }
            res += len + 1;
        }
        return res;
    }
}