
//intuition
/*
normal or brute force way: generate all possible subsequences and find the largest subsequence that is palindrome;
optimal approach : 
Using Logic of longest common subsequence;
example : if s = bbbab, lets reverse it as r = babbb
now the we can perform longest common subsequence to get result as 3 (bbb) and that will be the required result;

*/
class Solution {
    public int longestPalindromeSubseq(String s) {
        //bottom up approach
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        String r= sb.reverse().toString();
        int dp[][] = new int[s.length()][r.length()];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        return longestPalindromicSubsequence(s.length()-1,r.length()-1,s,r,dp);
    }
    public int longestPalindromicSubsequence(int i,int j, String a, String b,int dp[][]){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j)){
           return dp[i][j] = 1 + longestPalindromicSubsequence(i-1,j-1,a,b,dp);
        }
        return dp[i][j]= 0 + Integer.max(longestPalindromicSubsequence(i,j-1,a,b,dp),
                              longestPalindromicSubsequence(i-1,j,a,b,dp));
    }
}