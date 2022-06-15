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
    List<Integer> list = new ArrayList<>();
    Queue<Integer> temp = new LinkedList<>();
    public TreeNode convertBST(TreeNode root) {
        //we know that inorder traversal of the bst will result in sorted array;
        inorder(root);
        for( int i =0;i< list.size();i++){
            temp.add(giveSum(list,i,list.size()));
        }
        System.out.println(list);
        System.out.println(temp);
        recreatingTree(root);
        return root;
    }
    public void inorder(TreeNode root){
        if(root == null) return ;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    public void recreatingTree(TreeNode root){
        if(root == null) return ;
        recreatingTree(root.left);
        root.val = temp.remove();
        recreatingTree(root.right);
    }
    public int giveSum(List<Integer> list, int start, int end){
        int sum = 0;
        for(int i = start;i<end;i++){
            sum+=list.get(i);
        }
        return sum;
    }
}