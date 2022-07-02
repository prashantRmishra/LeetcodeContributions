class Solution {
    public int rob(int[] nums) {
        //we can solve it using tabulation dp with memory optimization
        //tabulation is bottom up approach 
        int prev  = nums[0];
        int prevOfPrev = 0;// initialy
        for(int i =1;i<nums.length;i++){
            int take = nums[i];
            if(i>1) take+=prevOfPrev;
            int dontTake = 0 + prev;
            int currentVal = Integer.max(take,dontTake);
            prevOfPrev = prev;
            prev = currentVal;
        }
        return prev;
    }
}