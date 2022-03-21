class Solution {
    public boolean containsDuplicate(int[] nums) {
        /*HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                return true;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return false;*/
        
        if(nums == null || nums.length < 2) return false;
        if(nums[0] == nums[1] || nums[nums.length-1] == nums[nums.length-2]) return true;
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            if(set.contains(i)){
                return true;
            }
            set.add(i);
        }
        return false;
    }
}