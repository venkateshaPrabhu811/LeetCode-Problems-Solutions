class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        int sum = 0;
        for(;res < heights.length-1;++res){
            int currJump = heights[res+1] - heights[res];
            if(currJump > 0)
                pq.add(currJump);
            if(pq.size() > ladders){
                sum += pq.poll();
            }
            if(sum > bricks) break;
        }
        return res;
    }
}