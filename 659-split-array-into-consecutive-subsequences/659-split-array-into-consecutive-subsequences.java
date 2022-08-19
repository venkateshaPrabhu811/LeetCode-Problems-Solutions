class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        HashMap<Integer,Integer> end = new HashMap<>();
        for(int i : nums){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }
        for(int i : nums){
            if(freq.get(i) == null || freq.get(i) == 0) continue;
            freq.put(i,freq.get(i)-1);
            if(end.getOrDefault(i-1,0) > 0){
                end.put(i-1,end.get(i-1)-1);
                end.put(i,end.getOrDefault(i,0)+1);
            }
            else if(freq.getOrDefault(i+1,0) > 0 && freq.getOrDefault(i+2,0) > 0){
                freq.put(i+1,freq.get(i+1)-1);
                freq.put(i+2,freq.get(i+2)-1);
                end.put(i+2,end.getOrDefault(i+2,0)+1);
            }
            else return false;
        }
        return true;
    }
}