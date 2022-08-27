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
    public int widthOfBinaryTree(TreeNode root) {
        //we will use strivers approach for solving this problem
       
        int maxWidth = 0;
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();
        if(root== null) return 0;
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int first = 0;
            int last  =0;
            int minIndex  = q.peek().getValue();
            for(int i =0;i<size;i++){
                Pair<TreeNode,Integer> p = q.remove();
                TreeNode n = p.getKey();
                int index = p.getValue()-minIndex;
                if(i ==0) first = index;
                if(i ==size-1) last = index;
                if(n.left!=null) q.add(new Pair(n.left,2*index +1));
                if(n.right!=null) q.add(new Pair(n.right,2*index +2));
            }
            maxWidth = Integer.max(maxWidth,last-first +1);
            
        }
        return maxWidth;
    }
}