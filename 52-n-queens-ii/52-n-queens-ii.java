class Solution {
    public int totalNQueens(int n) {
          List<String> s  = new ArrayList<>();
        String str = ".".repeat(n);
        for(int i =0;i<n;i++)s.add(str);
      // System.out.println(s);
        List<List<String>> board   =  new ArrayList<>();
        solve(0,s,board);
        return board.size();
    }
    public void solve(int col, List<String> s,List<List<String>> board){
        //base case;
        if(col==s.size()){
             board.add(new ArrayList<>(s));
            return;
        }
        
        for(int row =0;row<s.size();row++){
            if(isSafe(row,col,s)){
                char c[] = s.get(row).toCharArray();
                c[col] = 'Q';
                s.set(row,new String(c));
                //System.out.println(s);
                solve(col+1,s,board);
                 c[col] = '.';
                s.set(row,new String(c));
                
            }
        }
    }
    public boolean isSafe(int row, int col,List<String> s){
        int currentRow = row;
        int currentColumn = col;
        // check for upper left diagonal
         //System.out.println(currentColumn);
        while(currentRow>=0 && currentColumn>=0){
            String str = s.get(currentRow);
           
            if(str.charAt(currentColumn)=='Q') return false;
            currentRow--;
            currentColumn--;
        }
        // check for lower left diagonal
        currentRow = row;
        currentColumn = col;
        while(currentRow<s.size() && currentColumn>=0){
            String str = s.get(currentRow);
            if(str.charAt(currentColumn)=='Q') return false;
            currentRow++;
            currentColumn--;
        }
        //check for in the same row backwords
        currentRow = row;
        currentColumn = col;
        while(currentColumn>=0){
            String str = s.get(currentRow);
            if(str.charAt(currentColumn)=='Q') return false;
            currentColumn--;
        }
        return true;
    }
}