// class Solution {
//     public List<Integer> findDuplicates(int[] nums) {
//         List<Integer> result =new ArrayList<>();
//         Set<Integer> set = new HashSet<>();
//         for(int i  : nums){
//             if(!set.add(i)){
//                 result.add(i);
//             }
//         }
//         return result;
//     }
// }
//the above approach is useless though it works, as it is not using space of O(1)
class Solution {
    public List<Integer> findDuplicates(int[] nums){
        List<Integer> list = new ArrayList<>();
        int i =0,n  = nums.length;
        while(i<n){
            int j = nums[i]-1;
            if(nums[i]!=nums[j]){
                swap(nums,i,j);
            }
            else i++;
        }
        for(int j =0;j<n;j++){
            if(nums[j]!=j+1) list.add(nums[j]);
        }
        return list;
    }
    public void swap(int[] nums,int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}