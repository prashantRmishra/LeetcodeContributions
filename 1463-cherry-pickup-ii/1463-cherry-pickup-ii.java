class Solution {
    // we will use 3dp for optimizing this problem
    public int cherryPickup(int[][] grid) {
        // since both the robots are moving simultaneously hence they will 
        // be at the same row all the time.
        // hence only one row index is needed .
        // j1 is for robot1 and j2 is for robot2
        int dp[][][] = new int[grid.length][grid[0].length][grid[0].length];
        for(int i =0;i<dp.length;i++){
            for(int matrix[] : dp[i]){
                Arrays.fill(matrix,-1);
            }
        }
        return solve(grid,0,0,grid[0].length-1,dp);
    }
    public int solve(int[][] grid, int i,int j1,int j2,int [][][] dp){
        if(j1<0 || j2<0 || j1>=grid[0].length || j2 >= grid[0].length) return 0;
        if(i == grid.length-1) {
            // here are two cases , either both robot1 and robot2 have arrived at the same cell in the last row or different cells in the last row
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        int maximum = 0;
        /*
        for every move of robot1 robot2 has the chance to move either rightdiagonal or down or left diagonal
        hence the below code will run for 9 times 
        3*3
        */
        for(int a = j1-1;a<=j1+1;a++){
            for(int b = j2-1;b<=j2+1;b++){
                if(j1==j2) { // since j1 and j2 are same that means robot1 and robot2 are at the same cell . Hence take current cell value + solve() again we can take index j1 or j2 any one as the value at the cell is same
                    maximum =Integer.max(maximum,grid[i][j1]+solve(grid,i+1,a,b,dp));
                }
                else {
                    maximum =Integer.max(maximum,  grid[i][j1]+grid[i][j2] + solve(grid,i+1,a,b,dp));
                }
            }
        }
        return dp[i][j1][j2] = maximum;
    }
}