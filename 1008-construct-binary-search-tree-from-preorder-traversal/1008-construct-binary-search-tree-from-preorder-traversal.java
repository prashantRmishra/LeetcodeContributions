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
//for more idea see this https://www.youtube.com/watch?v=UmJT3j26t1I
class Solution {
    public TreeNode bstFromPreorder(int preorder[]){
        return generateBST(preorder, new int[]{0},Integer.MAX_VALUE); //0 indicates the current pointer of the element that needs to be inserted
        //Integer.MAX_VALUE is max bound
    }
    public TreeNode generateBST(int[] pre,int pointer[], int bound){
        if(pointer[0] > pre.length-1 || pre[pointer[0]] > bound) return null;
        TreeNode node = new TreeNode(pre[pointer[0]++]);// value at pointer has been added to the tree, now move to next value int the array
        node.left = generateBST(pre,pointer,node.val); // now node.val will become bound for all the 
        // elements to the left of node, as they can't be equal to or greater than node.val
        node.right = generateBST(pre,pointer,bound);//for the right subtree bound will remain same
        return node;
    }
    public TreeNode bstFromPreordero(int[] preorder) {
        int index =0;
        int sortedArray[] = new int[preorder.length];
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i< sortedArray.length;i++){
             sortedArray[i] = preorder[i];
             q.add(preorder[i]);
        }
        Arrays.sort(sortedArray);
        return createBst(0,sortedArray.length-1,q,sortedArray);
        
    }
    public TreeNode createBst(int start, int end, Queue<Integer> q,int[] sortedArray){
        if(start > end) return null;
        int rootVal = q.remove();
        TreeNode node = new TreeNode(rootVal);
        int mid = binarySearch(start,end,rootVal,sortedArray);
        node.left = createBst(start,mid-1,q,sortedArray);
        node.right = createBst(mid+1,end,q,sortedArray);
        return node;
    }
    public int binarySearch(int start, int end,int target, int[] arr){
        if(start > end) return -1;
        int mid  = start + (end-start)/2;
        if(arr[mid] == target) return mid;
        if(arr[mid] > target){
            return binarySearch(start,mid-1, target, arr);
        }
        return binarySearch(mid+1, end, target,arr);
    }
}