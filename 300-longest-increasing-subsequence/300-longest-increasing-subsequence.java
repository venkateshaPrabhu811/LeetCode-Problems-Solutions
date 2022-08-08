class Solution {
    public int lengthOfLIS(int[] nums) {
        /*int n = nums.length;
        int[] dp = new int[n];
        for(int i = 0;i<n;i++){
            dp[i] = 1;
        }
        for(int i = 1;i<n;i++){
            for(int j = 0;j<i;j++){
                if(nums[i] > nums[j] && dp[i] <= dp[j]){
                    dp[i]++;
                }
            }
        }
        int ans = 0;
        for(int i = 0;i<n;i++){
            if(dp[i] > ans){
                ans = dp[i];
            }
        }
        return ans;*/
        /*int n = nums.length;
        if(n == 1) return 1;
        int[] dp = new int[n];
        int max = 0;
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i = 0;i<n;i++){
            int pos = findPosition(dp,nums[i],i);
            dp[pos] = nums[i];
            if(pos > max){
                max = pos;
            }
        }
        return max+1;
    }
    public int findPosition(int[] dp , int target , int high){
        int low = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(target == dp[mid]){
                return mid;
            }
            else if(dp[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid -1;
            }
        }
        return low;
    }*/
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0;i<nums.length;i++){
            Integer x = set.ceiling(nums[i]);
            if(x != null){
                set.remove(x);
            }
            set.add(nums[i]);
        }
        return set.size();
    }
}