class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result =new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i  : nums){
            if(!set.add(i)){
                result.add(i);
            }
        }
        return result;
    }
}