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
    public List<List<Integer>> levelOrder(TreeNode root) {
        /*Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        que.offer(root);
        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0;i<size;++i){
                TreeNode parent = que.poll();
                if(parent.left != null) que.offer(parent.left);
                if(parent.right != null) que.offer(parent.right);
                temp.add(parent.val);
            }
            res.add(temp);
        }
        return res;*/
        
        List<List<Integer>> res = new LinkedList<>();
        dfs(res,root,0);
        return res;
    }
    private void dfs(List<List<Integer>> res,TreeNode root,int height){
        if(root == null) return;
        if(height >= res.size()){
            res.add(new LinkedList<>());
        }
        res.get(height).add(root.val);
        dfs(res,root.left,height+1);
        dfs(res,root.right,height+1);
    }
}