class Solution {
    public int missingNumber(int[] nums) {
        /*
        int sum = nums.length;
        for(int i = 0;i<nums.length;i++){
            sum = sum ^ nums[i] ^ i;
        }
        return sum;*/
        int len = nums.length;
        int sum = (len * (len+1))/2;
        for(int i = 0;i<len;i++){
            sum -= nums[i];
        }
        return sum;
    }
}