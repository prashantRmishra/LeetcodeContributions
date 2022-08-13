class Solution {
    String str = "";
    public String shortestCommonSupersequence(String str1, String str2) {
        int dp[][] = new int[str1.length()+1][str2.length()+1];
        
        for(int i=0;i<=str1.length();i++){
            dp[i][0] =0;
        }
        for( int i =0;i<=str2.length();i++){
            dp[0][i] = 0;
        }
        
        for( int i =1;i<=str1.length();i++){
            for(int j =1;j<=str2.length();j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else dp[i][j] = Integer.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        int p = str1.length(), q = str2.length();
        
        while(p>0 && q>0){
            if(str1.charAt(p-1) == str2.charAt(q-1)){
                str = str1.charAt(p-1)+ str;
                p--;
                q--;
                
            }
            else if(dp[p][q-1] > dp[p-1][q]){
                str = str2.charAt(q-1) + str;
                q--;
            }
            else {
                str = str1.charAt(p-1) + str;
                p--;
            }
        }
        
        while(p>0){
            str  = str1.charAt(p-1)+ str;
            p--;
        }
        while(q>0){
            str = str2.charAt(q-1) +  str;
            q--;
        }
        return str;
    }
}