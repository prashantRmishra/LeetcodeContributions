class Solution {
    public int missingNumber(int[] nums) {
        int i =0,n = nums.length;
        // circular sorting
        while(i<n){
            int  j = nums[i]-1;
            if(j<0) {i++ ; continue;}
            else if(nums[i]!=nums[j]) swap(nums,i,j);
            else i++;
        }
        int missing = 0;
        for(int k = 0;k<nums.length;k++){
            if(k!=nums[k]-1){ missing = k+1; break;}
        }
        return missing;
        
    }
    public void swap(int[] nums,int i,int j){
        int temp  = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}