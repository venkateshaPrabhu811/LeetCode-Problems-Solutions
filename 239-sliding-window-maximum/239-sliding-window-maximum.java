class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*int n = nums.length;
        int[] res = new int[n-k+1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int index = 0;
        for(;index < k;++index){
            pq.add(nums[index]);
        }
        int resIndex = 0;
        res[resIndex] = pq.peek();
        for(;index < n;++index){
            if(nums[index - k] == pq.peek()){
                pq.poll();
            }
            pq.add(nums[index]);
            ++resIndex;
            res[resIndex] = pq.peek();
        }
        return res;*/
        int n = nums.length;
        int[] res = new int[n-k+1];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int index = 0;
        for(int i = 0;i<n;++i){
            while(!dq.isEmpty() && dq.peek() < i - k + 1)
                dq.poll();
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();
            dq.offer(i);
            if(i >= k-1)
                res[index++] = nums[dq.peek()];
        }
        return res;
    }
}