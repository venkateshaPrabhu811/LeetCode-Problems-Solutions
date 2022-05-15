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
    int maxLevel = 0;
    int ansSum = 0;
    public int deepestLeavesSum(TreeNode root) {
        int currLevel = 0;
        dfs(currLevel,root);
        return ansSum;
    }
    private void dfs(int currLevel,TreeNode root){
        if(root == null) return;
        if(currLevel > maxLevel){
            ansSum = root.val;
            maxLevel = currLevel;
        }
        else if(currLevel == maxLevel){
            ansSum += root.val;
        }
        dfs(currLevel + 1,root.left);
        dfs(currLevel + 1,root.right);
    }
}