class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        Arrays.fill(visited,false);
        return solve(arr,start,visited);
        
    }
    boolean solve(int[] arr, int start , boolean[] visited){
       
        if(start>=arr.length || start<0) return false;
        if(arr[start] ==0) return true;
        if(visited[start] == true) return false;
        visited[start] = true;
        return solve(arr,start-arr[start],visited) || solve(arr,start+arr[start],visited);
           
      
       
        
    }
}