class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,Map<Integer,Integer>> adjList = new HashMap<>();
        for(int[] time : times){
            if(adjList.get(time[0]) == null){
                adjList.put(time[0],new HashMap<>());
            }
            adjList.get(time[0]).put(time[1],time[2]);
        }
        boolean[] visited = new boolean[n+1];
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.add(new int[]{0,k});
        int res = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.remove();
            int node = curr[1];
            int dist = curr[0];
            if(visited[node]) continue;
            visited[node] = true;
            res = dist;
            n--;
            if(adjList.get(node) != null){
                for(int nextNode : adjList.get(node).keySet()){
                    pq.add(new int[]{dist + adjList.get(node).get(nextNode),nextNode});
                }
            }
        }
        return n == 0 ? res : -1;
    }
}