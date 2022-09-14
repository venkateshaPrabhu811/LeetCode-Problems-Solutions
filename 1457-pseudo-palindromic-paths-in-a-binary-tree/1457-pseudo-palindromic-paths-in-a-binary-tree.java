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
        int[] mask = new int[10];
        TreeNode temp = dfs(root,mask);
        return count;
    }
    private TreeNode dfs(TreeNode root,int[] mask){
        if(root == null) return null;
        ++mask[root.val];
        TreeNode left = dfs(root.left,mask);
        TreeNode right = dfs(root.right,mask);
        if(left == null && right == null){
            if(checkPermute(mask)) ++count;
        }
        --mask[root.val];
        return root;
    }
    private boolean checkPermute(int[] mask){
        int oddParity = 0;
        for(int i = 1;i<10;++i){
            if(mask[i] % 2 != 0) ++oddParity;
            if(oddParity  > 1) return false;
        }
        return true;
    }
}