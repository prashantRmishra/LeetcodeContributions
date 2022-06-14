class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length-1);
    }
    int binarySearch(int[] nums,int x, int start, int end){
        if(start> end) return start;
        int mid = start + (end-start)/2;
        if(nums[mid] == x) return mid;
        else if(nums[mid] > x) return binarySearch(nums,x,start,mid-1);
        else return binarySearch(nums,x,mid+1,end);
    }
}