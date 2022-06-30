class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int operations = 0;
        int middle = nums[nums.length/2];
        for(int i = 0;i<nums.length;++i){
            operations += Math.abs(middle - nums[i]);
        }
        return operations;
    }
}