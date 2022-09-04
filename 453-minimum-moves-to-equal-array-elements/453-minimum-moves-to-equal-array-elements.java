class Solution {
    public int minMoves(int[] nums) {
        //instead we will try to find min value in the array
        // and once we have found the min value in the array then all the values x in the array
        // will have to be decremented x-min times to be equals to min value 
        // so by that way we will be able to find the min moves to make all elements equal
        int min = nums[0];
        for(int i=1;i<nums.length;i++) if( min > nums[i]) min = nums[i];
        int sum  = nums[0] -min;
        for(int i =1;i<nums.length;i++){
            sum+=nums[i]-min;
        }
        return sum;
    }
    
}