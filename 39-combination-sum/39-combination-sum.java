class Solution {
    List<List<Integer>> list  = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //we will use recursion to solve this problem
       
        findSubsequences(0,0,new ArrayList<>(),candidates,target);
        return list;
    }
    public void findSubsequences(int i,int sum, List<Integer> l, int[] c, int target){
        if(sum > target) return;
        if(i>=c.length){
            if(sum == target) {
                //System.out.println(l);
                list.add(new ArrayList<>(l));
            }
            return;
                   
        }
            sum=sum + c[i];
            l.add(c[i]); // take
            findSubsequences(i,sum,l,c,target); // we are picking the same index again as 
        // according to the question same candidate can be picked any number of times
            l.remove(l.size()-1);//don't take
            sum = sum - c[i];
            findSubsequences(i+1,sum,l,c,target); // picking different candidte this time
     
    }
}