class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for(int i = 0;i<n;i++){
            if(color[i] == 1 || color[i] == -1) continue;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            color[i] = 1;
            while(!q.isEmpty()){
                int parent = q.peek();
                q.remove();
                for(int child : graph[parent]){
                    if(color[child] == 0){
                        color[child] = -color[parent];
                        q.add(child);
                    }
                    else{
                        if(color[child] == color[parent]) return false;
                    }
                }
            }
        }
        return true;
    }
}