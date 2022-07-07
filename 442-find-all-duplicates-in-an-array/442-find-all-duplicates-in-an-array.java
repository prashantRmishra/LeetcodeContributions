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

/*
cycle sort : it will put element to its indexes ie 1 will be at index 0, 2 will be at index 1 and so on
Example : 
[4, 3, 2, 7, 8, 2, 3, 1]
i =0
[7, 3, 2, 4, 8, 2, 3, 1]
[3, 3, 2, 4, 8, 2, 7, 1]
[2, 3, 3, 4, 8, 2, 7, 1]
[3, 2, 3, 4, 8, 2, 7, 1] as 3 = arr[2] hence i++;
i =1
[3, 2, 3, 4, 8, 2, 7, 1] as 2 = arr[1] hence i++;
i =2;
[3, 2, 3, 4, 8, 2, 7, 1] as 3 = arr[2] hence i++;
i = 3
[3, 2, 3, 4, 8, 2, 7, 1] as 4 = arr[3] hence i++;
i=4;
[3, 2, 3, 4, 1, 2, 7, 8]
[1, 2, 3, 4, 3, 2, 7, 8] as 3 = arr[2] hence i++;
i=5, as 2 = arr[1] hence i++;
i =6;

*/
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