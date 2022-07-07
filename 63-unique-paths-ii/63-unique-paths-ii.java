class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return solve(obstacleGrid,0,0,dp);
    }
    int solve(int grid[][], int i, int j, int dp[][]){
        if(i >=grid.length || j>=grid[0].length || grid[i][j] ==1) return 0;
        if(i ==grid.length-1 && j == grid[0].length-1) return 1;
        
        if(dp[i][j]!=-1) return dp[i][j];
        int right = solve(grid,i,j+1,dp);
        int down = solve(grid,i+1,j,dp);
        return dp[i][j] = right+down;
    }
}