import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        ArrayList<String> str = new ArrayList<>();
        for(int p=0;p<nums.length;p++){
            str.add(nums[p]+"");
        }
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        while(i<j){
            if(nums[i]+nums[j] == target) break;
            else if(nums[i]+nums[j] > target) j--;
            else i++;
        }
        int x[] = new int[2];
        x[0] = str.indexOf(nums[i]+"");
        str.set(x[0],"");
        x[1] = str.indexOf(nums[j]+"");
         return x;
        
    }
}