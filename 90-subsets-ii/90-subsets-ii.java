class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // for getting all the possible subsets we can use recursion the 
        // way we used for subset I 
        // but we will have to avoid having duplicates 
        findSubsets(0,nums,new ArrayList<>());
        return list;
        
    }
    public void findSubsets(int i, int[] nums, List<Integer> l){
        if(i>=nums.length) {
            List<Integer> temp = new ArrayList<>(l);
            Collections.sort(temp);
            if(!list.contains(temp))
                list.add(temp);
            return;
        }
        l.add(nums[i]);
        findSubsets(i+1,nums,l);
        l.remove(l.size()-1);
        findSubsets(i+1,nums,l);
    }
}