class Solution {
    public int findCircleNum(int[][] isConnected) {
        int visited[]= new int[isConnected.length];
        int count = 0;
        for(int i =0;i<isConnected.length;i++){
            if(visited[i]==0){
                count++;
                dfs(i,visited,isConnected);
            }
        }
        return count;
    }
    public void dfs(int i, int[] visited, int[][] g){
        visited[i] = 1;
        for(int j =0;j<g[0].length;j++){
            if(visited[j]==0 && g[i][j]==1) dfs(j,visited,g);
        }
    }
}