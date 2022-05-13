/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        
        if(root.left != null){
            if(root.right != null) root.left.next = root.right; //both children present
            else root.left.next = findPair(root);//checking next subtree of same level
        }
        if(root.right != null){
            root.right.next = findPair(root);//when processing right node we need to check
                                                //whether there is same level subtree or not
        }
        root.right = connect(root.right);//recursive calls
        root.left = connect(root.left);
        return root;
    }
    private Node findPair(Node root){
        while(root.next != null){
            root = root.next;//checking the neighbours
            if(root.left != null) return root.left;
            if(root.right != null) return root.right;
        }
        return null;
    }
}