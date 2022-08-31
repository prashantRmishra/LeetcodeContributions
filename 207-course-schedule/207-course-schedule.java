class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i =0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        //getting indegrees of all the nodes
        int indegree[] = new int[numCourses];
        for(int i =0;i<prerequisites.length;i++){
            indegree[prerequisites[i][0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<numCourses;i++){
            if(indegree[i]==0) q.add(i);
        }
        // create adjacency matrix in ArrayList
         for(int i=0;i<prerequisites.length;i++){
            ArrayList<Integer> l2 = graph.get(prerequisites[i][1]);
            l2.add(prerequisites[i][0]);
            graph.set(prerequisites[i][1],l2);
        }
        
        int count =0;
        while(!q.isEmpty()){
            int node = q.remove();
            count++;
            for(Integer it : graph.get(node)){
                indegree[it]--;
                if(indegree[it] ==0) q.add(it);
            }
        }
       return count ==numCourses;
    }
    public boolean breadhFirstSearch(int[] visited,int node,ArrayList<ArrayList<Integer>> list){
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        q.add(new Pair(node,-1)); // parent of starting node will be -1
        while(!q.isEmpty()){
            Pair<Integer,Integer> p  = q.remove();
            int n = p.getKey();
            int parent  = p.getValue();
            for(int vertex : list.get(n)){
                if(visited[vertex]==0){
                    visited[vertex] =1;
                    q.add(new Pair(vertex,n));
                }
                else if (vertex!=parent) return false;
            }
           
        }
         return true;
    }
}