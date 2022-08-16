class Solution {
    public int firstUniqChar(String s) {
        /*HashMap<Character,ArrayList<Integer>> map = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0;i<s.length();i++){
            Character key = s.charAt(i);
            if(map.get(key) == null){
                map.put(key,new ArrayList<Integer>());
            }
            map.get(key).add(i);
        }
        for(Map.Entry<Character,ArrayList<Integer>> e : map.entrySet()){
            ArrayList<Integer> values = e.getValue();
            if(values.size() == 1){
                q.add(values.get(0));
            }
        }
        if(q.isEmpty()){
            q.add(-1);
        }
        return q.peek();*/
        
        /*HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i = 0;i<s.length();i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;*/
        
        /*int[] freq = new int[26];
        int index = -1;
        for(int i = s.length()-1;i>=0;--i){
            char ch = s.charAt(i);
            if(freq[ch - 'a'] == 0){
                index = i;
            }
            freq[ch - 'a']++;
        }
        return (index >= 0 && freq[s.charAt(index) - 'a'] == 1) ? index : -1;*/
        int[] freq = new int[26];
        Arrays.fill(freq,-1);
        for(int i = 0;i<s.length();++i){
            int ch = s.charAt(i) - 'a';
            if(freq[ch] == -1){
                freq[ch] = i;
            }
            else if(freq[ch] >= 0){
                freq[ch] = -2;
            }
        }
        int min = -1;
        for(int i = 0;i<26;++i){
            if(freq[i] >= 0){
                if(min == -1) min = freq[i];
                else min = freq[i] < min ? freq[i] : min;
            }
        }
        return min;
    }
}