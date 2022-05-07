class Solution {
    public boolean find132pattern(int[] nums) {
        /*Brute Force Approach
        for(int i = 0;i<nums.length-2;i++){
            for(int j = i+1;j<nums.length-1;j++){
                for(int k = j+1;k<nums.length;k++){
                    if(nums[i] < nums[k] && nums[k] < nums[j]) return true;
                }
            }
        }
        return false;*/
        //Optimized
        Stack<Integer> st = new Stack<>();
        int thirdElement = Integer.MIN_VALUE;
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] < thirdElement) return true;
            while(!st.isEmpty() && st.peek() < nums[i]) thirdElement = st.pop();
            st.push(nums[i]);
        }
        return false;
    }
}