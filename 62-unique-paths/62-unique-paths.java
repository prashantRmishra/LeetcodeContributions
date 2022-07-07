class Solution {
    int count  = 0;
    public int uniquePaths(int m, int n) {
        int[][] grid = new int [m][n];
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
      for(int i =0;i<grid.length;i++){
          for(int j =0;j<grid[0].length;j++){
              int left = 0, up = 0;
              if(i== 0 && j ==0) dp[0][0] =1;
              else {
                  if(j>0) left = dp[i][j-1];
                  if(i>0) up = dp[i-1][j];
                  dp[i][j] = left + up;
              }
          }
          
      }
        return dp[m-1][n-1];
    }
}

/*
// Memoization solution
class Solution {
    int count  = 0;
    public int uniquePaths(int m, int n) {
        int[][] grid = new int [m][n];
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(grid,0,0,dp);
        
    }
    public int solve(int[][] grid , int i, int j,int[][] dp){
        
        if(i == grid.length-1 && j == grid[0].length-1){
            return 1;
        }
        
        if(i<0 || i>= grid.length || j<0 || j>=grid[0].length){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        
        int left = solve(grid,i+1,j,dp);
        int right = solve(grid,i,j+1,dp);
        return dp[i][j] = left+right;
    }
}*/