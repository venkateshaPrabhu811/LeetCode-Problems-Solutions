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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0,0,inorder.length-1,preorder,inorder);
    }
    private TreeNode helper(int ptr,int start,int end,int[] preorder,int[] inorder){
        if(ptr == preorder.length || start > end) return null;
        int index = 0;
        for(int i = start;i<=end;++i){
            if(inorder[i] == preorder[ptr]){
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[ptr]);
        root.left = helper(ptr+1,start,index-1,preorder,inorder);
        root.right = helper(ptr + index - start + 1,index+1,end,preorder,inorder);
        return root;
    }
    
}