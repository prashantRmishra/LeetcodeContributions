class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        getAllPermutations(0,nums,list);
        return list;
    }
    public void getAllPermutations(int ind, int[] nums,List<List<Integer>> list){
        if(ind==nums.length) {
            List<Integer> temp = new ArrayList<>(Arrays.stream(nums).boxed().toList());
           // Collections.sort(temp);
            if(!list.contains(temp))
                list.add(temp);
            return;
        }
        for(int i =ind;i<nums.length;i++){
          
            swap(nums,i,ind);
            getAllPermutations(ind+1,nums,list);
            swap(nums,i,ind);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}