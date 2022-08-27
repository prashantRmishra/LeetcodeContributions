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
    public TreeNode bstFromPreorder(int[] preorder) {
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