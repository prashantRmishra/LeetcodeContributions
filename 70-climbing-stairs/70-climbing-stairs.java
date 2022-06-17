class Solution {
    int dp[];
    public int climbStairs(int n) {
      
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]  = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    
    public int isPossible(int n){
        if(dp[n]!=-1) return dp[n];
        if(n == 0) {
            
            return 1;
        }
        if(n ==1 ) return 1;
     
        return isPossible(n-1) + isPossible(n-2);
    }
}