class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0,right = 0,max = 0,currSum = 0;
        HashSet<Integer> set = new HashSet<>();
        while(left < nums.length && right < nums.length){
            if(!set.contains(nums[right])){
                set.add(nums[right]);
                currSum += nums[right++];
                max = Math.max(currSum,max);
            }
            else{
                currSum -= nums[left];
                set.remove(nums[left++]);
            }
        }
        return max;
    }
}