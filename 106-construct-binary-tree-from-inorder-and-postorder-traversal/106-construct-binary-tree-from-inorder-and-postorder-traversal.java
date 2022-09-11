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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> in = new ArrayList<>();
        List<Integer> po = new ArrayList<>();
        for(int i: inorder) in.add(i);
        for(int i: postorder) po.add(i);
        return generateTree(0,in.size()-1,0,po.size()-1,in,po);
        
    }
    public TreeNode generateTree(int inmin, int inmax,int pomin,int pomax,List<Integer> in, List<Integer> po){
        if(inmin > inmax || pomin > pomax ) return null;
        int val = po.get(pomax);//last element of postorder is the root element
        TreeNode root = new TreeNode(val);
        int rIndex = in.indexOf(val);
        root.left = generateTree(inmin,rIndex-1,pomin,pomin+rIndex-inmin-1,in,po);
        root.right = generateTree(rIndex+1,inmax,pomin+rIndex-inmin,pomax-1,in,po);
        return root;
        
        
    }
}