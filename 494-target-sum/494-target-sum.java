class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // we will be using bottom-up approach for solving this problem
        return find(0,0,target,nums);
    }
    public int find(int index,int sum, int target, int[] nums){
        if(index>=nums.length){
            if(sum==target) return 1;
            return 0;
        }
        //we can take + for current index element
        int takePlus = find(index+1,sum+nums[index],target,nums);
        int takeMinus = find(index+1,sum-nums[index],target,nums);
        return takePlus + takeMinus;
    }
}