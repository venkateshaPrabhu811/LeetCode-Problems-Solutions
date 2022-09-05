/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        q.offer(root);
        res.add(new ArrayList<>());
        res.get(0).add(root.val);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> child = new ArrayList<>();
            for(int j = 0;j<size;++j){
                Node curr = q.remove();
                for(Node i : curr.children){
                    if(i == null) continue;
                    child.add(i.val);
                    q.add(i);
                }
            }
            if(child.size() > 0) res.add(child);
        }
        return res;
    }
}