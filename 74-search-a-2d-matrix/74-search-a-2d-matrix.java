class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;//column
        int m = matrix.length;//row
        
        int i=0;
        int j=n-1;
        while(i<m &&  j>=0){
            
            if(matrix[i][j]==target) return true;
            else if (matrix[i][j] > target) j--;
            else i++;
        } 
        return false;
    }
}