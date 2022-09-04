/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,List<NodeInfo>> map = new TreeMap<>();
        Queue<NodeInfo> q = new LinkedList<>();
        
        q.add(new NodeInfo(root,0,0));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;++i){
                NodeInfo temp = q.remove();
                List<NodeInfo> list = map.getOrDefault(temp.level,new ArrayList<>());
                list.add(temp);
                map.put(temp.level,list);
                
                if(temp.node.left != null){
                    q.offer(new NodeInfo(temp.node.left,temp.level-1,temp.depth+1));
                }
                if(temp.node.right != null){
                    q.offer(new NodeInfo(temp.node.right,temp.level+1,temp.depth+1));
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        map.forEach((levelNo,list) -> {
            Collections.sort(list,new NodeComparator());
            
            List<Integer> currLevel = new ArrayList<>(list.size());
            for(NodeInfo n : list){
                currLevel.add(n.node.val);
            }
            res.add(currLevel);
        });
        return res;
    }
}
class NodeInfo{
    TreeNode node;
    int level;
    int depth;
    NodeInfo(TreeNode node,int level,int depth){
        this.node = node;
        this.level = level;
        this.depth = depth;
    }
}
public class NodeComparator implements Comparator<NodeInfo>{
    public int compare(NodeInfo a,NodeInfo b){
        if(a.depth < b.depth) return -1;
        else if(a.depth > b.depth) return 1;
        else return a.node.val - b.node.val;
    }
}