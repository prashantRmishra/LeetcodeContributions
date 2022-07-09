class Solution {
    int min = Integer.MAX_VALUE;
    public int minFallingPathSum(int[][] matrix) {
       
        for(int i = 0;i<matrix[0].length;i++){
           int dp[][] = new int[matrix.length][matrix[0].length];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
            min  = Integer.min(min,solve(matrix,0,i,dp));
        }  
        return min;
    }
    int solve(int[][] matrix, int i, int j , int[][] dp){
      
        if(i>=matrix.length || j>=matrix[0].length || j<0) return Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        if(i==matrix.length-1) return matrix[i][j];
        
        return dp[i][j] = matrix[i][j] + 
           
            Integer.min(
             //down
            solve(matrix,i+1,j,dp),
                        Integer.min(
                             //left diagonal
                            solve(matrix,i+1,j-1,dp),
                                     //right diagonal
                                   solve(matrix,i+1,j+1,dp)
                        )
                       );
           
           
    }
}