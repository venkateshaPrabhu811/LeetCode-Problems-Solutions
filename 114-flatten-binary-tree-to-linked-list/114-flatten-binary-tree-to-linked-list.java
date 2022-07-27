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
    public void flatten(TreeNode root) {
        // helper(root,null);
        //Without space
        while(root != null){
            if(root.left != null){
                TreeNode prev = root.left;
                while(prev.right != null){
                    prev = prev.right;
                }
                prev.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
    //With Stack Space
    /*private TreeNode helper(TreeNode root,TreeNode prev){
        if(root == null) return prev;
        
        TreeNode right = helper(root.right,prev);
        TreeNode left = helper(root.left,right);
        root.right = left;
        root.left = null;
        return root;
    }*/
}