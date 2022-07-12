// we have to find two subset where sum of both the subset is equal
// basically we have to find a subset where sum of all the elements of the subset is equals to the sum/2  where sum is total sum of all the elements in the array.
// This is because if one subset sum is sum/2, then there must be another subset whose sum is also sum/2 , hence sum/2 + sum/2 = sum of the array it self
// catch : if the sum of the array is odd then it can never be partitioned in two subset where sum of both the subset is same.
// hence the sum of the array has  to be even
// class Solution {
//     public boolean canPartition(int[] nums) {
//         int sum = 0;
//         for(int i : nums){
//             sum+=i;
//         }
//         if(sum%2!=0) return false;
//         int target = sum/2;
//         //now the problem has become very simple we have to find a subset whose sum is equals to target :)
//         // we will start from the lasat index;
//         return solve(nums,nums.length-1,target);
        
//     }
//     public boolean solve(int[] nums, int i, int target){
//         if(target == 0) return true;
//         if(i==0){
//             // if i ==0 it means we have to reached the last element or rather first element, now in order for it to return true the value at the index i should be target 
//             if(nums[i] == target) return true;
//             else return false;
//         }
//         boolean take = false; // initially its false because inorder to take or consider the current index the value at that index should be less than or equals to the target else whats the point of even exploring it anyway.
//         if(nums[i]<=target){
//             take = solve(nums,i-1,target-nums[i]); // since we are taking current index into consideration hence the target will be reduced by nums[index]
//         }
//         //don't take
//         boolean dontTake = solve(nums,i-1,target);
//         return take || dontTake; // if any of them  is true then we have found a subset where sum is equals to target
//     }
// }

// above sol is fine but it will lead to time limit exceeded issue
// Memoization top down approach
// there are two changing factors index and target hence we will be using 2d dp to solve 
// this
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum+=i;
        }
        if(sum%2!=0) return false;
        int target = sum/2;
        int dp[][] = new int[nums.length][target+1]; // as nums.length size will mean that index can range from 0 to nums.length-1 and target+1 size means that target value can range form 0 to target :)
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return solve(nums,nums.length-1,target,dp);
        
    }
    public boolean solve(int[] nums, int i, int target,int[][] dp){
        if(target == 0) return true;
        if(i==0){
            if(nums[i] == target) return true;
            else return false;
        }
        if(dp[i][target]!=-1) return dp[i][target]==1 ? true:false;
        boolean take = false;
        if(nums[i]<=target){
            take = solve(nums,i-1,target-nums[i],dp);
        }
        boolean dontTake = solve(nums,i-1,target,dp);
        dp[i][target] = (take || dontTake) ? 1 : 0;
        if(dp[i][target] ==1) return true;
        return false;
    }
}
