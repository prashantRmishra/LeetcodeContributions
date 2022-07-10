class Solution {
    public int jump(int[] nums) {
        if(nums.length==1)return 0;
        int dp[] =new int[nums.length];
        Arrays.fill(dp,10001);
        return solve(nums,0,dp);
    }
    int solve(int[] nums,int index, int dp[]){
        if(index==nums.length-1) return 0;
        if(index>=nums.length)return 10001;
        if(dp[index]!=10001) return dp[index];
        
        for(int i = index+1;i<=index+nums[index] ;i++){
                dp[index] = Integer.min(dp[index],1+solve(nums,i,dp));
            //System.out.println("index is "+index+" val is "+dp[index]);
        }
        return dp[index];
    }
}