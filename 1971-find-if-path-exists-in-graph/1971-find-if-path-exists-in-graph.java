class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        //we will use adjacency matrix for it
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for( int i =0;i<n;i++){
            list.add(new ArrayList<>());
        }
       
       
        for(int i =0;i<edges.length;i++){
         
            
            ArrayList<Integer> l = list.get(edges[i][0]);
            l.add(edges[i][1]);
            ArrayList<Integer> l2 = list.get(edges[i][1]);
            l2.add(edges[i][0]);
            
            list.set(edges[i][0],l);
            list.set(edges[i][1],l2);
        }
        
        int visited[] = new int[list.size()];
        Arrays.fill(visited,0);
        return isReachable(source,destination,list,visited);
        
    }
    public boolean isReachable(int s, int destination, ArrayList<ArrayList<Integer>> list, int[] visited){
        visited[s] = 1;
        for(Integer node : list.get(s)){
            if(node == destination) return true;
            if(visited[node] ==0){
                if(isReachable(node,destination,list,visited))return true;
            }
            
        }
        return false;
    }
}