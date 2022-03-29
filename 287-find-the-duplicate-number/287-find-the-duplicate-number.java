class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int value = 0;
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                value = nums[i];
                break;
            }
            map.put(nums[i],1);
        }
        return value;
    }
}