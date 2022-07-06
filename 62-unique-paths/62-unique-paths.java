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
}