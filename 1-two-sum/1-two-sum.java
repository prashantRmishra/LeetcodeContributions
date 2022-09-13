import java.util.*;
class Solution {
    public int[] twoSum(int[] A, int target) {
            HashMap<Integer,Integer> map = new HashMap<>();
		for(int i =0;i<A.length;i++){
            if(map.containsKey(target-A[i])) return new int[]{i,map.get(target-A[i])};
            map.put(A[i],i);
        }
		
		return new int[0];
        
    }
}