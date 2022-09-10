class Solution {
    public int majorityElement(int[] nums) {
        int limit = nums.length/2;
        PriorityQueue<Map.Entry<Integer,Integer>> q = new PriorityQueue<>(
        (a,b)->b.getValue()-a.getValue());
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
           // q.add(entry);
            if(entry.getValue() > limit) return entry.getKey();
        }
        // int temp = q.remove().getKey();
        // while(!q.isEmpty()){
        //     Map.Entry<Integer,Integer> entry = q.remove();
        //     int key = entry.getKey();
        //     int value = entry.getValue();
        //     if(value > limit) temp = key;
        // }
        // return temp;
        return -1;
    }
    
}