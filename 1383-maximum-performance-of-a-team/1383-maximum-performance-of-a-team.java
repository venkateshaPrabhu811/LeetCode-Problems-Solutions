class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineers = new int[n][2];
        for(int i = 0;i<n;++i){
            engineers[i] = new int[]{speed[i],efficiency[i]};
        }
        Arrays.sort(engineers,(a,b) -> b[1] - a[1]);
        long total = 0,team = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] engineer : engineers){
            if(pq.size() == k) team -= pq.poll();
            pq.add(engineer[0]);
            team += engineer[0];
            total = Math.max(total,team*engineer[1]);
        }
        return (int)(total % 1000000007);
    }
}