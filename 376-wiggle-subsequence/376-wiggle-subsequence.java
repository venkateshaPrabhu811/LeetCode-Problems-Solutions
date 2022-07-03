class Solution {
    public int wiggleMaxLength(int[] nums) {
        //dp solution O(2n) space
        /*int n = nums.length;
        if(n < 2) return n;
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = 1;
        down[0] = 1;
        for(int i = 1;i<n;++i){
            if(nums[i] < nums[i-1]){
                down[i] = up[i-1] + 1;
                up[i] = up[i-1];
            }
            else if(nums[i] > nums[i-1]){
                up[i] = down[i-1] + 1;
                down[i] = down[i-1];
            }
            else{
                up[i] = up[i-1];
                down[i] = down[i-1];
            }
        }
        return Math.max(up[n-1],down[n-1]);*/
        
        //O(1) space
        int n = nums.length;
        if(n < 2) return n;
        int up = 1;
        int down = 1;
        for(int i = 1;i<n;++i){
            if(nums[i] < nums[i-1]){
                down = up + 1;
            }
            else if(nums[i] > nums[i-1]){
                up = down + 1;
            }
        }
        return Math.max(up,down);
    }
}