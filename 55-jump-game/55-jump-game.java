class Solution {
    public boolean canJump(int[] nums) {
        
       // we will solve it using dp
        boolean[] dp = new boolean[nums.length];
        Arrays.fill(dp,true);
        return solve(nums,0,dp);
    }
    public boolean solve(int[] nums,int index, boolean[] dp){
        if(index == nums.length-1) return true;
        if(index>=nums.length) return false;
        if(dp[index]==false) return false;
        
        for(int i = index+1;i<=index+nums[index];i++){
            if(dp[i]){
                dp[i] = solve(nums,i,dp);
                if(dp[i]) return true;
            }
           
          
        }
        return false;
    }
}