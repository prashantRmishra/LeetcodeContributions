class Solution {
    public int calculateMinimumHP(int[][] d) {
        int dp[][] = new int[d.length][d[0].length];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return  solve(d,0,0,dp);
    }
    public int solve(int[][] d, int i, int j, int[][] dp){
        if(i>d.length-1 || j>d[0].length-1) return Integer.MAX_VALUE;
        if (dp[i][j] != -1) return dp[i][j];
        if(i==d.length-1 && j == d[0].length-1) {
            return d[i][j] > 0 ? 1 : -d[i][j]+1;
        }
        
        int sum  = d[i][j];
        int right  = solve(d,i,j+1,dp);
        int down = solve(d,i+1,j,dp);
        int val = Integer.min(right,down)-sum;
        return dp[i][j] =  val<=0 ? 1 :val;
        
        
        
    }
}