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
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0;i<inorder.length;++i){
            map.put(inorder[i],i);
        }
        return helper(0,preorder.length-1,0,inorder.length-1,preorder,inorder);
    }
    /*private TreeNode helper(int ptr,int start,int end,int[] preorder,int[] inorder){
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
    }*/
    
    private TreeNode helper(int preStart,int preEnd,int inStart,int inEnd,int[] preorder,int[] inorder){
        if(preStart > preEnd || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = map.get(preorder[preStart]);
        int numsleft = index - inStart;
        
        root.left = helper(preStart+1,preStart+numsleft,inStart,index-1,preorder,inorder);
        root.right = helper(preStart+numsleft+1,preEnd,index+1,inEnd,preorder,inorder);
        return root;
    } 
}