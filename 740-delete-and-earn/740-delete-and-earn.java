class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] values = new int[10001];
        int maxRange = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            values[nums[i]] += nums[i];
            if(nums[i] > maxRange){
                maxRange = nums[i];
            }
        }
        int take = 0;
        int skip = 0;
        for(int i = 0;i<=maxRange;i++){
            int taken = Math.max(take + values[i],skip);
            take = skip;
            skip = taken;
            //System.out.println(take + " " + skip);
        }
        return Math.max(take,skip);
    }
}