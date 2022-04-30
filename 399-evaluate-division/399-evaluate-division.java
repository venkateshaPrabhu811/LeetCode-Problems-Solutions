class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Map<String,Double>> graph = makeGraph(equations,values);
        double[] ans = new double[queries.size()];
        for(int i = 0;i<queries.size();i++){
            ans[i] = dfs(graph,queries.get(i).get(0),queries.get(i).get(1),new HashSet<>());
        }
        return ans;
    }
    public Map<String,Map<String,Double>> makeGraph(List<List<String>> equations, double[] values){
        Map<String,Map<String,Double>> graph = new HashMap<>();
        String src,dest;
        for(int i = 0;i<equations.size();i++){
            src = equations.get(i).get(0);
            dest = equations.get(i).get(1);
            graph.putIfAbsent(src,new HashMap<>());
            graph.get(src).put(dest,values[i]);
            graph.putIfAbsent(dest,new HashMap<>());
            graph.get(dest).put(src,1/values[i]);
        }
        return graph;
    }
    public double dfs(Map<String,Map<String,Double>> graph,String src,String dest,Set<String> visited){
        if(graph.get(src) == null) return -1.0;
        if(graph.get(src).containsKey(dest)){
            return graph.get(src).get(dest);
        }
        visited.add(src);
        for(Map.Entry<String,Double> entry : graph.get(src).entrySet()){
            if(!visited.contains(entry.getKey())){
                double weight = dfs(graph,entry.getKey(),dest,visited);
                
                if(weight != -1){
                    return entry.getValue()*weight;
                }
            }
        }
        return -1.0;
    }
}