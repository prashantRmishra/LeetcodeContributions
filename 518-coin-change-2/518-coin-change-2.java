class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount+1];
        for(int row[] : dp) Arrays.fill(row,-1);
        return allPossibleCombinations(coins.length-1,new ArrayList<>(),coins,dp,amount);
    }
    public int allPossibleCombinations(int index,List<Integer> list,int[] coins, int[][] dp,int amount){
        if(index==0){
            if(amount % coins[index]==0) {
                System.out.println(list);
                return  1;
            }
            return 0;
        }
        if(dp[index][amount]!=-1) return dp[index][amount];
        int take = 0;
        if(amount>=coins[index]){
            list.add(coins[index]);
            take = allPossibleCombinations(index,list,coins,dp,amount-coins[index]);
            list.remove(list.size()-1);
        }
       
        int dontTake = allPossibleCombinations(index-1,list,coins,dp,amount);
        return dp[index][amount] = take+dontTake;
    }
}