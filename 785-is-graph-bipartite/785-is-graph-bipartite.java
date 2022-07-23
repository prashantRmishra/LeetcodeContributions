class Solution {
    public boolean isBipartite(int[][] graph) {
        // ArrayList<ArrayList<Integer>> list =new ArrayList<>();
        // for(int i =0;i<graph.length;i++){
        //     list.add(new ArrayList<>());
        // }
        // for(int  i =0;i<graph.length;i++){
        //     for(int j =0;j<graph[i].length;j++){
        //         ArrayList<Integer> l = list.get(i);
        //         l.add(graph[i][j]);
        //         list.set(i,l);
        //     }
        //}
        int visited[] = new int[graph.length];
        int color[] = new int[graph.length];
        for(int i =0;i<graph.length;i++){
            if(visited[i]==0){
                visited[i] =1;
                color[i] =0;
                if(!isPossible(i,visited,color,graph)) return false;
            }
        }
        return true;
        
    }
    public boolean isPossible(int node, int[] visited, int color[], int graph[][]){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Integer n = q.remove();
            for(int it: graph[n]){
                if(visited[it]==0){
                    visited[it] = 1;
                    if(color[n]==0) color[it] = 1;
                    else color[it] =0;
                    q.add(it);
                }
                else if(color[it]==color[n]){
                     return false;
                }
            }
        }
        return true;
    }
}