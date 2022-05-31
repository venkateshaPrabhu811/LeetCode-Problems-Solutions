class Solution {
    public boolean hasAllCodes(String s, int k) {
        //Wrong Logic
        /*int value = (int)Math.pow(2,k);
        if(s.length() < k) return false;
        HashSet<Integer> set = new HashSet<>();
        for(int window = 1;window <= k;++window){
            for(int index = 0;index <= s.length()-k;++index){
                if(set.size() == value) return true;
                int temp = Integer.parseInt(s.substring(index,index+k));
                if(!set.contains(temp)) set.add(temp);
            }
        }
        return set.size() == value;*/
        
        /*int value = (int)Math.pow(2,k);
        if(s.length() < k) return false;
        HashSet<String> set = new HashSet<>();
        for(int index = 0;index <= s.length()-k;++index){
            set.add(s.substring(index,index+k));
        }
        return set.size() == value;*/
        
        //Time O(n*k)
        
        //Optimized
        //Using roll hash
        int need = 1<<k;
        boolean[] done = new boolean[need];
        int ones = need-1;
        int currhash = 0;
        for(int i = 0;i<s.length();++i){
            currhash = ((currhash << 1) & ones) | s.charAt(i) - '0';
            if(i >= k-1 && !done[currhash]){
                done[currhash] = true;
                --need;
                if(need == 0) return true;
            }
        }
        return false;
        //Time : O(n)
        //Space : O(2*k) all possible strings
    }
}