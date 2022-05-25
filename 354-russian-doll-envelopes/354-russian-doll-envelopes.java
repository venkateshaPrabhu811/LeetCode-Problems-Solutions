class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a1,a2) -> {
            if(a1[0] == a2[0]) return a2[1] - a1[1];
            else return a1[0] - a2[0];
        });
        int[] dp = new int[envelopes.length+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = Integer.MIN_VALUE;
        int ans = 0;
        for(int[] e : envelopes){
            int val = e[1];
            int index = binarySearch(dp,val);
            ans = Math.max(ans,index);
            if(dp[index] >= val){
                dp[index] = val;
            }
        }
        return ans;
    }
    private int binarySearch(int[] dp,int val){
        int low = 0;
        int high = dp.length-1;
        int res = 0;
        while(low <= high){
            int mid = (low + high)/2;
            if(dp[mid] < val){
                res = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return res + 1;
    }
}