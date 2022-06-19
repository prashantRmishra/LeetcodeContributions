class Solution {
     List<List<Integer>> list  = new ArrayList<>();
    /*
    
    // this is giving time limit exceeded (TLE)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //we will use recursion to solve this problem
       Arrays.sort(candidates);
        findSubsequences(0,0,new ArrayList<>(),candidates,target);
        return list;
    }
    public void findSubsequences(int i,int sum, List<Integer> l, int[] c, int target){
        if(sum > target) return;
        if(i>=c.length){
            if(sum == target) {
                //System.out.println(l);
                List<Integer> temp = new ArrayList<>(l);
                Collections.sort(temp);
                if(!list.contains(temp))
                list.add(temp);
            }
            return;
                   
        }
            sum=sum + c[i];
            l.add(c[i]); // take
            findSubsequences(i+1,sum,l,c,target); 
            l.remove(l.size()-1);//don't take
            sum = sum - c[i];
            findSubsequences(i+1,sum,l,c,target);
     
    }
    
    */
    public List<List<Integer>> combinationSum2(int[] candidates,int target){
        Arrays.sort(candidates);
        findCombinations(0,candidates, new ArrayList<>(),target);
        return list;
    }
    public void findCombinations(int ind, int[] candidates, List<Integer> l, int target){
       
        if(target==0) {
            list.add(new ArrayList<>(l));
            return;
        }
            
        
        for(int i  =ind ;i< candidates.length;i++){
            if(i > ind && candidates[i]==candidates[i-1]) continue;
            if(candidates[i] > target) break;
            l.add(candidates[i]);
            findCombinations(i+1,candidates,l,target-candidates[i]);
            l.remove(l.size()-1);
          
        }
        
    }
}