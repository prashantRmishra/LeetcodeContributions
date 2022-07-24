class Solution {
    int count = 0;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // we can solve this using depth first traversal technique
        // since node 0 is rechable so we will visit it
        // then we wil check if it has key for node 1 (basically 0+1) 
        //we will do that recursively if the last room or node is reached i.e room.length-1 then return true else return false;
     
        int visited[] = new int[rooms.size()];
        count =1;
        return dfs(0,rooms,visited);
    }
    public boolean dfs(int i, List<List<Integer>> rooms,int[] visited){
        if(count ==rooms.size()) return true;
        visited[i] = 1;
        for(Integer  node : rooms.get(i)){
            if(visited[node]==0){
                count++;
                if(dfs(node,rooms,visited)){
                     return true;
                }
            }
        }
        //System.out.println(count +" for visiting node"+i);
        return false;
    }
}