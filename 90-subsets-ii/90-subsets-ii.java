
// approach one : using recursion : though this solutions works but,
 // if we think of tc its o(2^n)k.logk // as o(2^n) for recursion , k : if we assume average length of each subset is k , then k subsets are put in another List i.e. 'list', hence klogk for sorting list of size k 
// moral of the story is we will have to optimize this solution to get a better tc
/*
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
**/

// solution 2 
// optimal sol :tc o(2^n)*k
class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        findSubsets(0,nums,new ArrayList<>());
        return list;
        
    }
    public void findSubsets(int i, int[] nums, List<Integer> l){
        List<Integer> temp = new ArrayList<>(l);
        list.add(temp);
        for(int p = i;p<nums.length;p++){
            if(p>i && nums[p]==nums[p-1]) continue;
            l.add(nums[p]);
            findSubsets(p+1,nums,l);
            l.remove(l.size()-1);
        }
        
    }
}