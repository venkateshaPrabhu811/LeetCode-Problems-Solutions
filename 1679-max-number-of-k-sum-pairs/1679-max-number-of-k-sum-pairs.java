class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i : nums){
            Integer val = map.get(k-i);
            if(val != null && val > 0){
                count++;
                map.put(k-i,val-1);
            }
            else{
                map.put(i,map.getOrDefault(i,0)+1);
            }
        }
        return count;
    }
}