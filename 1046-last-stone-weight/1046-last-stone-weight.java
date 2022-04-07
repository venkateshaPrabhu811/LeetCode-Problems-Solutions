class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i<stones.length;i++){
            pq.offer(stones[i]);
        }
        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            if(first != second) pq.offer(first - second);
        }
        return pq.size() > 0 ? pq.poll() : 0;
    }
}