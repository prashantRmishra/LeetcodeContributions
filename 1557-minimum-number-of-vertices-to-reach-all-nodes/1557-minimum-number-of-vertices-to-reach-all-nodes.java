class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // following the hint that is given in the question
        //we just have to get all the nodes with indegree 0 
        //lets calculate indegrees of all the nodes
        int indegree[] = new int[n];
        for(int i =0;i<edges.size();i++){
            
            indegree[edges.get(i).get(1)]++;
            
        }
        //for(int i : indegree) System.out.println(i);
        List<Integer> list = new ArrayList<>();
        for(int i =0;i<indegree.length;i++){
            if(indegree[i]==0) list.add(i);
        }
        return list;
    }
}