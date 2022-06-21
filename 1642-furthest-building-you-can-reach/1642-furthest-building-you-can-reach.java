class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int res = 0;res < heights.length-1;++res){
            int currJump = heights[res+1] - heights[res];
            if(currJump > 0)
                pq.add(currJump);
            if(pq.size() > ladders){
                bricks -= pq.poll();
            }
            if(bricks < 0) return res;
        }
        return heights.length-1;
    }
}