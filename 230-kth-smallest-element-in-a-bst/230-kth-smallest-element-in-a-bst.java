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
    int count =0;
    int kthSmallest = Integer.MAX_VALUE;;
    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root,k);
        return kthSmallest;
    }
    public void inorderTraversal(TreeNode node, int k ){
        if(node==null) return;
        inorderTraversal(node.left,k);
        count++;
        if(k==count) kthSmallest = node.val;
        if(kthSmallest!= Integer.MAX_VALUE) return ;
        inorderTraversal(node.right,k);
        //if(kthSmallest!= Integer.MAX_VALUE) return ;
        
    }
}