class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
         // we will start with the last index if its a match then we will decrement both the index
        //else we will decrement text1 index keeping text2 index same and in second method call we will decrement text2 index keeping the text1 index same 
        // by this we will cover all the possibility
        // and we will be  able to get substring with the largest length common in both the Strings
        // lets optimize with dp
        int dp[][] = new int[text1.length()][text2.length()];
        for(int row[]: dp) Arrays.fill(row,-1);
        return findLcsLength(text1,text2,text1.length()-1,text2.length()-1,dp);
    }
    public int findLcsLength(String a, String b, int i,int j,int dp[][]){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i) ==b.charAt(j)){
            return dp[i][j] =  1 + findLcsLength(a,b,i-1,j-1,dp);
        }
        else {
            return dp[i][j]= 0+Integer.max(findLcsLength(a,b,i-1,j,dp),findLcsLength(a,b,i,j-1,dp));
        }
        
    }
}