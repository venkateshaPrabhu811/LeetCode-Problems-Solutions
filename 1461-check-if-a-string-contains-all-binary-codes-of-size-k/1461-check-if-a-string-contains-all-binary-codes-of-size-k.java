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
        
        int value = (int)Math.pow(2,k);
        if(s.length() < k) return false;
        HashSet<String> set = new HashSet<>();
        for(int index = 0;index <= s.length()-k;++index){
            set.add(s.substring(index,index+k));
        }
        return set.size() == value;
        
        //Time O(n*k)
    }
}