class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last_idx = new int[26];
        for(int i = 0;i<s.length();i++){
            last_idx[s.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int lastOccurence = 0;
        for(int i = 0;i<s.length();i++){
            int start = i;
            lastOccurence = last_idx[s.charAt(i) - 'a'];
            while(i < lastOccurence){
                if(last_idx[s.charAt(i) - 'a'] > lastOccurence){
                    lastOccurence = last_idx[s.charAt(i) - 'a'];
                }
                i++;
            }
            res.add(i - start + 1);
        }
        return res;
    }
}