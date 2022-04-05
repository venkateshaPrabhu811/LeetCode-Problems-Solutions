class Solution {
    public int maxArea(int[] height) {
        /* Brute force Time Limit Exceeded
        int len = height.length;
        int max = 0;
        for(int i = 0;i<len-1;i++){
            for(int j = i+1;j<len;j++){
                int temp = Math.min(height[i],height[j]) * (j-i);
                if(temp > max){
                    max = temp;
                }
            }
        }
        return max;*/
        int ans = 0;
        int left = 0;
        int right = height.length-1;
        while(left < right){
            ans = Math.max(Math.min(height[left],height[right]) * (right - left) , ans);
            if(height[left] < height[right]) ++left;
            else --right;
        }
        return ans;
    }
}