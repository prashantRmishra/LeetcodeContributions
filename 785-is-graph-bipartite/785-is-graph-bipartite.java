class Solution {
    public boolean isBipartite(int[][] graph) {
        int visited[] = new int[graph.length];
        int color[] = new int[graph.length];
        Arrays.fill(color,-1);
        for(int i =0;i<graph.length;i++){
            if(color[i]==-1){
                color[i] =0;// initially color it with 0
                if(!isPossible(i,color,graph)) return false;
            }
        }
        return true;
        
    }
    public boolean isPossible(int node,int color[], int graph[][]){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Integer n = q.remove();
            for(int it: graph[n]){
                if(color[it] ==-1){
                    color[it] = 1-color[n]; // so if n's color was 0 , `it` color will be 1 , else 0
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