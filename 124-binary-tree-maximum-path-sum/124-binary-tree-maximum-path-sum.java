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
    int max =Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }
    public int maxPath(TreeNode node){
        if(node==null) return 0;
        int left = Integer.max(0,maxPath(node.left));
        int right = Integer.max(0,maxPath(node.right));
        max = Integer.max(max,node.val + left+right);
        return node.val + Integer.max(left,right);
    }
}