class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        /*int total = 0;
        HashMap<String,Integer> map = new HashMap<>();
        for(String str : words){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            String temp = entry.getKey();
            int value = entry.getValue();
            int i = 0;
            int j = 0;
            while(i < s.length() && j < temp.length()){
                if(temp.charAt(j) == s.charAt(i)){
                    j++;
                }
                i++;
            }
            if(j == temp.length()) total += map.get(temp);
        }
        return total;*/
        
        List<Integer[]>[] wait = new List[128];
        for(int c = 0;c<='z';++c){
            wait[c] = new ArrayList();
        }
        for(int i = 0;i<words.length;++i){
            wait[words[i].charAt(0)].add(new Integer[]{i,1});
        }
        for(char ch : s.toCharArray()){
            List<Integer[]> advance = new ArrayList(wait[ch]);
            wait[ch].clear();
            for(Integer[] a : advance){
                wait[a[1] < words[a[0]].length() ? words[a[0]].charAt(a[1]++) : 0].add(a);
            }
        }
        return wait[0].size();
    }
}