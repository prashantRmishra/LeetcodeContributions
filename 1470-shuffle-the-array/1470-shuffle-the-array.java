class Solution {
    public int[] shuffle(int[] nums, int n) {
        int i = 0, j =n;
        int[] result = new int[nums.length];
        int p =0;
        while(i<n && j<nums.length && p < nums.length-1){
            System.out.println(nums[i] +  " "+nums[j]);
            result[p] = nums[i]; 
            result[p+1] = nums[j];
            p=p+2;
            i++;
            j++;
        }
        return result;
    }
}