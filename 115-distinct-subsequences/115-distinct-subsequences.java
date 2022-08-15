class Solution {
    public int numDistinct(String s, String t) {
        // we will use little bit of backtracking here 
        int dp[][] = new int[s.length()][t.length()];
        for(int row[] : dp) Arrays.fill(row, -1);
        return distinctCount(s,t,s.length()-1,t.length()-1,dp);
    }
    public int distinctCount(String s, String t, int i,int j,int dp[][]){
        //base case
        if(i<0 && j<0) return 1;
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            // so basically if its a, match , we will either reduce s and t index both or we will just reduce the index of  s only.
            // in both the case we will return the sum of values that we get.
            return dp[i][j]= distinctCount(s,t,i-1,j-1,dp) + distinctCount(s,t,i-1,j,dp);
        }
        else{
            // else if its not a match we will have to reduce the s string index so 
            //as to reach to an index of s where s.charAt(i) == t.charAt(j);
            return dp[i][j] = distinctCount(s,t,i-1,j,dp);
        }
    }
}