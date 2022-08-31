/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    //we will use dfs for cloning the graph, we will traverse 
    //the graph in depth first search manner and create a complete clone of the given graph.
    
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        
        Node clone = new Node(node.val);
        Node[] visited = new Node[101];
        dfs(clone,node,visited);
        return clone;
        
    }
    public void dfs(Node clone, Node actual, Node[] visited){
        visited[clone.val] = clone;
        for(Node next : actual.neighbors){
            if(visited[next.val] ==null) {
                Node newNode = new Node(next.val);
                clone.neighbors.add(newNode);
                dfs(newNode,next,visited);
            }
            else {
                clone.neighbors.add(visited[next.val]);
            }
        }
    }
}