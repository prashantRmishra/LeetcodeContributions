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


/*
Points to take into consideration 
inpreorder : first element is the root element, and in
inorder  : everything left to the root will come in the left subtree and everything in
            the right of the root will come in the right subtree.
Example : preoder : 8,5,1,7,10,12
                    -
          inorder : 1,5,7,8,10,12
                          -
*/
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        
        Queue<Integer> preq = new LinkedList<>();
          Set<Integer> set = new TreeSet<>();
        
        // put all the preorder elements in the queue
        for(int i : preorder){
            preq.add(i);
        }
      
        // put all the preorder in TreeSet so that they will get sorted in ascending order,
        //which is nothing but inorder traversal of the same array 
        for(int i: preorder){
            set.add(i);
        }
        List<Integer> inorder  = new ArrayList<>(set); // put the set in the list
        
        return constructTree(preq,inorder,0,preorder.length-1);
    }
    
    public TreeNode constructTree(Queue<Integer> pre, List<Integer> in, int start,int end){
        
        if(start>end) return null;
        if(pre.isEmpty()) return null;
        
        int rootElement = pre.remove(); // remove or pop() (remember : we are removing the elements from the queue so that we don't use alredy used element in the construction of the root node) the top element
        //in the queue as it will be the root element
        TreeNode root = new TreeNode(rootElement); //create root
        int index = in.indexOf(rootElement); //find index of the same root element in the inorder list
        // as the left part of that index will become left subtree and right part of that index will become right subtree
        
        TreeNode left = constructTree(pre,in,start,index-1); // recursive call for left subtree
        TreeNode right = constructTree(pre,in,index+1,end); // recursive call for right subtree
        root.left = left;
        root.right = right;
        return root;
    }
}