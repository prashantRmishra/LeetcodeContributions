
// This problem can be solved using power set or recursion 
//we will solve it using recursion it gives TLE as the time complexity is O(2^n);
class Solution {
    int count =0;
    /*
    public int numSubseq(int[] nums, int target) {
        findSum(0,nums,target, new ArrayList<Integer>());
        return count;
    }
    public void findSum(int i, int[] nums, int target,List<Integer> list){
        if(i>=nums.length) {
            if(!list.isEmpty() && Collections.min(list)+ Collections.max(list)<=target) ++count;
            return ;
        }
            list.add(nums[i]); // take
            findSum(i+1,nums,target,list);
            list.remove(list.size()-1); // don't take
            findSum(i+1,nums,target,list); 
    }*/
    
    // approach 2 power set() // this also let to TLE :)
    /*
    public int numSubseq(int[] nums, int target){
        List<List<Integer>> list =new ArrayList<>();
        list.add(new ArrayList<>());
        for(int i : nums){
            
            int n  = list.size();
            for(int  j =0;j<n;j++){
               List<Integer> temp = new ArrayList<>(list.get(j));
                temp.add(i);
                list.add(temp);
            }
        }
        for(List<Integer> l: list){
           
            if(!l.isEmpty() && Collections.min(l)+ Collections.max(l)<=target) ++count;
        }
        return count;
    }*/
    
    //trying out the hint that is provided in the problem i.e. using two pointer solution
     public int numSubseq(int[] nums, int target){
        Arrays.sort(nums); // nums is sorted now
        int i =0,j=nums.length-1;
        int pow[]  = new int[nums.length];
        int mod = (int)1e9 +7;
        pow[0] = 1; // for one element only one subsequence is possible
        for(int k =1;k<nums.length;k++){
            pow[k] = (pow[k-1]*2)%mod;
        }
        while(i<=j){
            //System.out.println(i+" "+j);
            if(nums[i]+nums[j]<=target){
                  //System.out.println(i+" "+j);
                count= (count +pow[j-i])%mod;
                i++;
            }
            else if(nums[i]+nums[j]>target){
               j--;
            }
        }
        return count;
     }
}