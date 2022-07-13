// recursive solution this will lead to tle
// class Solution {
//     public boolean isInterleave(String s1, String s2, String s3) {
//         return solve(s1,s2,s3,0,0);
//     }
//     public boolean solve(String s1, String s2,String s3, int i ,int j){
//         if(i==s1.length() && j == s2.length()) return true;
        
        
        
//         if(i<s1.length() && s1.charAt(i)==s3.charAt(i+j) && solve(s1,s2,s3,i+1,j)) 
//             return true;
//         if(j<s2.length() && s2.charAt(j)==s3.charAt(i+j) && solve(s1,s2,s3,i,j+1))
//             return true; 
//         return false;
//     }
// }

//dp memoization solution 
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // there are two changing factors here index of s1 and s2
        // we will need dp of size 2
        if((s1.length() + s2.length() )!= s3.length()) return false;
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        for(int row[]: dp) Arrays.fill(row,-1);
        return solve(s1,s2,s3,0,0,dp);
    }
    public boolean solve(String s1, String s2,String s3, int i ,int j,int[][] dp){
        if(i==s1.length() && j == s2.length()) return true;
        if(dp[i][j]!=-1) return dp[i][j]==1; // 1 will mean that index i and index j of s1 and s2 have matched with index i+j of s3 and the result has been stored as 1 hence no need to re-compute the same;
        
        
        boolean left =i<s1.length() && s1.charAt(i)==s3.charAt(i+j) && solve(s1,s2,s3,i+1,j,dp);
        boolean right  =j<s2.length() && s2.charAt(j)==s3.charAt(i+j) && solve(s1,s2,s3,i,j+1,dp);
        dp[i][j] = left || right ? 1 : 0;
        return dp[i][j] ==1 ? true : false;
    }
}