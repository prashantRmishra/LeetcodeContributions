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
    int maxDepth = -1;  
    
    public int maxDepth(TreeNode root) {
        preorder(root,0);
        
        return maxDepth+1;
    }
    public void preorder(TreeNode node, int depth){
        if(node==null) return ;
        if(maxDepth < depth){
            maxDepth =  depth;
        }
        preorder(node.left,depth+1);
        preorder(node.right,depth+1);
    }
}