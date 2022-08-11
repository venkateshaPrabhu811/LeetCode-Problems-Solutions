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
    public boolean isValidBST(TreeNode root) {
        
        //Iterative Solution using Stack
        //Inorder Traversal
        /*if(root == null) return true;
        TreeNode prev = null;
        Stack<TreeNode> stk = new Stack<>();
        while(root != null || !stk.isEmpty()){
            while(root != null){
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            if(prev != null && prev.val >= root.val) return false;
            prev = root;
            root = root.right;
        }
        return true;*/
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean helper(TreeNode root,long min,long max){
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return helper(root.left,min,root.val) && helper(root.right,root.val,max);
    }
}