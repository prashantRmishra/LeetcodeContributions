class Solution {
    String str = "";
    public String shortestCommonSupersequence(String str1, String str2) {
        int dp[][] = new int[str1.length()+1][str2.length()+1];
       // for(int row[] : dp) Arrays.fill(row,-1);
        String result ="";
        //int len = lcsString(str1.length()-1, str2.length()-1,str1,str2,dp);
        //System.out.println(str);
        
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
        // for( int i =0;i<dp.length;i++){
        //     Arrays.stream(dp[i]).forEach(System.out::print);
        //     System.out.println();
        // }
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
        //System.out.println(str);
        // if(str1.indexOf(str)==0){
        //     result = str+ str1.replace(str,"");
        // }
        // else {
        //     result = str1.replace(result,"") + str;
        // }
        // if(str2.indexOf(str)==0){ 
        //     result = result+ str2.replace(str,"");
        // }
        // else {
        //     result = str2.replace(str,"") + result;
        // }
        return str;
    }
    public int lcsString(int m, int n, String a, String b, int[][] dp){
        if(m<0 || n<0) return 0;
        
        if(dp[m][n]!=-1) return dp[m][n];
        if(a.charAt(m) == b.charAt(n)){
            return dp[m][n] = 1 + lcsString(m-1,n-1,a,b,dp);
        }
        else return dp[m][n] = 0 + Integer.max(lcsString(m-1,n,a,b,dp),lcsString(m,n-1,a,b,dp));
    }
}