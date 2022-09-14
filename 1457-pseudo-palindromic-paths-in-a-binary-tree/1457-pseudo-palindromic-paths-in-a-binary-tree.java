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
    int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root == null) return 0;
        TreeNode temp = dfs(root,0);
        return count;
    }
    private TreeNode dfs(TreeNode root,int mask){
        if(root == null) return null;
        mask ^= 1 << root.val;
        
        TreeNode left = dfs(root.left,mask);
        TreeNode right = dfs(root.right,mask);
        if(left == null && right == null){
            if((mask & (mask -1)) == 0) ++count;
        }
        return root;
    }
}