class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        /*Arrays.sort(properties, (a,b) -> (a[0] == b[0]) ? b[1] - a[1] : a[0] - b[0]);
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int i = properties.length-1;i>=0;--i){
            if(properties[i][1] < max) ++count;
            max = Math.max(max,properties[i][1]);
        }
        return count;*/
        
        int count = 0;
        int[] dp = new int[100002];
        for(int[] arr : properties){
            dp[arr[0]] = Math.max(dp[arr[0]],arr[1]);
        }
        for(int i = 100000;i>0;--i){
            dp[i-1] = Math.max(dp[i],dp[i-1]);
        }
        for(int[] arr : properties){
            count += dp[arr[0] + 1] > arr[1] ? 1 : 0;
        }
        return count;
    }
}