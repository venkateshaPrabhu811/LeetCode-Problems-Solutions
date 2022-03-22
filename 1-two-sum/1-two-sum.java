class Solution {
    /*public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if((nums[i]+nums[j])==target){
                    result[0]=i;
                    result[1]=j;
                    break;
                }
            }
        }
        return result;
    }*/
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i = 0;i<nums.length;i++){
            int num = nums[i];
            int rem  = target - nums[i];
            if(map.containsKey(rem)){
                int index  = map.get(rem);
                if(index == i) continue;
                return new int[]{i,index};
            }
        }
        return new int[]{};
    }
}