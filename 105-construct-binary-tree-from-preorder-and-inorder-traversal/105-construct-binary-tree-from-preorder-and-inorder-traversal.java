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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> in = new HashMap<>();
        for(int i =0;i<inorder.length;i++){
            in.put(inorder[i],i);
        }
        return generateTree(0,inorder.length-1,0,preorder.length-1,in,preorder);
    }
    public TreeNode generateTree(int inmin,int inmax,int pmin,int pmax,Map<Integer,Integer> in,int[] pre){
        if(inmin>inmax || pmin > pmax) return null;
        int val = pre[pmin];
        TreeNode node = new TreeNode(val);
        int rIndex  = in.get(val);
        //note:
        //for left subtree, inorder range will be inmin,rIndex-1
        //for right substrr, inorder range will be rIdnex+1,pmax
        //for left subtree, preorder range will be pmin+1, pmin+rIndex-inmin-1
        //for right subtree, preorder range will be pmin+rIndex-inmin +1,pmax
        node.left  = generateTree(inmin,rIndex-1,pmin+1,pmin+1+rIndex-inmin-1,in,pre);
        node.right = generateTree(rIndex+1,pmax,pmin+rIndex-inmin +1,pmax,in,pre);
        return node;
    }
}