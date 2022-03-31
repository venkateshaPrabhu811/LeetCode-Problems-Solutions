class Solution {
    public int splitArray(int[] nums, int m) {
        int len = nums.length;
        int l = 0;
        int r = 0;
        int ans = 0;
        for(int i = 0;i<len;i++){
            l = Math.max(nums[i],l);
            r += nums[i];
        }
        while(l <= r){
            int mid = (l+r)/2;
            int count = check(nums,mid);
            if(count > m) l = mid+1;
            else{
                r = mid-1;
                ans = mid;
            }
        }
        return ans;
    }
    public int check(int[] nums,int mid){
        int count = 0;
        int tempSum = 0;
        for(int i = 0;i<nums.length;i++){
            if(tempSum + nums[i] <= mid){
                tempSum += nums[i];
            }
            else{
                count++;
                tempSum = nums[i];
            }
        }
        count++;
        return count;
    }
}