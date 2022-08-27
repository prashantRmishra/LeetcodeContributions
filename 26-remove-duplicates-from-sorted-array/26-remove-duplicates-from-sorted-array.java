class Solution {
    public int removeDuplicates(int[] nums) {
      
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for(int i : nums)
            if(!list.contains(i))
               list.add(i);
        int index = 0;
        for(Integer val: list){
            nums[index] = val;
            index++;
        }
        return list.size();
    }
}