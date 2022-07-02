class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        return (int)((maxArea(horizontalCuts,h) * maxArea(verticalCuts,w))%1000000007);
    }
    public long maxArea(int[] cuts,int len){
        int cutsLen = cuts.length;
        long res = Math.max(len - cuts[cutsLen-1],cuts[0]);
        for(int i = 1;i<cutsLen;++i){
            res = Math.max(res,cuts[i] - cuts[i-1]);
        }
        return res;
        
    }
}