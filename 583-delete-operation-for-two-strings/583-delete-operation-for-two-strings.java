class Solution {
    public int minDistance(String word1, String word2) {
        // we will have to use dynamic programming for this we will
        // find the largest common substring among the two strings and substract it from the length of 
        // the two strings and finally we will add the substractions 
        // there are two indexes that we need to keep in mind 
        // i for word1 and j for word2
        //lets create a momoization for this
        int m = word1.length(),n = word2.length();
        int[][] dp = new int[m+1][n+1];
        int result =0;
        for(int i =0;i<=m;i++){
            for(int j =0;j<=n;j++){
                if(i==0 || j==0) dp[i][j] = 0;
                else if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    
                }
                else dp[i][j] = Integer.max(dp[i-1][j],dp[i][j-1]);
            }
        }
       // System.out.println(result);
        return n+m - 2*dp[m][n];
    }
}