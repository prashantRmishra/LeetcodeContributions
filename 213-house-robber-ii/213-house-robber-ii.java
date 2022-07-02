class Solution {
    public int rob(int[] nums) {
        if(nums.length ==1) return nums[0];
        int arr1[] = new int[nums.length-1];
        int arr2[] = new int[nums.length-1];
        int p=0,k=0;
        for(int i =0;i<nums.length-1;i++){
            arr1[i] = nums[i];
           
        }
        for(int i =1;i<nums.length;i++){
            arr2[i-1] = nums[i];
           
        }
        return Integer.max(getMaxMoney(arr1),getMaxMoney(arr2)); 
    }
    int getMaxMoney(int nums[]){
        //tabulation approach bottom up 
        int prev = nums[0];
        int prevOfPrev = 0; // initially
      
        for(int i =1;i<nums.length;i++){
            int take = nums[i];
            if(i>1) take+=prevOfPrev;
            int dontTake = 0 + prev;
            int current  = Integer.max(take,dontTake);
            prevOfPrev = prev;
            prev = current;
        }
        return prev;
    }
}