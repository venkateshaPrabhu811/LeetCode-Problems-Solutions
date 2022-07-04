class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candy = new int[n];
        Arrays.fill(candy,1);
        for(int i = 1;i<n;++i){
            if(ratings[i-1] < ratings[i]) candy[i] = candy[i-1] + 1;
        }
        for(int i = n-2;i>=0;--i){
            if(ratings[i+1] < ratings[i]) candy[i] = Math.max(candy[i],candy[i+1] + 1);
        }
        int count = 0;
        for(int i = 0;i<n;++i){
            count += candy[i];
        }
        return count;
    }
}