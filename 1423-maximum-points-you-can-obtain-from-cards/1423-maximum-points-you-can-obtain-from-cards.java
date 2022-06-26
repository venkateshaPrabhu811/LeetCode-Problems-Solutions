class Solution {
    public int maxScore(int[] cardPoints, int k) {
        /*int n = cardPoints.length;
        int[] pre = new int[n];
        pre[0] = cardPoints[0];
        for(int i = 1;i<n;++i){
            pre[i] = cardPoints[i] + pre[i-1];
        }
        if(k == n) return pre[n-1];//all elements case
        int max = Math.max(pre[k-1],pre[n-1] - pre[(n-k)-1]);//max(first k elemest,last k elements)
        int currSum = 0;
        for(int i = n-1,j = k-2;i>n-k && j >= 0;--i,--j){
            currSum += cardPoints[i] + pre[j];//take last element and first k-1 elements
            //iteratively take more elements from last and less elements from first
            max = Math.max(currSum,max);
            currSum -= pre[j];
        }
        return max;*/
        
        int n = cardPoints.length;
        int[] pre = new int[n+1];
        int[] suf = new int[n+1];
        
        for(int i = 1;i<=n;++i){
            pre[i] = cardPoints[i-1] + pre[i-1];
        }
        
        for(int i = n-1;i>=0;--i){
            suf[i] = cardPoints[i] + suf[i+1];
        }
        int max = 0;
        for(int i = 0;i<=k;++i){
            max = Math.max(max,pre[i] + suf[n - k + i]);
        }
        return max;
    }
}