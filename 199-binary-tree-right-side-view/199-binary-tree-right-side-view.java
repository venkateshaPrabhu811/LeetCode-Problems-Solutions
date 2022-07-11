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
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        if(root == null) return res;
        que.add(root);
        que.add(new TreeNode(101));
        while(que.peek().val != 101){
            TreeNode parent = que.poll();
            if(parent.left != null) que.offer(parent.left);
            if(parent.right != null) que.offer(parent.right);
            if(que.peek().val == 101){
                res.add(parent.val);
                que.poll();
                que.add(new TreeNode(101));
            }
        }
        return res;
    }
}