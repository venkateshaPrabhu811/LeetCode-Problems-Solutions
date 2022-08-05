class Solution {
    //private int count = 0;
    private int[] dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp,-1);
        dp[0] = 1;
        return helper(nums,target);
    }
    /*Brute Force -> Using Recursion -> TLE
    private void helper(int[] nums,int target,int sum){
        if(sum == target){
            ++count;
            return;
        }
        if(sum > target) return;
        for(int i = 0;i<nums.length;++i){
            sum += nums[i];
            helper(nums,target,sum);
            sum -= nums[i];
        }
    }*/
    
    //With Dp approach
    private int helper(int[] nums,int target){
        if(dp[target] != -1) return dp[target];
        
        int res = 0;
        for(int i = 0;i<nums.length;++i){
            if(target >= nums[i]){
                res += helper(nums,target - nums[i]);
            }
        }
        dp[target] = res;
        return res;
    }
}