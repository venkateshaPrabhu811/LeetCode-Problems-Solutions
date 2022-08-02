class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //Brute Force - Heap
        /*PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = matrix.length;
        for(int i = 0;i<n;++i){
            for(int j = 0;j<n;++j){
                pq.offer(matrix[i][j]);
                if(pq.size() > k){
                    pq.poll();
                }
            }
        }
        return pq.peek();*/
        
        //Heap Another Approach
        /*int n = matrix.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        
        for(int i = 0;i<Math.min(n,k);++i){
            pq.offer(new int[]{matrix[i][0],i,0});
        }
        int ans = -1;
        for(int i = 1;i<=k;++i){
            int[] top = pq.poll();
            int r = top[1];
            int c = top[2];
            ans = top[0];
            if(c + 1 < n) pq.offer(new int[]{matrix[r][c+1],r,c+1});
        }
        return ans;*/
        
        //Binary Search
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        while(low < high) {
            int mid = low + (high - low) / 2;
            int count = 0,  j = n - 1;
            for(int i = 0; i < n; ++i) {
                while(j >= 0 && matrix[i][j] > mid) --j;
                count += (j + 1);
            }
            if(count < k) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}