class Solution {
    public boolean canCross(int[] stones) {
        
        // for(int i =3;i<stones.length;i++){
        //     if(stones[i]> stones[i-1]*2) return false;
        // }
        Stack<Integer> locations = new Stack<>();
        Stack<Integer> distanceTravelled  = new Stack<>();
        Set<Integer> set = new HashSet<>();
        Set<List<Integer>> visited = new HashSet<>();
        int lastStone = stones[stones.length-1];
        for(int stone: stones) set.add(stone);
        
        locations.add(0);// current location is 0 as the starting index
        distanceTravelled.add(0);// distance travelled to reach to the current location 0 is 0 distance;
        while(!locations.isEmpty()){
            int currentLocation = locations.pop();
            int distanceTravelledToReachCurrentLocation = distanceTravelled.pop();
            for(int i = distanceTravelledToReachCurrentLocation-1;i<=distanceTravelledToReachCurrentLocation +1;i++){
                if(i<=0) continue; // as we don't want to jump at the same location or go backword;
                int newLocation = currentLocation +i;
                List<Integer> list =new ArrayList<>();
                list.add(newLocation);
                list.add(i);
               
                if(newLocation == lastStone) return true;
                else if (set.contains(newLocation) && !visited.contains(list)){
                    locations.add(newLocation);
                    distanceTravelled.add(i);
                     visited.add(list);
                }
            }
           
        }
         return false;
    }
}