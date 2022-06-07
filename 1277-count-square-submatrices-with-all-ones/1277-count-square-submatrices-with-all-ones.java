class Solution {
    public int countSquares(int[][] matrix) {
        //we will solve it using dynamic programmming
        //for reference go through : https://www.youtube.com/watch?v=Z2h3rkVXPeQ
        int[][] dp = new int[matrix.length][matrix[0].length];
        int count =0;
        for(int i =0;i<matrix[0].length;i++){
           
            dp[0][i] = matrix[0][i];
            count += dp[0][i];
        }
        
        for(int j = 1;j<matrix.length;j++){
            dp[j][0] = matrix[j][0];
            count+=dp[j][0];
        }
        for(int i =1;i<matrix.length;i++){
            for(int j =1;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    dp[i][j] = 1+Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                }
                count+=dp[i][j];
            }
        }
        return count;
    }
}