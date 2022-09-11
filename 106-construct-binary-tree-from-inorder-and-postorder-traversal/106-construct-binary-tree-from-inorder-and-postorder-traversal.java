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
        Map<Integer,Integer> in = new HashMap<>();
        
        for(int i =0;i<inorder.length;i++) in.put(inorder[i],i);
       
        return generateTree(0,in.size()-1,0,postorder.length-1,in,postorder);
        
    }
    public TreeNode generateTree(int inmin, int inmax,int pomin,int pomax,Map<Integer,Integer> in, int[] po){
        if(inmin > inmax || pomin > pomax ) return null;
        int val = po[pomax];//last element of postorder is the root element
        TreeNode root = new TreeNode(val);
        int rIndex = in.get(val);
        root.left = generateTree(inmin,rIndex-1,pomin,pomin+rIndex-inmin-1,in,po);
        root.right = generateTree(rIndex+1,inmax,pomin+rIndex-inmin,pomax-1,in,po);
        return root;
        
        
    }
}