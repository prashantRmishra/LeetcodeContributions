
//TC: o(N) + o(N) for two passes,space complexity : o(N) for using list
//not optimal
// class Solution {
//     public int removeDuplicates(int[] nums) {
      
//         List<Integer> list = new ArrayList<>();
//         int count = 0;
//         for(int i : nums)
//             if(!list.contains(i))
//                list.add(i);
//         int index = 0;
//         for(Integer val: list){
//             nums[index] = val;
//             index++;
//         }
//         return list.size();
//     }
// }
class Solution {
    public int removeDuplicates(int[] nums){
        int i =0,j = i+1;
        while(j<nums.length){
            if(nums[i] == nums[j]){
                j++;
                continue;
            }
            if(nums[i] !=nums[j]){
                int temp = nums[j];
                nums[i+1] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        return i+1;
    }
}