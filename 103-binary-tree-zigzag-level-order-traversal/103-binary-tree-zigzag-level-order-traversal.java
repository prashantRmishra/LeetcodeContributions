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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        boolean isForward = true;
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null ) {
        return list;
            }
        else if (root.left ==null && root.right == null ){
            List<Integer> l = new ArrayList<>();
            l.add(root.val);
            list.add(l);
            return list;
        }
        q.add(root);
        
        while(!q.isEmpty()){
            List<Integer> l = new ArrayList<>();
            int n = q.size();
            if(isForward){
                for(int i =0;i< n;i++){
                    TreeNode t = q.remove();
                    l.add(t.val);
                    if(t.left!=null) q.add(t.left);
                    if(t.right!=null) q.add(t.right);
                }
                isForward = !isForward;
                list.add(l);
            }
            else{
                for(int i =0;i< n;i++){
                    TreeNode t = q.remove();
                    l.add(t.val);
                    if(t.left!=null) q.add(t.left);
                    if(t.right!=null) q.add(t.right);
                }
                isForward = !isForward;
                Collections.reverse(l);
                list.add(l);
            }
            
        }
        return list;
    }
}