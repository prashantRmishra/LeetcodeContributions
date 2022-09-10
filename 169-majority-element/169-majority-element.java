class Solution {
    public int majorityElement(int[] nums) {
        int limit = nums.length/2;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i: nums){
            int val  = map.getOrDefault(i,0);
            if(val == limit) return i;
            map.put(i,val+1);
        }
       
        return -1;
    }
    
}