class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n <= 1) return;
        int left = n-2;
        while(left >= 0 && nums[left] >= nums[left+1]){
            left--;
        }
        if(left >= 0){
            int right = n-1;
            while(nums[right] <= nums[left] && right >= 0){
                right--;
            }
            swap(nums,left,right);
        }
        reverse(nums,left+1,n-1);
    }
    public void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    public void reverse(int[] nums,int low,int high){
        while(low < high){
            swap(nums,low,high);
            ++low;
            --high;
        }
    }
}