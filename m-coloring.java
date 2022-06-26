//m coloring 
// java solution
solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int colorArray[] = new int[n];
       
       
       return solve(graph,m,n,0,colorArray);
    }
    public boolean solve(boolean [][] graph, int m,int n,int nodeIndex, int[] colorArray){
        
        if(nodeIndex ==n) return true;
        
        for(int i =1;i<=m;i++){
            if(isPossible(graph,nodeIndex,colorArray,i)){
                colorArray[nodeIndex] = i;
               
                if(solve(graph,m,n,nodeIndex+1,colorArray)==true) return true;
                colorArray[nodeIndex] = 0;
            }
        }
        return false;
    }
    boolean isPossible(boolean[][] graph, int index, int [] colorArray,int colorCode){
        for( int col =0;col<graph.length;col++){
            if(graph[index][col]){
                if(colorArray[col] == colorCode) return false;
            }
        }
        
        return true;
    }
}
