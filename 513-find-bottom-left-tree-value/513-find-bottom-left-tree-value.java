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
    int level = 0;
    int temp = 0;
    int val = Integer.MIN_VALUE;
    public int findBottomLeftValue(TreeNode root) {
        if(root.left ==null && root.right ==null) return root.val;
        // first we will have to find out the level of the tree 
        // then we will reach to that level and return the left node.val of it.
        preorder(root,0);
        //System.out.println(level);
        preorder2(root,0);
        return val;
        
    }
    public void preorder2(TreeNode node,int l){
        if(node == null) return;
       
        if(l == level-1) {
            if(node.left!=null){
                 val = node.left.val;
                return;
            }
           
            else if(node.right!=null){
                val = node.right.val;
                return;
            }
         
        }
        
        preorder2(node.left,l+1);
        if(val!=Integer.MIN_VALUE) return;
        preorder2(node.right,l+1);
    }
    public void preorder(TreeNode node,int l){
        if(node == null ) return;
        System.out.println(node.val);
        level = Integer.max(level,l);
        preorder(node.left, l+1);
        preorder(node.right,l+1);
        
    }
}