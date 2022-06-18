class Solution {
     // approach one : power set()
   /*
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
       
        for(Integer i : nums){
             int n = list.size();
           for(int j =0;j<n;j++){
               List<Integer> tempList = new ArrayList(list.get(j));
               tempList.add(i);
               System.out.println(tempList);
               list.add(tempList);
           } 
        }
        return list;
    }*/
    // approach two recursion 
    List<List<Integer>> list  = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums){
        
        findAllSubsets(0,new ArrayList<>(),nums);
        return list;
    }
    public void findAllSubsets(int i ,List<Integer> l, int[] nums){
        if(i>=nums.length){
            System.out.println(l);
            list.add(new ArrayList<>(l));
            return;
        }
        
        l.add(nums[i]); // take
        findAllSubsets(i+1,l,nums);
        l.remove(l.size()-1); //don't take
        findAllSubsets(i+1,l,nums);
    }
}
//similary we can do for poweset of a String as well 
/*for example : abc [a,ab,abc,ac,bc,b,c ,{an empty set that we will not take into consideration}]
we can use the same logic here as well:

*/