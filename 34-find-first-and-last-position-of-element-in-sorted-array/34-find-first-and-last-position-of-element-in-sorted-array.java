class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int[] res = new int[2];
        res[0] = binarySearch(nums,target,true);
        res[1] = binarySearch(nums,target,false);
        return res;
    }
    
    int binarySearch(int[] nums, int target, boolean isStart) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] > target) {
                end = mid - 1;
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                ans = mid;
                if(isStart) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}