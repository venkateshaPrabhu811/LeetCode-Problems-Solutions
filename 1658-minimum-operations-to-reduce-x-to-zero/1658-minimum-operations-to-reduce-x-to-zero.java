class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int maxLen = -1;
        int currSum = 0;
        for(int left = 0,right = 0;right < nums.length;++right){
            currSum += nums[right];
            while(left <= right && currSum > sum - x){
                currSum -= nums[left++];
            }
            if(currSum == sum - x) maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen == -1 ? -1 : nums.length-maxLen;
    }
}