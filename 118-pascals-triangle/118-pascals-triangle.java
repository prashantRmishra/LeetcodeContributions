class Solution {
    public List<List<Integer>> generate(int numRows) {
        // we will use simple approach
        List<List<Integer>> list = new ArrayList<>();
        for(int i =1;i<=numRows;i++){ // to keep track of row of the pyramid
            List<Integer> l = new ArrayList<>();
            int size = i;
            for(int j =0;j<size;j++){
                if(j==0) l.add(1); // it its the first index it will have 1
                
                else{// for any index between first and last 
                    //get the last row list
                    List<Integer> temp = list.get(list.size()-1);  
                    while(j<size-1){ // we will run while loop before last index
                        l.add(temp.get(j) + temp.get(j-1)); // think about it what it does,
                        /*
                            it the repvious row had 1 2 2 1
                            next row will have     1 3 3 3 1 this is what line 15 calculates 
                        */
                        j++; 
                    }
                    
                    l.add(1); // it is last index it will have value 1
                }
            }
            list.add(l);
             System.out.println(list + " size "+ size);
        }
        return list;
    }
}