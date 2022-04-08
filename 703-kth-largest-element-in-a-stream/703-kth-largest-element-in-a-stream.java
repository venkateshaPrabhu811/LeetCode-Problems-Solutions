class KthLargest {
    PriorityQueue<Integer> pq;
    static int size;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        for(int i = 0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        size = k;
    }
    
    public int add(int val) {
        pq.offer(val);
        while(pq.size() > size){
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */