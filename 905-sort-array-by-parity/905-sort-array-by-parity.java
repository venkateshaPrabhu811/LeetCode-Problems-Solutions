class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        /*while(left < right){
            if(nums[left] % 2 == 0){
                left++;
            }
            else if(nums[right] % 2 != 0){
                right--;
            }
            else if(nums[left] % 2 != 0 && nums[right] % 2 == 0){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
                right--;
            }
        }*/
        while(left < right){
            if(nums[left] % 2 != 0){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                --right;
            }
            else{
                ++left;
            }
        }
        return nums;
    }
}