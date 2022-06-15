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
        
        /*
        now lets take an example : 
        inorder of [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8] 
        will be : 0,1,2,3,4,5,6,7,8
        now for 0 there are 8 values that are greater that it so 0 will become : 0+1+2+3+4+5+6+7+8 = 36
        similarly 1 will become : 36 and so on 
finally greater result  : [36, 36, 35, 33, 30, 26, 21, 15, 8]
Thats what below code calculates
        */
        for( int i =0;i< list.size();i++){
            temp.add(giveSum(list,i,list.size())); 
        }
        // finally again do the inorder traversal and update the old value with new ones
        recreatingTree(root);
        // root will have updated values now 
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