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
    public boolean isSymmetric(TreeNode root) {
        return preorder(root,root);
    }
    public boolean preorder(TreeNode node, TreeNode fode){
        if(node==null && fode ==null) return true;
        if(node==null && fode!=null || node!=null && fode==null || node.val!=fode.val) return false;
        return preorder(node.left,fode.right) && preorder(node.right,fode.left);
    }
}