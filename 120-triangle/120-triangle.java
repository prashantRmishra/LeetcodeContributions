class Solution {
    Integer dp[][] = null;
    public int minimumTotal(List<List<Integer>> triangle) {
        // we will use dynamic programming to solve this problem 
        int n = triangle.size();
         dp = new Integer[n][n];
        return findMinPath(triangle,0,0);
    }
    int findMinPath(List<List<Integer>> t, int currentRow, int startIndex){
        if(dp[currentRow][startIndex]!=null) return dp[currentRow][startIndex];
        int result = t.get(currentRow).get(startIndex);
        
        if(currentRow < t.size()-1)
        result+=Math.min(findMinPath(t,currentRow+1,startIndex)
                  ,findMinPath(t,currentRow+1,startIndex+1));
        return dp[currentRow][startIndex] = result;
    }
}