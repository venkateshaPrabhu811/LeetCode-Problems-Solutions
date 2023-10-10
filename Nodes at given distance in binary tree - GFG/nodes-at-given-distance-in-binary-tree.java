//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution
{
    static Node start;
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        HashMap<Node,Node> parent = new HashMap<>();
        start = null;
        addParent(null,root,parent,target);
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        HashSet<Node> hs = new HashSet<>();
        hs.add(start);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(level == k){
                break;
            }
            while(size-- > 0){
                Node par = q.poll();
                if(par.left != null && !hs.contains(par.left)){
                    hs.add(par.left);
                    q.add(par.left);
                }
                if(par.right != null && !hs.contains(par.right)){
                    q.add(par.right);
                    hs.add(par.right);
                }
                Node prev = parent.get(par);
                if(prev != null && !hs.contains(prev)){
                    q.add(prev);
                    hs.add(prev);
                }
            }
            ++level;
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            res.add(q.poll().data);
        }
        Collections.sort(res);
        return res;
    }
    public static void addParent(Node prev,Node root,HashMap<Node,Node> parent,int target){
        if(root == null) return;
        parent.put(root,prev);
        if(start == null && root.data == target) start = root;
        addParent(root,root.left,parent,target);
        addParent(root,root.right,parent,target);
    }
};