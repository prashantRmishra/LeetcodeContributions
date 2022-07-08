class Solution {
    int min = Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
    return solve(grid,0,0,dp);
        
    }
    public int solve(int[][] g, int i , int j,int dp[][]){
        if(i>g.length-1 || j>g[0].length-1) return Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        if(i==g.length-1 && j == g[0].length-1){
            return g[i][j];
        }
        
        
        int  down = solve(g,i+1,j,dp);
        int right = solve(g,i,j+1,dp);
        return dp[i][j] = g[i][j]+Integer.min(down,right);
        
    }
}