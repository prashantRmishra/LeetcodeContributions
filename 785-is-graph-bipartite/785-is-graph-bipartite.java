class Solution {
    // using depth first search for checking bipartite graph
    public boolean isBipartite(int[][] graph) {
        
        int color[] = new int[graph.length];
        Arrays.fill(color,-1);
        for(int i =0;i<graph.length;i++){
            if(color[i]==-1){
                color[i] = 1;
                if(!isPossible(i,color,graph)) return false;
            }
        }
        return true;
    }
    public boolean isPossible(int n, int[] color,int[][] graph){
        for(int node : graph[n]){
            if(color[node]==-1){
                color[node] = 1-color[n];
                if(!isPossible(node,color,graph)) return false;
            }
            else if (color[node] ==color[n]) return false;
        }
        return true;
    }
}