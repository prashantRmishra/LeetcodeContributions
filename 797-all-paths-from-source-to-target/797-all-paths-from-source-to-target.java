class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // we have to find all the possible path to from source to destination.
        // we can do that with depth first search.
        //we can keep track of visted nodes in a list in a depth first search manner.
        //if we reach the target node we will store list, and we will backtrack to adjacent nodes of the previous node to check all the possible paths
        List<List<Integer>> list = new ArrayList<>();
        dfs(0,graph,new ArrayList<>(Arrays.asList(0)),list); //initially we are also adding 0 in the list l, as the starting node
        return list;
    }
    public void dfs(int node, int[][] graph,List<Integer> l, List<List<Integer>> list){
        if(node ==graph.length-1){
            list.add(new ArrayList<>(l));
            return;
        }
        // below loop will give array of all adjacent nodes of current node i.e 'node'
        for(int i : graph[node]){
            //take
            l.add(i);
            dfs(i,graph,l,list);
            //don't take
            l.remove(l.size()-1);
        }
    }
}