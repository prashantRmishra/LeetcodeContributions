class Solution {
    public boolean canJump(int[] nums) {
        
       // we will solve it using dp
        boolean[] dp = new boolean[nums.length];
        /*
        Fill the dp indices with true , as true will tell us that this
        index has not been explored. And if after the exploration this index is still true it will mean that we can reach the last index from current index*/
        Arrays.fill(dp,true); 
        return solve(nums,0,dp);
    }
    public boolean solve(int[] nums,int index, boolean[] dp){
        // base cases
        if(index == nums.length-1) return true;
        if(index>=nums.length) return false;
        if(dp[index]==false) return false; // this means that this index has been explored and it does not lead to the last index
        
        // at given index i we jump to i+1 or i+2 .... till i+k <=i+nums[i];
        /*
        Example :[2,3,1,1,4] 
        if i =0, nums[i] = 2
        we can jump to i+1 i.e. 0+1 (less than i+nums[i] which is 2) or 0+2 (which is equals to 2) */
        for(int i = index+1;i<=index+nums[index];i++){
            if(dp[i]){ // traverse only if its true, means its has not been traversed 
                dp[i] = solve(nums,i,dp);
                // even after traversal if it comes as true , it will mean that last index is reachable from this index.
                if(dp[i]) return true;
            }
           
          
        }
        return false; // return false if the last index is not reachable.
    }
}