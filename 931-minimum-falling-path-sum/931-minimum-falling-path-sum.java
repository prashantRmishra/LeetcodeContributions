//minimum falling path sum : Using Memoization : top down approach

class Solution {
    int min = Integer.MAX_VALUE;
    public int minFallingPathSum(int[][] matrix) {
       // as we have find the smallest distance from any of the element in the first row
        //hence iterate through all the elements in the first row
        
        for(int i = 0;i<matrix[0].length;i++){
            //create a dp arrays for all the starting point in the first row and fill it up 
            // with -1 values 
            int dp[][] = new int[matrix.length][matrix[0].length];
            for(int row[]: dp){
                Arrays.fill(row,-1);
            }
            
            min  = Integer.min(min,solve(matrix,0,i,dp));
        }  
        return min;
    }
    int solve(int[][] matrix, int i, int j , int[][] dp){
        //base cases
        if(i>=matrix.length || j>=matrix[0].length || j<0) return Integer.MAX_VALUE;
        
        if(dp[i][j]!=-1) return dp[i][j];
        // if last row is reached then just return the element at i,j
        if(i==matrix.length-1) return matrix[i][j];
        
        // find the smallest distance to reach last row from the current element in the matrix.
        return dp[i][j] = matrix[i][j] + 
           
            Integer.min(
             //down                            // left                    //right
            solve(matrix,i+1,j,dp),Integer.min(solve(matrix,i+1,j-1,dp),solve(matrix,i+1,j+1,dp))
            );
           
           
    }
}