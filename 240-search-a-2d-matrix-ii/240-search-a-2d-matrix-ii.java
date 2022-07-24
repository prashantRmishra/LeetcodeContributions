class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean isPresent = false;
        for(int i  = 0 ;i< matrix.length;i++){
            //takout individual rows of the matrix and do binary search to check if the target value is present in that row or not 
            int index  = binarySearch(matrix[i],0,matrix[0].length-1,target);
            if(index!=-1) return true;
        }
        return false;
    }

    int binarySearch(int[] a,int l, int r,int x){
        if(r>=l){
            int mid = l + (r-l)/2;
            if(a[mid] ==x) return mid;
            else if(a[mid] < x){
                return binarySearch(a,mid+1,r,x);
            }
            else if(a[mid]  > x) {
                return binarySearch(a,l,mid-1,x);
            }
           
        }
        return -1;
        
    }
}